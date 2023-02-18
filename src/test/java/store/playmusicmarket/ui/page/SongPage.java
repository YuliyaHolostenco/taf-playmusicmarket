package store.playmusicmarket.ui.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SongPage extends BasePage {

    @FindBy(xpath = "//h1[@class='text-3xl font-black primary-color']")
    private WebElement nameSong;

    public String getUserNameNft() {
        waitForVisibilityOfElement(nameSong);
        return nameSong.getText();
    }

}
