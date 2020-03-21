package pe.lacafetalab.pao.courses.domain;

import pe.lacafetalab.shared.domain.WordMother;

public class CourseNameMother {
    public static CourseName create(String value) {
        return new CourseName(value);
    }

    public static CourseName random() {
        return create(WordMother.random());
    }
}