package guru.qa.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        String firstName = "Sam";
        String lastName = "Miles";
        String userEmail = "miles@qaguru.com";
        String gender = "Male";
        String month = "November";
        String day = "3";
        String year = "1979";
        String userNumber = "9876543210";
        String subjects = "English";
        String hobbies = "Music";
        String currentAddress = "some street 1";
        String state = "NCR";
        String city = "Delhi";


        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userEmail").setValue(userEmail);
        $("#userNumber").setValue(userNumber);
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(byText(day)).click();

        $("#submit").click();

        $x("//td[.='Student Name']/following-sibling::td").shouldHave(Condition.text(firstName + " " + lastName));
        $x("//td[.='Student Email']/following-sibling::td").shouldHave(Condition.text(userEmail));
        $x("//td[.='Gender']/following-sibling::td").shouldHave(Condition.text(gender));
        $x("//td[.='Mobile']/following-sibling::td").shouldHave(Condition.text(userNumber));
        $x("//td[.='Date of Birth']/following-sibling::td").shouldHave(Condition.text(day + " " + month + "," + year));
        $x("//td[.='Subjects']/following-sibling::td").shouldHave(Condition.text(subjects));
        $x("//td[.='Hobbies']/following-sibling::td").shouldHave(Condition.text( hobbies));
        $x("//td[.='Address']/following-sibling::td").shouldHave(Condition.text(currentAddress));
        $x("//td[.='State and City']/following-sibling::td").shouldHave(Condition.text(state + " " + city));
    }
}
