package pe.lacafetalab.pao.courses.application.create;

import pe.lacafetalab.pao.courses.domain.*;

public class CreateCourseRequestMother {
    public static CreateCourseRequest create(CourseId id, CourseName name, CourseDuration duration) {
        return new CreateCourseRequest(id.value(), name.value(), duration.value());
    }

    public static CreateCourseRequest random() {
        return create(CourseIdMother.random(), CourseNameMother.random(), CourseDurationMother.random());
    }

}