package pe.lacafetalab.pao.courses.application.create;


import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.courses.domain.Course;
import pe.lacafetalab.pao.courses.domain.CourseRepository;

import static org.mockito.Mockito.*;

class CourseCreatorTest {

    @Test
    void save_a_valid_course() {
        CourseRepository repository = mock(CourseRepository.class);
        CourseCreator creator = new CourseCreator(repository);

        Course course = new Course("some-id","some-name","some-duration");

        creator.create(course.id(),course.name(),course.duration());

        verify(repository,atLeastOnce()).save(course);
    }
}