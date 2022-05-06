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
@Table(name = "suggest",
  uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_case", "id_movie"}, name = "answer_per_ask")
  })
public class Suggest {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "suggest_seq")
  @SequenceGenerator(name = "suggest_seq")
  private Integer id;

  @Column(nullable = false)
  private Double probability;

  @Column(nullable = false)
  private Boolean likeSuggestMovie;

  @ManyToOne
  @JoinColumn(name = "id_case", nullable = false)
  private Case _case;

  @ManyToOne
  @JoinColumn(name = "id_movie", nullable = false)
  private Movie movie;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Suggest suggest = (Suggest) o;
    return id != null && Objects.equals(id, suggest.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}