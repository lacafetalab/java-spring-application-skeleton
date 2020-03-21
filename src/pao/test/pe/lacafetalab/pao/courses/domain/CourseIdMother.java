package pe.lacafetalab.pao.courses.domain;

import pe.lacafetalab.base.ddd.domain.types.implement.TypeUUIDImp;
import pe.lacafetalab.shared.domain.WordMother;

import static org.junit.jupiter.api.Assertions.*;

public class CourseIdMother {
    public static CourseId create(String value) {
        return new CourseId(value);
    }

    public static CourseId random() {
        return create(TypeUUIDImp.randon().value());
    }
}

