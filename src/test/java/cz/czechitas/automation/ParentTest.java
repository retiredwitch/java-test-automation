package cz.czechitas.automation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ParentTest extends TestRunner {

    @BeforeEach
    void login() {
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("mistr@tester.cz");
        browser.loginSection.insertPassword("Mtester123");
        browser.loginSection.clickLoginButton();
    }

    @Test
    void assertionTaskOne() {
        browser.headerMenu.goToApplicationsSection();
        asserter.applicationSection.checkColumnExists("Jméno");
        asserter.applicationSection.checkColumnExists("Kategorie");
}
    @Test
    void complexTaskOne() {
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreateApplicationButton();
        browser.applicationDetailsSection.selectTerm("27.06. - 30.06.2024");
        browser.applicationDetailsSection.insertStudentFirstName("Pan");
        browser.applicationDetailsSection.insertStudentLastName("Tester001");
        browser.applicationDetailsSection.insertBirthdate("29.01.2000");
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.insertNote("Moje super poznamka");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        asserter.applicationDetailAction.checkPaymentMethod("Hotově");
        asserter.applicationDetailAction.checkFirstName("Pan");
        asserter.applicationDetailAction.checkLastName("Tester001");
        asserter.applicationDetailAction.checkDateOfBirth("29.01.2000");
        asserter.applicationDetailAction.checkNote("Moje super poznamka");
    }


    @Test
    void complexTaskSix() {
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.clickCreateNewApplicationButton();
        browser.applicationSection.selectProgrammingSection();
        browser.applicationSection.clickCreateApplicationButton();
        browser.applicationDetailsSection.selectTerm("27.06. - 30.06.2024");
        browser.applicationDetailsSection.insertStudentFirstName("Pan");
        var generated = browser.generateRandomName(15);
        browser.applicationDetailsSection.insertStudentLastName(generated);
        browser.applicationDetailsSection.insertBirthdate("11.12.2000");
        browser.applicationDetailsSection.selectCashPaymentMethod();
        browser.applicationDetailsSection.clickAcceptTermsCheckbox();
        browser.applicationDetailsSection.clickCreateApplicationButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(generated);
        asserter.applicationSection.checkNumberOfApplications(1);
        browser.loginSection.logout();
        browser.loginSection.clickLoginMenuLink();
        browser.loginSection.insertEmail("ja@tester.cz");
        browser.loginSection.insertPassword("Jtester123");
        browser.loginSection.clickLoginButton();
        browser.headerMenu.goToApplicationsSection();
        browser.applicationSection.search(generated);
        asserter.applicationSection.checkApplicationsTableIsEmpty();
    }
}