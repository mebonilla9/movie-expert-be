package co.edu.umb.expertsystems.movieexpertbe.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "`case`")
public class Case {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "case_seq")
  @SequenceGenerator(name = "case_seq")
  private Integer id;

  @Column(nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime date;

  @ManyToOne
  @JoinColumn(name = "id_client", nullable = false)
  private Client client;

  @ManyToMany(mappedBy = "cases")
  private Set<Ask> asks;

  @OneToMany(mappedBy = "_case")
  private Set<Suggest> suggests;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Case aCase = (Case) o;
    return id != null && Objects.equals(id, aCase.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}