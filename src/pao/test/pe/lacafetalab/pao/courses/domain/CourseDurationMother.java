package pe.lacafetalab.pao.courses.domain;

import pe.lacafetalab.shared.domain.WordMother;

import static org.junit.jupiter.api.Assertions.*;

public class CourseDurationMother {
    public static CourseDuration create(String value) {
        return new CourseDuration(value);
    }

    public static CourseDuration random() {
        return create(WordMother.random());
    }
}