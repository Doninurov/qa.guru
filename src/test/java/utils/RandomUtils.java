package utils;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en"));

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomName() {
        return new Faker().name().firstName();
    }

    String userName = faker.name().firstName(),
            userAdress = faker.address().fullAddress(),
            userEmail2 = faker.internet().emailAddress(),
            userNum = "+998" + String.valueOf(faker.number().numberBetween(100000000,999999999));

    @Test
    public void randomint() {
        System.out.println(getRandomInt(10, 30));
        System.out.println(getRandomName());
        System.out.println(userName);
        System.out.println(userNum);
    }

}
