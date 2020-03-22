package pe.lacafetalab.pao.courses.infrastructure.persistence.springjpa;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.courses.domain.Course;
import pe.lacafetalab.pao.courses.domain.CourseId;
import pe.lacafetalab.pao.courses.domain.CourseRepository;

import java.util.Optional;


public class SqlCourseRepository implements CourseRepository {

    private CourseJpa courseJpa;

    public SqlCourseRepository(CourseJpa courseJpa) {
        this.courseJpa = courseJpa;
    }

    @Override
    public void save(Course course) {
        courseJpa.save(new CourseDao(course));
    }

    @Override
    public Optional<Course> search(CourseId id) {
        Optional<CourseDao> courseDao= courseJpa.findById(id.value());
        return Optional.of(courseDao.get().toEntity());
    }
}
