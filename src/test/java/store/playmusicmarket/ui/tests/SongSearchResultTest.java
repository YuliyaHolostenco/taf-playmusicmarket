package store.playmusicmarket.ui.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import store.playmusicmarket.ui.page.HomePage;
import store.playmusicmarket.ui.page.MarketPage;
import store.playmusicmarket.ui.page.SongPage;
import store.playmusicmarket.ui.steps.SongSearchResultStep;
import org.testng.annotations.Test;

public class SongSearchResultTest extends BaseTest {

  @Test
  public void testSearchWithEmptyQuery() {
    String expectedMessageSearchNothingMatched = "Nothing matched that search string";
    HomePage homePage = new HomePage();
    SongSearchResultStep.searchWithEmptyQuery();
    assertEquals(expectedMessageSearchNothingMatched, homePage.getMessageSearchNothingMatched());

  }

  @Test
  public void testSearchWithIncorrectQuery() {
    String expectedMessageSearchNothingMatched = "Nothing matched that search string";
    HomePage homePage = new HomePage();
    SongSearchResultStep.searchWithIncorrectQuery();
    assertEquals(expectedMessageSearchNothingMatched, homePage.getMessageSearchNothingMatched());

  }

  @Test
  public void testSearchWithResultNameMatchedQuery() {
    String inputUserCorrectSearchQuery = "[Human]";
    HomePage homePage = new HomePage();
    SongSearchResultStep.songSearch(inputUserCorrectSearchQuery);
    SongPage songPage = new SongPage();
    assertEquals(homePage.getUserInputSearchQuery(), songPage.getUserNameNft(), "Exact search match with SONG name");

  }

    @Test
  public void testSearchWithResultPartPresentNameSong() {
    String inputUserCorrectPartSearchQueryIsPresentSong = "Human";
    int resultPartSearchQueryIsPresentSong;
    SongSearchResultStep.songSearch(inputUserCorrectPartSearchQueryIsPresentSong);
    MarketPage marketPage = new MarketPage();
    resultPartSearchQueryIsPresentSong = marketPage.getNameSongMarket(inputUserCorrectPartSearchQueryIsPresentSong).size();
    assertNotEquals(resultPartSearchQueryIsPresentSong, 0,
        "Amount of SONG matches by searching for part of the real SONG name");

  }

  @Test
  public void testSearchWithResultHashTagPartPresentNameSong() {
    String inputUserCorrectPartSearchQueryIsPresentSong = "#CAT";
    int resultPartSearchQueryIsPresentSong;
    SongSearchResultStep.songSearch(inputUserCorrectPartSearchQueryIsPresentSong);
    MarketPage marketPage = new MarketPage();
    resultPartSearchQueryIsPresentSong = marketPage.getNameSongMarket(inputUserCorrectPartSearchQueryIsPresentSong).size();
    assertNotEquals(resultPartSearchQueryIsPresentSong, 0,
        "Amount of SONG matches by searching for the hashtag of part of the name of the real SONG");

  }
}
