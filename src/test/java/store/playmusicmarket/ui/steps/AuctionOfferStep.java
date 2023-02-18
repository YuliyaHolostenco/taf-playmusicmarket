package store.playmusicmarket.ui.steps;

import store.playmusicmarket.ui.page.AuctionOfferPage;

public class AuctionOfferStep {

  public static AuctionOfferPage makeOfferAuction(String amountPrice) {
    return new AuctionOfferPage()
        .clickButtonMakeOffer()
        .enterPrice(amountPrice)
        .enterButtonSubmit()
        .enterButtonContinue();
  }
}
