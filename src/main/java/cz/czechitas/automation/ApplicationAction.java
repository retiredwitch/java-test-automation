package cz.czechitas.automation;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Objects;

/**
 * Application selenium actions
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
@ParametersAreNonnullByDefault
final class ApplicationAction {

    private final ElementFinder elementFinder;

    ApplicationAction(ElementFinder elementFinder) {
        this.elementFinder = Objects.requireNonNull(elementFinder);
    }

    /**
     * Click Vytvorit novou prihlasku on table view
     */
    void clickCreateNewApplicationButton() {
        var createApplicationButton = elementFinder.findByCssSelector(".card-header .btn");
        createApplicationButton.click();
    }

    void selectProgrammingSection() {
        var programmingSectionButton = elementFinder.findByCssSelector(".card-body .btn");
        programmingSectionButton.click();
    }

    /**
     * Click Vytvorit prihlasku for Javascript course
     */
    void clickCreateApplicationButton() {
        var createApplicationButton = elementFinder.findByCssSelector(".btn");
        createApplicationButton.click();
    }

    void openFirstApplicationDetailsPage() {
        var openApplicationButton = elementFinder.findByXPath(
                "//tr[1]//a[@title='Zobrazit']");
        openApplicationButton.click();
    }

    void search(String textToSearch) {
        var searchInput = elementFinder.findByXPath("//input[@type='search']");
        searchInput.clear();
        searchInput.sendKeys(textToSearch);
    }

    void clickEditFirstApplicationButton() {
        var firstApplicationEditButton = elementFinder.findByXPath(
                "//tr[1]//a[@title='Upravit']");
        firstApplicationEditButton.click();
    }

    void cancelApplication() {
        var firstApplicationDeleteButton = elementFinder.findByCssSelector(
                ".btn-danger .fa");
        firstApplicationDeleteButton.click();
        var IllnessButton = elementFinder.findByCssSelector(
                ".mr-5 .custom-control-label");
        IllnessButton.click();
        var RemovePupil = elementFinder.findByCssSelector(
                ".btn.btn-primary");
        RemovePupil.click();
    }
}
