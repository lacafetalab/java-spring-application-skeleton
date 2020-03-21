package pe.lacafetalab.pao.courses;

import org.springframework.beans.factory.annotation.Autowired;
import pe.lacafetalab.pao.courses.infrastructure.InMemoryCourseRepository;
import pe.lacafetalab.shared.infrastructure.InfrastructureTestCase;

public class CoursesModuleInfrastructureTestCase extends InfrastructureTestCase {

    @Autowired
    protected InMemoryCourseRepository repository;
}
