package hh;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Resume page on hh website
 */
public class PagePoint {
    private final SelenideElement gender = $x("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement liveString = $x("//span[@data-qa='resume-personal-address']/ancestor::p");
    private final SelenideElement confirmedNumber = $x("//div[@data-qa='resume-contacts-phone']//span[1]");
    private final SelenideElement city = $x("//span[@data-qa='resume-personal-address']");

    /**
     * Constants for denoting keys for a hash map
     */
    public static String GENDER = "Пол";
    public static String CITY = "Город";
    public static String AGE = "Возраст";
    public static String RELOCATE = "Готовность к переезду";
    public static String CONFIRMED_PHONE = "Подтвержденный номер телефона";

    public PagePoint(String url) {
        Selenide.open(url);
    }

    /**
     * Returns a map (key-value pairs) with up-to-date resume data
     * The key of the map is an attribute of type String, the value of the map is an attribute of type Object (any type)
     *
     * An inline version of getting a hash map with values. Simplified version, can be seen in the test class
     * @return completed card with summary
     */
    public Map<String,Object> getAttributes(){
        return new HashMap<String ,Object>(){{
            put(GENDER, getGenderHard());
            put(CITY, getCityHard());
            put(AGE, getAge());
            put(RELOCATE, isReadyToRelocate());
            put(CONFIRMED_PHONE, isPhoneConfirmed());
        }};
    }

    /**
     * Checks if the phone is verified in the profile or not
     * @return tick visibility
     */
    public boolean isPhoneConfirmed(){
        return confirmedNumber.isDisplayed();
    }

    /**
     * Returns the city where the candidate lives
     * @return candidate's city
     */
    public String getCityEasy(){
        return city.getText();
    }

    /**
     * Splits a string about the candidate's residence information into an array into split pieces ", "
     *
     * Accommodation line to be received: St. Petersburg, not ready to move, not ready to travel
     *
     * An array with broken parts will have the following parts
     * [0] - Иркутск, [1] - not ready to move, [2] - not ready to travel
     *
     * @return the city in which the candidate lives from the general line of residence information
     */
    public String getCityHard(){
        return liveString.getText().split(", ")[0];
    }

    /**
     * Checks whether the candidate is ready to move or not
     * @return ready to move
     */
    public boolean isReadyToRelocate(){
        return !liveString.getText().split(", ")[1].equals("не готов к переезду");
    }

    /**
     * Gets the candidate's age from the resume using regular expressions
     *
     * The regular expression "[^0-9]" says to exclude everything that does not start with a number
     * Can be implemented through the regular expression "\\D+" thereby excluding all characters from the string
     *
     * @return candidate's age in numeric format
     */
    public int getAge(){
        return Integer.parseInt(age.getText().replaceAll("[^0-9]",""));
    }

    /**
     * Returns the gender of a candidate using a boolean condition
     * equals can be replaced with ==
     * @return M or F, depending on gender
     */
    public String getGenderEasy(){
        String genderValue = gender.getText();
        if(genderValue.equals("Мужчина")){
            return "М";
        }
        return "Ж";
    }

    /**
     * Returns the gender of a candidate using a ternary operator
     * @return M or F, depending on gender
     */
    public String getGenderHard(){
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
    }

}
