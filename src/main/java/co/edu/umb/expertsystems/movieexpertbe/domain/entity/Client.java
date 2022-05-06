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
@Table(name = "client")
public class Client {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
  @SequenceGenerator(name = "client_seq")
  private Integer id;

  @Column(nullable = false)
  private String fullName;

  @Column(nullable = true, columnDefinition = "TIMESTAMP")
  private LocalDateTime createdAt;

  @OneToMany(mappedBy = "client")
  private Set<Case> cases;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Client client = (Client) o;
    return id != null && Objects.equals(id, client.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}