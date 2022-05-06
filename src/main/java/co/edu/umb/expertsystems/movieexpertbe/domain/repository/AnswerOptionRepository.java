package co.edu.umb.expertsystems.movieexpertbe.domain.repository;

import co.edu.umb.expertsystems.movieexpertbe.domain.entity.AnswerOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Integer> {
}