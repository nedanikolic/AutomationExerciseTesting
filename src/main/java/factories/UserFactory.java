package factories;

import com.github.javafaker.Faker;
import models.UserData;

public class UserFactory {
    private static final Faker faker = new Faker();

    public static UserData createRandomUser(){
        UserData user = new UserData();
        user.password = faker.internet().password();
        user.firstName = faker.name().firstName();
        user.lastName = faker.name().lastName();
        user.address = faker.address().streetAddress();
        user.state = faker.address().state();
        user.city = faker.address().city();
        user.zipCode = faker.address().zipCode();
        user.mobilePhone = faker.phoneNumber().cellPhone();
        user.country = "Canada";
        user.randomNameLoginPage = faker.name().username();
        user.randomEmail = faker.internet().emailAddress();
        return user;
    }
}
