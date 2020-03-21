package pe.lacafetalab.pao.courses.application.create;

//import pe.lacafetalab.shared.domain.Service;

import org.springframework.stereotype.Service;
import pe.lacafetalab.pao.courses.domain.*;

@Service
public final class CourseCreator {
    private CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    public void create(CreateCourseRequest request) {

        Course course = new Course(
                new CourseId(request.id()),
                new CourseName(request.name()),
                new CourseDuration(request.duration()));

        this.repository.save(course);

    }
}
