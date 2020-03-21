package pe.lacafetalab.apps.pao.controller.courses;

import org.junit.jupiter.api.Test;
import pe.lacafetalab.apps.RequestTestCase;

public final class CoursesPutControllerTest extends RequestTestCase {
    @Test
    void create_a_valid_course() throws Exception{
        assertRequestWithBody(
                "PUT",
                "/courses/11ec643f-fa64-4a87-8b87-6e0bca9686f6",
                "{\"name\":\"the best course\",\"duration\":\"5 hours\"}",
                201);
    }
}
