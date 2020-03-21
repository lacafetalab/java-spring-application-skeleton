package pe.lacafetalab.apps.pao.controller.health_check;


import org.junit.jupiter.api.Test;
import pe.lacafetalab.apps.RequestTestCase;

final class HealthCheckGetControllerTest extends RequestTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}