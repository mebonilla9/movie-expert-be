package co.edu.umb.expertsystems.movieexpertbe.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ask")
public class Ask {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ask_seq")
  @SequenceGenerator(name = "ask_seq")
  private Integer id;

  @Column(nullable = false, length = 120)
  private String value;

  @OneToMany(mappedBy = "ask")
  private Set<AnswerOption> answers;

  @ManyToMany
  @JoinTable(name = "answer",
    joinColumns = @JoinColumn(name = "id_ask"),
    inverseJoinColumns = @JoinColumn(name = "id_case"))
  private Set<Case> cases;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Ask ask = (Ask) o;
    return id != null && Objects.equals(id, ask.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}