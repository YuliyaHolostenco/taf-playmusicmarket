package store.playmusicmarket.ui.steps;

import store.playmusicmarket.ui.page.AuthorizedPage;
import store.playmusicmarket.ui.page.HomePage;
import store.playmusicmarket.ui.utils.UserCreator;

public class AuthorizeUserProfileStep {

  public static AuthorizedPage authorizedUserProfile() {
    return new HomePage()
        .clickSignIn()
        .authorize(UserCreator.createDefaultUser())
        .clickButtonAuthorizedUser();
  }

}
