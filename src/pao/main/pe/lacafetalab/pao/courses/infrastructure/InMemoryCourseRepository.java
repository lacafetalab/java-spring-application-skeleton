package pe.lacafetalab.pao.courses.infrastructure;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.courses.domain.Course;
import pe.lacafetalab.pao.courses.domain.CourseRepository;

import java.util.HashMap;
import java.util.Optional;

@Service
public class InMemoryCourseRepository implements CourseRepository {
    private HashMap<String,Course> courses = new HashMap<>();
    @Override
    public void save(Course course) {
        this.courses.put(course.id().value(),course);
    }

    @Override
    public Optional<Course> search(String id) {
        return Optional.ofNullable(courses.get(id));
    }
}
