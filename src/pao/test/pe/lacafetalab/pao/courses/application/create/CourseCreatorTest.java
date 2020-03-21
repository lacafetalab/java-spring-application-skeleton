package pe.lacafetalab.pao.courses.application.create;


import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.courses.domain.*;

import static org.mockito.Mockito.*;

class CourseCreatorTest {

    @Test
    void save_a_valid_course() {
        CourseRepository repository = mock(CourseRepository.class);
        CourseCreator creator = new CourseCreator(repository);

        Course course = new Course(
                new CourseId("a6c360f7-e8f4-43d8-a9bf-3e47bbeb71e7"),
                new CourseName("some-name"),
                new CourseDuration("some-duration")
        );

        creator.create(new CreateCourseRequest(course.id().value(), course.name().value(), course.duration().value()));

        verify(repository, atLeastOnce()).save(course);
    }
}