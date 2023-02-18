package store.playmusicmarket.ui.steps;

import store.playmusicmarket.ui.page.HomePage;
import store.playmusicmarket.ui.utils.Random;

public class SongSearchResultStep {

    public static HomePage songSearch(String inputUserSearchQuery) {
        return new HomePage()
                .clearSearchField()
                .typeSearchQuery(inputUserSearchQuery)
                .clickButtonSearch();
    }

    public static HomePage searchWithEmptyQuery() {
        return new HomePage()
                .typeSearchQuery(Random.generateRandomAsciiString())
                .clearSearchField()
                .clickButtonSearch();
    }

    public static HomePage searchWithIncorrectQuery() {
        return new HomePage()
                .typeSearchQuery(Random.generateRandomAsciiString())
                .clickButtonSearch();
    }
}
