package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {
    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");

    }
}
