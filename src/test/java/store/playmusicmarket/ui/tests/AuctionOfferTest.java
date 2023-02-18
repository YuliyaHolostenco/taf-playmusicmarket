package store.playmusicmarket.ui.tests;

import store.playmusicmarket.ui.page.AuctionOfferPage;
import store.playmusicmarket.ui.page.HomePage;
import store.playmusicmarket.ui.steps.AuctionOfferStep;
import store.playmusicmarket.ui.steps.LoginStep;
import store.playmusicmarket.ui.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuctionOfferTest extends BaseTest {

  @Test(priority = 1, description = "Check valid values when make an offer")
  public void testMakeOfferCorrectly() {
    AuctionOfferPage auctionOfferPage = new AuctionOfferPage();
    LoginStep.logIn();
    new HomePage().enterArtworkForests();
    AuctionOfferStep.makeOfferAuction(Constants.MINIMUM_BID);
    String actualResultCurrentBidPriceInfo = auctionOfferPage.getCurrentBidPriceInfo()
        .replaceAll("[^0-9]\\.|\\.[^0-9]|[^0-9.\\s]|\\n|\\s", "");
    String actualResultCurrentBidPriceHistory = auctionOfferPage.getCurrentBidPriceHistory()
        .replaceAll("[^0-9]\\.|\\.[^0-9]|[^0-9.\\s]|\\n|\\s", "");
    Assert.assertTrue(auctionOfferPage.isDisplayedMessageBidPlaced());
    Assert.assertEquals(actualResultCurrentBidPriceHistory, Constants.MINIMUM_BID);
  }
}
