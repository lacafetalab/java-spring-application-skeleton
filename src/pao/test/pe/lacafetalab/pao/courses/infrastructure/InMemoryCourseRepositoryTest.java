package pe.lacafetalab.pao.courses.infrastructure;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pe.lacafetalab.pao.courses.CoursesModuleInfrastructureTestCase;
import pe.lacafetalab.pao.courses.domain.*;

import java.util.Optional;

class InMemoryCourseRepositoryTest extends CoursesModuleInfrastructureTestCase {
    @Test
    void save_a_valid_course() {
        Course course = CourseMother.random();
        repository.save(course);
    }

    @Test
    void search_an_existing_course() {
        Course course = CourseMother.random();
        repository.save(course);
        Assert.assertEquals(Optional.of(course), repository.search(course.id()));
    }

    @Test
    void not_find_a_nom_existing_course() {
        Assert.assertFalse(repository.search(CourseIdMother.random()).isPresent());
    }
}