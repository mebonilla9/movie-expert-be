package co.edu.umb.expertsystems.movieexpertbe.domain.repository;

import co.edu.umb.expertsystems.movieexpertbe.domain.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}