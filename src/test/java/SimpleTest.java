
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.commands.SelectRadio;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SimpleTest {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void formTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Name");
        $("#lastName").setValue("Surname");
        $("#userEmail").setValue("email@mail.com");

        //Select gender
       $("#genterWrapper div.col-md-9.col-sm-12 #gender-radio-2").doubleClick();
        //$("#gender-radio-2").selectRadio("Female");
        //       $(By.name("gender")).selectRadio("Female").click();

        $("#userNumber").setValue("0123456789");

        //Select date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day.react-datepicker__day--019").click();

        //Select Subject
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Ma").pressEnter();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("Ch").pressEnter();

        //Select Hobbies
        $("#hobbiesWrapper div.col-md-9.col-sm-12 [for=hobbies-checkbox-3]").click();
        $("#hobbiesWrapper div.col-md-9.col-sm-12 [for=hobbies-checkbox-2]").click();

        //File
        $("#uploadPicture").uploadFile(new File("/Users/tandre/Downloads/img.png"));

        //Address
        $("#currentAddress").setValue("Address");

        //State and city
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        //Submit
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

    }

}
