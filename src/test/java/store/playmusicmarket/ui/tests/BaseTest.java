package store.playmusicmarket.ui.tests;

import static store.playmusicmarket.ui.utils.JsonReaderUtils.fileToMapConfig;

import store.playmusicmarket.ui.driver.DriverSingleton;
import store.playmusicmarket.ui.listener.LogListenerUi;
import store.playmusicmarket.ui.page.HomePage;
import store.playmusicmarket.ui.utils.LogUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners(LogListenerUi.class)
public class BaseTest {

  @BeforeSuite
  public static void chromeConfigs() {
    if (System.getProperty("os.name").toLowerCase().contains("win")) {
      System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }
  }

  @BeforeMethod
  public void openHomePage() {
    LogUtils.info("read file: src/test/resources/config_data.json");
    fileToMapConfig();
    new HomePage().openPage();
  }

  @AfterMethod(alwaysRun = true)
  public void finishTest() {
    DriverSingleton.closeDriver();
  }
}
