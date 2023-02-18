package store.playmusicmarket.api.service;

import store.playmusicmarket.api.model.User;
import store.playmusicmarket.api.pojo.MessageFailedLogin;
import store.playmusicmarket.api.pojo.SuccessLogInUser;
import store.playmusicmarket.api.specification.Specifications;
import store.playmusicmarket.api.utils.Endpoint;

import static io.restassured.RestAssured.given;

public class UserLoginService {

    public MessageFailedLogin postLoginUserWithNotCorrectData(User user) {
        Specifications.installSpecification(Specifications.requestSpecification(),
                Specifications.responseSpecification(500));
        return given()
                .body(user)
                .post(Endpoint.LOGIN_USER)
                .then()
                .log()
                .all()
                .extract()
                .as(MessageFailedLogin.class);
    }

    public String postLoginUserWithCorrectData(User user) {
        Specifications.installSpecification(Specifications.requestSpecification(),
                Specifications.responseSpecification(200));
        SuccessLogInUser successLogInUser = given()
                .body(user)
                .post(Endpoint.LOGIN_USER)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .jsonPath()
                .getObject("user", SuccessLogInUser.class);
        return successLogInUser.getEmail();

    }
}
