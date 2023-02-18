package store.playmusicmarket.ui.tests;

import store.playmusicmarket.ui.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest {

  @Test
  public void testIsDisplayedButtonHomePage() {
    HomePage homePage = new HomePage();
    SoftAssert softAssert = new SoftAssert();
    homePage.scrollPageDown();
    softAssert.assertTrue(homePage.isDisplayedImageLogo());
    softAssert.assertTrue(homePage.isDisplayedButtonStartExploring());
    softAssert.assertTrue(homePage.isDisplayedButtonSignIn());
    softAssert.assertTrue(homePage.isDisplayedButtonMarket());
    softAssert.assertTrue(homePage.isDisplayedButtonActivity());
    softAssert.assertTrue(homePage.isDisplayedButtonBlog());
    softAssert.assertTrue(homePage.isDisplayedButtonHelp());
    softAssert.assertTrue(homePage.isDisplayedButtonViewArtwork());
    softAssert.assertTrue(homePage.isDisplayedButtonViewGallery());
    softAssert.assertTrue(homePage.isDisplayedButtonViewMore());
    softAssert.assertAll();

  }

  @Test
  public void testIsDisplayedImageNameCardSong() {
    HomePage homePage = new HomePage();
    Assert.assertTrue(homePage.isDisplayedImageCardSong());
    Assert.assertTrue(homePage.isDisplayedNameCardSongRecentActivity());
    Assert.assertTrue(homePage.isDisplayedNameCardSongLatestPieces());

  }

  @Test
  public void testTextLabelHomePage() {
    String expectedResultNameLogo = "PLAYMUSICMARKET" + "\n" + " music store";
    String expectedResultDescriptionLogo = "Otherwise the music forever stay in you";
    String expectedResultNameInputPlaceholder = "Search...";
    String expectedResultLabelRecentActivity = "Recent Activity";
    String expectedResultLabelLatestPieces = "Latest Pieces";
    SoftAssert softAssert = new SoftAssert();
    HomePage homePage = new HomePage();
    softAssert.assertEquals(expectedResultNameLogo, homePage.getNameLogo());
    softAssert.assertEquals(expectedResultDescriptionLogo, homePage.getDescriptionLogo());
    softAssert.assertEquals(expectedResultNameInputPlaceholder, homePage.getTextInputSearchPlaceholder());
    softAssert.assertEquals(expectedResultLabelRecentActivity, homePage.getTextLabelRecentActivity());
    softAssert.assertEquals(expectedResultLabelLatestPieces, homePage.getTexLabelLatestPieces());
    softAssert.assertAll();

  }
}
