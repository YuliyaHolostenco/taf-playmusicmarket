package store.playmusicmarket.ui.tests;

import store.playmusicmarket.ui.page.AuthorizedPage;
import store.playmusicmarket.ui.page.HomePage;
import store.playmusicmarket.ui.page.LoginPage;
import store.playmusicmarket.ui.steps.LoginStep;
import store.playmusicmarket.ui.utils.UserCreator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

  @BeforeMethod
  public void openSignInPage() {
    new HomePage()
        .clickSignIn();
  }

  @Test
  public void testLoginWithEmptyCredentials() {
    String expectedErrorMessage = "Login failed";
    LoginPage loginPage = new LoginPage();
    LoginStep.getLoginWithEmptyCredentials();
    Assert.assertEquals(expectedErrorMessage, loginPage.getMessageFailedUserNameOrPassword());
  }

  @Test
  public void testLoginWithEmptyPasswordCredentials() {
    String expectedErrorMessage = "Please enter your password";
    LoginPage loginPage = new LoginPage();
    LoginStep.getLoginWithEmptyPasswordCredentials();
    Assert.assertEquals(expectedErrorMessage, loginPage.getMessageFailedUserNameOrPassword());
  }

  @Test
  public void testLoginWithEmptyUsernameEmailCredentials() {
    String expectedErrorMessage = "Please enter your PLAYMUSICMARKET username or email address";
    LoginPage loginPage = new LoginPage();
    LoginStep.getLoginWithEmptyUsernameEmailCredentials();
    Assert.assertEquals(expectedErrorMessage, loginPage.getMessageFailedUserNameOrPassword());
  }

  @Test
  public void testLoginWithIncorrectCredentials() {
    String expectedErrorMessage = "Login failed";
    LoginPage loginPage = new LoginPage();
    loginPage.authorize(UserCreator.createIncorrectCredentialsUser());
    Assert.assertEquals(expectedErrorMessage, loginPage.getMessageFailedUserNameOrPassword());
  }

  @Test
  public void testLoginFormWithCorrectEmailCredentials() {
    String expectedAuthorisedUserEmail = "test@playmusicmarket.store";
    AuthorizedPage authorizedPage = new AuthorizedPage();
    LoginPage loginPage = new LoginPage();
    loginPage.authorize(UserCreator.createDefaultUser());
    new HomePage()
        .clickButtonAuthorizedUser();
    Assert.assertEquals(expectedAuthorisedUserEmail, authorizedPage.getAccountMenuEmailText());
  }
}
