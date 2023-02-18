package store.playmusicmarket.api.utils;

import store.playmusicmarket.ui.utils.DataProperties;

public class UserData {
    public static final String USER_EMAIL = DataProperties.getDataProperties("db.login");
    public static final String PASSWORD = DataProperties.getDataProperties("db.password");
}
