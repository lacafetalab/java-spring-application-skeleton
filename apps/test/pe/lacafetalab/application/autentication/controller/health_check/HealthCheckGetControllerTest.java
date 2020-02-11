package pe.lacafetalab.application.autentication.controller.health_check;


import org.junit.jupiter.api.Test;
import pe.lacafetalab.application.ApplicationTestCase;

final class HealthCheckGetControllerTest extends ApplicationTestCase {
    @Test
    void check_the_app_is_working_ok() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }
}