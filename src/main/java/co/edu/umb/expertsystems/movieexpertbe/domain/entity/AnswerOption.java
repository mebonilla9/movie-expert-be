package co.edu.umb.expertsystems.movieexpertbe.domain.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "answer_option")
public class AnswerOption {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_option_seq")
  @SequenceGenerator(name = "answer_option_seq")
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(nullable = false, length = 60)
  private String option;

  @ManyToOne
  @JoinColumn(name = "id_ask", nullable = false)
  private Ask ask;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    AnswerOption that = (AnswerOption) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}