package pe.lacafetalab.pao.courses.application.create;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.courses.domain.*;

import static org.mockito.Mockito.*;

class CourseCreatorTest {
    private CourseCreator creator;
    private CourseRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = mock(CourseRepository.class);
        creator = new CourseCreator(repository);
    }

    protected void shouldHaveSaved(Course course){
        verify(repository, atLeastOnce()).save(course);
    }

    @Test
    void save_a_valid_course() {

        CreateCourseRequest request = CreateCourseRequestMother.random();

        Course course = CourseMother.fromRequest(request);

        creator.create(request);

        shouldHaveSaved(course);


    }
}