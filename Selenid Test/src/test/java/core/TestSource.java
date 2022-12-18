package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * Base class for selenide initialization
 */
abstract public class TestSource {

    /**
     * selenide initialization with settings
     */
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    /**
     * Executing a method before each test run
     */
    @BeforeEach
    public void init(){
        setUp();
    }

    /**
     * Executing a method before each test run
     */
    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
