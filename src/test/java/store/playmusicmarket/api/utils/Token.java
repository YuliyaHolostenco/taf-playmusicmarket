package store.playmusicmarket.api.utils;

import store.playmusicmarket.api.model.User;
import store.playmusicmarket.api.pojo.Root;
import store.playmusicmarket.api.specification.Specifications;

import static io.restassured.RestAssured.given;

public class Token extends NewUser {

    protected static String getToken() {
        Specifications.installSpecification(Specifications.requestSpecification(),
                Specifications.responseSpecification(200));
        User user = createNewUserCorrectEmailPassword();
        Root root = given()
                .body(user)
                .post(Endpoint.LOGIN_USER)
                .then()
                .log()
                .all()
                .extract()
                .body()
                .as(Root.class);
        return root.getJwt_token();
    }
}
