import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
      //  Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void formTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Name");
        $("#lastName").setValue("Surname");
        $("#userEmail").setValue("email@mail.com");

        //Select gender
        // $("#genterWrapper div.col-md-9.col-sm-12 #gender-radio-2").doubleClick();
        $("#genterWrapper").$(byText("Female")).click();

        $("#userNumber").setValue("0123456789");

        //Select date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day.react-datepicker__day--019").click();

        //Select Subject
        $("#subjectsInput").setValue("Ma").pressEnter();
        $("#subjectsInput").setValue("Ch").pressEnter();

        //Select Hobbies
//        $("#hobbiesWrapper div.col-md-9.col-sm-12 [for=hobbies-checkbox-3]").click();
//        $("#hobbiesWrapper div.col-md-9.col-sm-12 [for=hobbies-checkbox-2]").click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();

        //File
        $("#uploadPicture").uploadFromClasspath("img.png");

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
        $("div.table-responsive").shouldHave(text("Name Surname"));
        $("div.table-responsive").shouldHave(text("email@mail.com"));
        $("div.table-responsive").shouldHave(text("Female"));
        $("div.table-responsive").shouldHave(text("0123456789"));
        $("div.table-responsive").shouldHave(text("19 May,1998"));
        $("div.table-responsive").shouldHave(text("Maths, Chemistry"));
        $("div.table-responsive").shouldHave(text("Music, Reading"));
        $("div.table-responsive").shouldHave(text("img.png"));
        $("div.table-responsive").shouldHave(text("Address"));
        $("div.table-responsive").shouldHave(text("NCR Delhi"));


    }

}
