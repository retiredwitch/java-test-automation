package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Test class for custom student tests
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class LowCodeAutomationTest extends TestRunner {

/*
Create a new test that cancels an application (Odhlášení účasti)
In IntelliJ IDEA make sure you are still on selectors_workshop branch
In your previous HW you already has a test that creates a new application with randomly generated name.
You can reuse this test.
Existing framework doesn't have a function that clicks on "Odhlášení účasti" red button.
You need to extend your framework (ApplicationAction.java) and add a new function called
cancelApplication() which will do exactly 3 clicks.
This function should click Odhlášení účasti button
Then click on Nemoc (you need to click on the label, not the radio button itself!!!)
Then click on Odhlasit zaka button
Once you are redirected to the applications list, you should check that your application was cancelled:
Open details page for the application you just cancelled.
Use asserter.applicationDetailAction.checkIfCancelled() to ensure application was really cancelled because of illness.
You are encouraged to check how this assert function was implemented, but you don’t have to write your own.
Once you are done, send me code of your test and cancelApplication() function so I can check them.
 */
    @Test
    void homework1() {
    browser.loginSection.clickLoginMenuLink();
    browser.loginSection.insertEmail("katesib871@togito.com");
    browser.loginSection.insertPassword("syqDy8-cippoq-daqwyz");
    browser.loginSection.clickLoginButton();
    var surname = browser.generateRandomName(10);
    browser.applicationSection.search(surname);
    asserter.applicationSection.checkApplicationsTableIsEmpty();
    browser.applicationSection.clickCreateNewApplicationButton();
    browser.applicationSection.selectProgrammingSection();
    browser.applicationSection.clickCreateApplicationButton();
    browser.applicationDetailsSection.selectTerm("27.06. - 30.06.2024");
    browser.applicationDetailsSection.insertStudentFirstName(surname);
    browser.applicationDetailsSection.insertStudentLastName(surname);
    browser.applicationDetailsSection.insertBirthdate("12.09.2013");
    browser.applicationDetailsSection.insertNote("ahoj");
    browser.applicationDetailsSection.selectCashPaymentMethod();
    browser.applicationDetailsSection.clickAcceptTermsCheckbox();
    browser.applicationDetailsSection.clickCreateApplicationButton();
    browser.applicationSection.cancelApplication();
    webDriver.get("https://team8-2022brno.herokuapp.com/zaci");
    browser.applicationSection.openFirstApplicationDetailsPage();
    asserter.applicationDetailAction.checkIfCancelled();
}
/*
Create a test that checks registration functionality:
1. From Home page you need to go to Login page
2. On Login page you need to click Zaregistrujte se button
3. Then you fill the form with valid values
(please note that some of them need to be unique for every test run!).
If framework doesn't know how to work with some of the fields, you need to
extend it by adding new methods to LoginAction.java
4. After filling the form you click the button to finish registration
5. Don’t forget to use asserter to ensure that registration went well.
6. Think how you can check that registration was successful.

Create a negative test for registration:
1. Do the same as an exercise before but use invalid values to check page validation
(e.g. passwords are different).
2. Extend asserter class (AssertionFacade.java) to verify error messages and popup messages you see on the screen.
 */
    @Test
    void homework2() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.clickRegisterButton();
        var name = browser.generateRandomName(6) + " " + browser.generateRandomName(4);
        browser.loginSection.insertName(name);
        var email = browser.generateRandomName(6) + "@mail.com";
        browser.loginSection.insertEmail(email);
        browser.loginSection.insertPassword("Abcde1");
        browser.loginSection.insertConfirmPassword("Abcde1");
        browser.loginSection.clickSecondRegisterButton();
        asserter.checkIsLoggedIn();


    }

    @Test
    void homework2_invalid_password() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.clickRegisterButton();
        var name = browser.generateRandomName(6) + " " + browser.generateRandomName(8);
        browser.loginSection.insertName(name);
        var mail = browser.generateRandomName(10) + "@mail.com";
        browser.loginSection.insertEmail(mail);
        var password = browser.generateRandomName(5) + 1 + "A";
        browser.loginSection.insertPassword(password);
        browser.loginSection.insertConfirmPassword("incorrectpassword");
        browser.loginSection.clickSecondRegisterButton();
        asserter.checkPasswordFailPresense();

    }

}
