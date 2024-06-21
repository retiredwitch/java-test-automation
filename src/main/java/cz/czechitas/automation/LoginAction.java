package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Login/logout specific selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class LoginAction {

    private final ElementFinder elementFinder;

    LoginAction(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    void clickLoginMenuLink() {
        var loginButton = elementFinder.findByCssSelector(".navbar-right .nav-link");
        loginButton.click();
    }

    void insertEmail(String email) {
        Objects.requireNonNull(email);

        var emailInputBox = elementFinder.findByXPath("//*[@id='email']");
        emailInputBox.sendKeys(email);
    }

    void insertPassword(String password) {
        Objects.requireNonNull(password);

        var passwordInputBox = elementFinder.findByXPath("//*[@id='password']");
        passwordInputBox.sendKeys(password);
    }

    void clickLoginButton() {
        var loginButton = elementFinder.findByXPath("//button[@type='submit']");
        loginButton.click();
    }

    void logout() {
        var signedInUserElement = elementFinder.findByXPath("//*[@id='navbarSupportedContent']/div[2]/div/a");
        signedInUserElement.click();
        var logoutButton = elementFinder.findByXPath("//*[@id='logout-link']");
        logoutButton.click();
    }

    void clickRegisterButton() {
        var registerbutton = elementFinder.findByCssSelector(".ml-2");
        registerbutton.click();
    }

    void insertName(String Name) {
        var nameInputBox = elementFinder.findByXPath("//*[@id='name']");
        nameInputBox.sendKeys(Name);
    }

    void insertConfirmPassword(String password) {
        Objects.requireNonNull(password);

        var confirmpasswordInputBox = elementFinder.findByXPath("//*[@id='password-confirm']");
        confirmpasswordInputBox.sendKeys(password);
    }

    void clickSecondRegisterButton() {
        var secondregisterbutton = elementFinder.findByCssSelector(".offset-md-4 .btn");
        secondregisterbutton.click();
    }
}
