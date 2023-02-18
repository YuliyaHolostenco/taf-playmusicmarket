package store.playmusicmarket.api.tests;

import store.playmusicmarket.api.listener.LogListenerApi;
import store.playmusicmarket.api.pojo.MessageFailedLogin;
import store.playmusicmarket.api.service.UserLoginService;
import store.playmusicmarket.api.utils.NewUser;
import store.playmusicmarket.api.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({LogListenerApi.class})
public class LoginApiTest extends NewUser {

  private final String expectedErrorMessage = "Login failed";

  @Test
  public void testLoginUserEmptyNamePassword() {
    MessageFailedLogin messageFailedLogin = new UserLoginService()
        .postLoginUserWithNotCorrectData(NewUser.createNewUserNotValidEmptyNamePassword());
    Assert.assertEquals(expectedErrorMessage, messageFailedLogin.getMessage());

  }

  @Test
  public void testLoginUserNotValidNamePasswordRandomValues() {
    MessageFailedLogin messageFailedLogin = new UserLoginService()
        .postLoginUserWithNotCorrectData(NewUser.createNewUserNotValidNamePasswordRandomValues());
    Assert.assertEquals(expectedErrorMessage, messageFailedLogin.getMessage());

  }

  @Test
  public void testLoginUserNotValidEmailPasswordRandomValues() {
    MessageFailedLogin messageFailedLogin = new UserLoginService()
        .postLoginUserWithNotCorrectData(NewUser.createNewUserNotValidEmailPasswordRandomValues());
    Assert.assertEquals(expectedErrorMessage, messageFailedLogin.getMessage());

  }

  @Test
  public void testLoginUserCorrectEmailPassword() {
    UserLoginService userLoginService = new UserLoginService();
    String expectedEmailUserLogin = UserData.USER_EMAIL;
    String resultAuthUserEmail = userLoginService
        .postLoginUserWithCorrectData(NewUser.createNewUserCorrectEmailPassword());
    Assert.assertEquals(expectedEmailUserLogin, resultAuthUserEmail);

  }
}
