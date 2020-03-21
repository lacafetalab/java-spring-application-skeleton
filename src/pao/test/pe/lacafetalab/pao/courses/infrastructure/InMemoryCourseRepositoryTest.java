package pe.lacafetalab.pao.courses.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.courses.domain.Course;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryCourseRepositoryTest {
    @Test
    void save_a_valid_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        repository.save(new Course("some-id", "some-name", "some-duration"));
    }

    @Test
    void search_an_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();
        Course course = new Course("some-id", "some-name", "some-duration");
        repository.save(course);
        Assert.assertEquals(Optional.of(course), repository.search(course.id()));
    }

    @Test
    void not_find_a_nom_existing_course() {
        InMemoryCourseRepository repository = new InMemoryCourseRepository();

        Assert.assertFalse(repository.search("non-existing-id").isPresent());
    }
}