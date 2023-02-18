package store.playmusicmarket.ui.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MarketPage extends BasePage {

  private final By NAME_SONG_MARKET = By.xpath("//h1[@class='text-xl break-all overflow-y-hidden max-h-14']");
  @FindBy(xpath = "//h2[contains(text(), 'Market')]")
  private WebElement labelMarket;

  public List<String> getNameSongMarket(String nameSong) {
    waitForVisibilityOfElement(labelMarket);
    List<WebElement> elementsNameSongMarket = driver.findElements(NAME_SONG_MARKET);
    return elementsNameSongMarket.
        stream()
        .map(WebElement::getText)
        .filter(elementName -> elementName.startsWith(nameSong))
        .collect(Collectors.toList());

  }
}
