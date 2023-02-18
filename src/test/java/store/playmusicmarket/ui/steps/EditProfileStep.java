package store.playmusicmarket.ui.steps;

import store.playmusicmarket.ui.entity.UserProfile;
import store.playmusicmarket.ui.page.EditProfilePage;

public class EditProfileStep {

    public static EditProfilePage editProfile(UserProfile user) {
        return new EditProfilePage()
                .clearInputFieldUserProfile()
                .editUserProfile(user)
                .clickButtonSaveDetails();
    }

    public static EditProfilePage getEditProfileEmptyCredentials() {
        return new EditProfilePage()
                .clearInputFieldUserProfile()
                .clickButtonSaveDetails();
    }
}
