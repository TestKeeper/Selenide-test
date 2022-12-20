package appleInsider;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Главная страница сайта Appleinsider.ru
 */
public class MainPage {
    private final SelenideElement textBoxInput = $x("//input[@type='text']");

    public MainPage(String url){
        Selenide.open(url);
    }

    /**
     * A search is performed on the site among the articles and the Enter button is pressed
     * @param searchString search string
     */
    protected SearchPage search(String searchString){
       textBoxInput.setValue(searchString);
       textBoxInput.sendKeys(Keys.ENTER);
       return new SearchPage();
    }
}
