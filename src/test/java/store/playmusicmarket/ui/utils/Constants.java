package store.playmusicmarket.ui.utils;

public class Constants {
    public static final String BASE_URL = DataProperties.getDataProperties("db.host");
    public static final int WAIT_TIMEOUT_SECONDS = 10;
    public static final int FLUENT_WAITS_TIMEOUT_SECONDS = 45;
    public static final String PROFILE_USER_URL = BASE_URL + Random.USER_NAME;
    public static final String LOGIN_URL = BASE_URL+"login";
    public static final String MINIMUM_BID = "10";
    public static final String EMPTY_BID = "";
}
