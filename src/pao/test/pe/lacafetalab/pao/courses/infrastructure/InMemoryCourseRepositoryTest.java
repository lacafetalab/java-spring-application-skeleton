package pe.lacafetalab.pao.courses.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.courses.domain.Course;
import pe.lacafetalab.pao.courses.domain.CourseDuration;
import pe.lacafetalab.pao.courses.domain.CourseId;
import pe.lacafetalab.pao.courses.domain.CourseName;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCourseRepositoryTest {
    @Test
    void save_a_valid_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = new Course(
                new CourseId("32acc36c-70d3-4817-8875-a2d960e19c7f"),
                new CourseName("some-name"),
                new CourseDuration("some-duration")
        );
        repository.save(course);
    }

    @Test
    void search_an_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = new Course(new CourseId("349a2d7c-38ed-45fd-853a-0de31943fc3f"), new CourseName("some-name"), new CourseDuration("some-duration"));
        repository.save(course);
        Assert.assertEquals(Optional.of(course), repository.search(course.id().value()));
    }

    @Test
    void not_find_a_nom_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Assert.assertFalse(repository.search("non-existing-id").isPresent());
    }
}