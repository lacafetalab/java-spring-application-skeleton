package pe.lacafetalab.pao.courses.infrastructure.persistence.springjpa;

import org.springframework.data.repository.CrudRepository;

public interface CourseJpa extends CrudRepository<CourseDao, String> {
}
