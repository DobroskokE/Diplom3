package apistellarburgers;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUser {
    @Step("Create user")
    public static Response createUser(User user) {
        Response responseCreateUser =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(user)
                        .when()
                        .post("https://stellarburgers.nomoreparties.site/api/auth/register");
        return responseCreateUser;
    }
}