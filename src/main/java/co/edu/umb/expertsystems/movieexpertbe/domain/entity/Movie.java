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
@Table(name = "movie")
public class Movie {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
  @SequenceGenerator(name = "movie_seq")
  private Integer id;

  @Column(nullable = false, length = 60)
  private String name;

  @Column(nullable = false)
  private Integer year;

  @OneToMany(mappedBy = "movie")
  private Set<Suggest> suggests;

  @ManyToMany
  @JoinTable(name = "movie_category",
    joinColumns = @JoinColumn(name = "id_movie"),
    inverseJoinColumns = @JoinColumn(name = "id_category"))
  private Set<Category> categories;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Movie movie = (Movie) o;
    return id != null && Objects.equals(id, movie.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}