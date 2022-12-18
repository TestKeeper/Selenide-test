package hh;

import core.TestSource;
import org.apache.commons.lang3.builder.EqualsBuilder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RunTest extends TestSource {
    /**
     * Link to resume for data
     */
    private final static String URL = "https://irkutsk.hh.ru/applicant/resumes/view?resume=90df7198ff0b8a68c80039ed1f5155367a7539";

    /**
     * Gets candidate attributes via HashMap, compares actual and expected result
     */
    @Test
    public void checkAttributesMap(){
        PagePoint hhResumePage = new PagePoint(URL);
        //создаем карту ключ-значение с ожидаемыми данными
        Map<String,Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(PagePoint.GENDER,"М");
        expectedAttributes.put(PagePoint.AGE, 41);
        expectedAttributes.put(PagePoint.CITY, "Иркутск");
        expectedAttributes.put(PagePoint.RELOCATE, false);
        expectedAttributes.put(PagePoint.CONFIRMED_PHONE, true);

        //получаем карту ключ-значение с актуальными данными
        Map<String,Object> actualAttributes = hhResumePage.getAttributes();

        //сравниваем ожидаемый и актуальный результат
        Assertions.assertEquals(expectedAttributes,actualAttributes);
    }

    /**
     * Gets candidate attributes via Class, compares actual and expected result
     */
    @Test
    public void checkAttributesClass(){
        PagePoint hhResumePage = new PagePoint(URL);
        //создаем экземпляр класса с ожидаемыми данными через конструктор
        Resume expectedResume = new Resume("М", "Иркутск",41, true,false);

        //получаем экземпляр класса с актуальными данными через конструктор
        Resume actualResume = new Resume(hhResumePage.getGenderEasy(), hhResumePage.getCityEasy(), hhResumePage.getAge(),
                hhResumePage.isPhoneConfirmed(),hhResumePage.isReadyToRelocate());

        //method of comparing classes
        Assertions.assertTrue(EqualsBuilder.reflectionEquals(expectedResume,actualResume));

    }


    





}
