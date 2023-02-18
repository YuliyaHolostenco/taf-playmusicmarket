package store.playmusicmarket.ui.steps;

import store.playmusicmarket.ui.page.HomePage;
import store.playmusicmarket.ui.page.LoginPage;
import store.playmusicmarket.ui.utils.Random;
import store.playmusicmarket.ui.utils.UserCreator;

public class LoginStep {

  public static LoginPage getLoginWithEmptyCredentials() {
    return new LoginPage()
        .typeEmailUsername(Random.generateRandomAsciiString())
        .clearEmailUsername()
        .typePassword(Random.generateRandomAsciiString())
        .clearPassword()
        .clickButtonSubmit();
  }

  public static LoginPage getLoginWithEmptyPasswordCredentials() {
    return new LoginPage()
        .typeEmailUsername(Random.generateRandomAsciiString())
        .typePassword(Random.generateRandomAsciiString())
        .clearPassword()
        .clickButtonSubmit();
  }

  public static LoginPage getLoginWithEmptyUsernameEmailCredentials() {
    return new LoginPage()
        .typeEmailUsername(Random.generateRandomAsciiString())
        .clearEmailUsername()
        .typePassword(Random.generateRandomAsciiString())
        .clickButtonSubmit();
  }


  public static HomePage logIn() {
    return new HomePage()
        .clickSignIn()
        .authorize(UserCreator.createDefaultUser());

  }
}
