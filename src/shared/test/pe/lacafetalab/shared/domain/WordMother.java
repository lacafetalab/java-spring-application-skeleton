package pe.lacafetalab.shared.domain;

import com.github.javafaker.Faker;

public final class WordMother {
    public static String random(){
        return Faker.instance().lorem().word();
    }
}
