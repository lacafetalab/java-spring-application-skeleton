package pe.lacafetalab.pao.courses.application.create;


import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.courses.domain.*;

import static org.mockito.Mockito.*;

class CourseCreatorTest {

    @Test
    void save_a_valid_course() {
        CourseRepository repository = mock(CourseRepository.class);
        CourseCreator creator = new CourseCreator(repository);

        CreateCourseRequest request = CreateCourseRequestMother.random();

        Course course = CourseMother.fromRequest(request);

        creator.create(request);

        verify(repository, atLeastOnce()).save(course);
    }
}