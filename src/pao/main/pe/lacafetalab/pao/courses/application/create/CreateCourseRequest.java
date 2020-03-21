package pe.lacafetalab.pao.courses.application.create;

import java.util.Objects;

public class CreateCourseRequest {
    private String id;
    private String name;
    private String duration;

    public CreateCourseRequest(String id, String name, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String duration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateCourseRequest)) return false;
        CreateCourseRequest that = (CreateCourseRequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(duration, that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
