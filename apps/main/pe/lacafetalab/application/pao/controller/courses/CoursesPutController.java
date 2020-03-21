package pe.lacafetalab.application.pao.controller.courses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.lacafetalab.pao.courses.application.create.CourseCreator;

@RestController
public final class CoursesPutController {
    private CourseCreator creator;

    public CoursesPutController(CourseCreator creator) {
        this.creator = creator;
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity create(@PathVariable String id, @RequestBody Request request) {
        this.creator.create(id, request.getName(), request.getDuration());
        return new ResponseEntity(HttpStatus.CREATED);

    }
}

final class Request {
    private String name;
    private String duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
