package pe.lacafetalab.pao.courses.application.create;

//import pe.lacafetalab.shared.domain.Service;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.courses.domain.Course;
import pe.lacafetalab.pao.courses.domain.CourseRepository;

@Service
public final class CourseCreator {
    private CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String name, String duration) {

        Course course = new Course(id,name,duration);

        this.repository.save(course);

    }
}
