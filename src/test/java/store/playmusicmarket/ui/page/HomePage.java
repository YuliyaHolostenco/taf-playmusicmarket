package store.playmusicmarket.ui.page;

import store.playmusicmarket.ui.utils.Constants;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

  private final CharSequence[] charSequencesDeleteAll = {Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.UP), Keys.DELETE};
  private final By IMAGE_CARD_ARTWORK = By.xpath("//img[@class=' svelte-a8mb6d']");
  private final By NAME_CARD_SONG_RECENT_ACTIVITY = By.xpath(
      "//div[@class='recentCard flex-grow flex svelte-1pvmnl9']");
  private final By NAME_CARD_SONG_LATEST_PIECES = By.xpath("//div[@class='p-4']");
  @FindBy(xpath = "//img[@alt='logo']")
  private WebElement imageLogo;
  @FindBy(xpath = "//h1[contains(text(), 'PLAYMUSICMARKET')]")
  private WebElement nameLogo;
  @FindBy(xpath = "//h5[contains(text(), 'Otherwise the music forever stay in you')]")
  private WebElement descriptionLogo;
  @FindBy(xpath = "//a[contains(text(), 'Start exploring')]")
  private WebElement buttonStartExploring;
  @FindBy(xpath = "(//button[@class='svelte-1gbof36'][normalize-space()='Sign In'])[2]")
  private WebElement buttonSignIn;
  @FindBy(xpath = "(//button[@class='flex svelte-1gbof36'])[2]")
  private WebElement buttonAuthorizedUser;
  @FindBy(xpath = "(//button[contains(text(), 'Market')])[2]")
  private WebElement buttonMarket;
  @FindBy(xpath = "(//button[contains(text(), 'Activity')])[2]")
  private WebElement buttonActivity;
  @FindBy(xpath = "(//button[contains(text(), 'Blog')])[2]")
  private WebElement buttonBlog;
  @FindBy(xpath = "(//button[contains(text(), 'Help')])[2]")
  private WebElement buttonHelp;
  @FindBy(xpath = "(//input[@placeholder = 'Search...'])[2]")
  private WebElement inputSearch;
  @FindBy(xpath = "//button[contains(text(), 'View Song')]")
  private WebElement buttonViewArtwork;
  @FindBy(xpath = "//h3[contains(text(), 'Recent Activity')]")
  private WebElement labelRecentActivity;
  @FindBy(xpath = "//a[contains(text(), 'View more')]")
  private WebElement buttonViewMore;
  @FindBy(xpath = "//h3[contains(text(), 'Latest Pieces')]")
  private WebElement labelLatestPieces;
  @FindBy(xpath = "//a[contains(text(), 'View gallery')]")
  private WebElement buttonViewGallery;
  @FindBy(xpath = "//*[contains(text(), 'Nothing matched that search string')]")
  private WebElement messageSearchNothingMatched;

  @FindBy(xpath = "//img[@alt='forests'][1]")
  private WebElement artworkNameForests;

  @FindBy(className = "lazy cover absolute secondary-header svelte-wv7d3q")
  private WebElement coverArtworks;


  public LoginPage clickSignIn() {
    fluentWaitForElementToBeClickable(buttonSignIn).click();
    return new LoginPage();
  }

  public AuthorizedPage clickButtonAuthorizedUser() {
    waitForElementToBeClickable(buttonAuthorizedUser);
    buttonAuthorizedUser.click();
    return new AuthorizedPage();
  }

  public HomePage openPage() {
    driver.get(Constants.BASE_URL);
    getCurrentUrl(Constants.BASE_URL);
    return this;
  }

  public HomePage scrollPageDown() {
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", buttonViewGallery);
    waitForVisibilityOfElement(buttonViewGallery);
    return this;
  }

  public HomePage enterArtworkForests() {
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
    waitForVisibilityOfElement(buttonViewGallery);
    javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", artworkNameForests);
    waitForElementToBeClickable(artworkNameForests).click();
    return this;
  }


  public boolean isDisplayedImageLogo() {
    return imageLogo.isDisplayed();
  }

  public String getNameLogo() {
    return nameLogo.getText();
  }

  public String getDescriptionLogo() {
    return descriptionLogo.getText();
  }

  public boolean isDisplayedButtonStartExploring() {
    return buttonStartExploring.isDisplayed();
  }

  public boolean isDisplayedButtonSignIn() {
    return buttonSignIn.isDisplayed();
  }

  public boolean isDisplayedButtonMarket() {
    return buttonMarket.isDisplayed();
  }

  public boolean isDisplayedButtonActivity() {
    return buttonActivity.isDisplayed();
  }

  public boolean isDisplayedButtonBlog() {
    return buttonBlog.isDisplayed();
  }

  public boolean isDisplayedButtonHelp() {
    return buttonHelp.isDisplayed();
  }

  public String getTextInputSearchPlaceholder() {
    return inputSearch.getAttribute("placeholder");
  }

  public boolean isDisplayedButtonViewArtwork() {
    return buttonViewArtwork.isDisplayed();
  }

  public String getTextLabelRecentActivity() {
    return labelRecentActivity.getText();
  }

  public String getTexLabelLatestPieces() {
    return labelLatestPieces.getText();
  }

  public boolean isDisplayedButtonViewGallery() {
    return buttonViewGallery.isDisplayed();
  }

  public boolean isDisplayedButtonViewMore() {
    return buttonViewMore.isDisplayed();
  }

  public boolean isDisplayedImageCardSong() {
    List<WebElement> elementImageCardSong = driver.findElements(IMAGE_CARD_ARTWORK);
    for (WebElement elements : elementImageCardSong) {
      if (!elements.isDisplayed()) {
        LOGGER.info(elements.getLocation());
        return false;
      }
    }
    return true;
  }

  public boolean isDisplayedNameCardSongRecentActivity() {
    List<WebElement> elementNameCardSongRecentActivity = driver.findElements(NAME_CARD_SONG_RECENT_ACTIVITY);
    for (WebElement elements : elementNameCardSongRecentActivity) {
      if (!elements.isDisplayed()) {
        LOGGER.info(elements.getLocation());
        return false;
      }
    }
    return true;
  }

  public boolean isDisplayedNameCardSongLatestPieces() {
    List<WebElement> elementNameCardSongLatestPieces = driver.findElements(NAME_CARD_SONG_LATEST_PIECES);
    for (WebElement elements : elementNameCardSongLatestPieces) {
      if (!elements.isDisplayed()) {
        LOGGER.info(elements.getLocation());
        return false;
      }
    }
    return true;
  }

  public HomePage typeSearchQuery(String query) {
    inputSearch.sendKeys(query);
    return this;
  }

  public HomePage clickButtonSearch() {
    waitForElementToBeClickable(inputSearch);
    inputSearch.sendKeys(Keys.ENTER);
    return this;
  }

  public String getUserInputSearchQuery() {
    return inputSearch.getAttribute("value");
  }

  public String getMessageSearchNothingMatched() {
    waitForVisibilityOfElement(messageSearchNothingMatched);
    return messageSearchNothingMatched.getText();
  }

  private HomePage clearInputField(WebElement inputField) {
    inputField.sendKeys(charSequencesDeleteAll);
    return this;
  }

  public HomePage clearSearchField() {
    clearInputField(inputSearch);
    return this;
  }
}
