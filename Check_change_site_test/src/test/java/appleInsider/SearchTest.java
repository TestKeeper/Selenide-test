package appleInsider;


import core.BaseSelenideTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SearchTest extends BaseSelenideTest {

    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH_STRING = "5 гаджетов Apple, которые не стоит покупать в 2022 году";
    private final static String EXPECTED_WORD = "2022";

    @Test
    public void checkHref(){
        Assertions.assertTrue(new MainPage(BASE_URL)
                .search(SEARCH_STRING)
                .getHrefFromFirstArticle()
                .contains(EXPECTED_WORD));
    }
}
