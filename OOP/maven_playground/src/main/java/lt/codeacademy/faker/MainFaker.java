package lt.codeacademy.faker;

import com.github.javafaker.Faker;

public class MainFaker {
    private static final int MAX = 100;
    public static void main(String[] args) {
        Faker faker = new Faker();

        for (int i = 0; i < MAX; i++) {
            System.out.println(faker.address().streetAddress());
        }


    }
}
