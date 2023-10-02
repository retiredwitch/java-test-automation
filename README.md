# Low-code Test Automation Framework

Framework for teaching the basics of low-code automation on projects of the Czechitas Digital Testing Academy.

In its default state, after launching, the framework should start a web browser you have installed, without the need to download additional drivers. The assumption is that the user has one of the following web browsers installed: Firefox, Chrome, or Edge.

A sample test in the `ExampleTest` class will open a web browser and verify that the address www.czechitas.cz is present in the contacts section of the testing application.

# Hierarchy of Elements

Working with the framework is divided according to elements of the testing application as follows:

**ApplicationAction** - Allows you to work with application list:
- `selectProgrammingSection()` - select _Programming_ course category
- `clickCreateNewApplicationButton()` - create a new application once category is selected
- `openFirstApplicationDetailsPage()` - open an existing application to see details
- `search("Jan")` - search for an application from Jan
- `clickEditFirstApplicationButton()` - open the first application to edit details

**ApplicationDetail** - Allows you to work with application details page:
- `selectTerm(String term)` - select a term
- `insertStudentFirstName("Jan")` - insert student first name
- `insertStudentLastName("Novak")` - insert student first name
- `insertBirthdate("01.01.2000")` - insert student day of birth
- `insertNote("my personal note")` - insert a note
- `selectCashPaymentMethod()` - choose cash payment method
- `selectBankTrasnferPaymentMethod()` - choose bank transfer payment method
- `clickAcceptTermsCheckbox()` - accept Terms and Conditions
- `clickEditApplicationButton()` - save changes upon editing an application
- `clickCreateApplicationButton()` - click the button to create an application once all the details are provided

**InternalMenuAction** - Allows you to work with internal menu upon logging in:
- `goToOrdersSection()` - go to Objednavky section
- `goToTermsSection()` - go to Terminy section
- `goToApplicationsSection()` - go to Prihlasky section
- `goToCategoriesSection()` - go to Kategorie section
- `goToNewsSection()` - go to Aktuality section
- `goToExportsSection()` - go to Exporty section

**LoginAction** - allows you to login and logout:
- `clickLoginMenuLink()` - click login link in top menu (top right corner)
- `insertEmail("test@czechitas.cz"); insertPassword("mySecurePass123")`insert email and password
- `clickLoginButton()` - click login button once credentials are provided
- `logout()` - logout

**ProfileAction** - allows you to work with customer profile:
- `goToProfilePage()` - open profile page from top menu
- `insertPassword("new password")` - enter a new password. Change "new password" to the one you like based on security requirements (lowercase and uppercase letters, numbers, etc)
- `insertPasswordVerification("new password")` - enter a password to confirm
- `clickChangeButton()` - click the button to save changes

**PublicMenuAction** - allows you to work with top level menu in page header:
- `goToContactsSection()` - go to Kontakt section
- `goToHomePage()` - go to Domu page
- `goToInstructionsAndFormsForTeacherSection()` - go to Navody a Formulare pro ucitele
- `goToKindergartenAndSchoolSection()` - go to Objednávka pro MŠ/ZŠ
- `goToInstructionsAndFormsForParentSection()` - go to Navody a Formulare pro rodice
- `goToCreateApplicationSection()` - create an application from top header menu (Pro rodice -> Vytvorit prihlasku)