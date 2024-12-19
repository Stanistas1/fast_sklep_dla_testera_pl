package pl.akademiaqa.pages.section.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.utils.EmailUtils;

public class OrderPersonalInformationSection extends BasePage {

    private final String personalInformationSection = "#checkout-personal-information-step ";
    private final String customerForm = personalInformationSection + "#customer-form ";

    private Locator socialTitleMr;
    private Locator socialTitleMrs;
    private Locator firstNameInput;
    private Locator lastNameInput;
    private Locator emailInput;
    private Locator passwordInput;
    private Locator dobInput;
    private Locator termsAndConditionsCheckbox;
    private Locator customerPrivacyCheckbox;
    private Locator continueButton;

    public OrderPersonalInformationSection(Page page) {
        super(page);
        this.socialTitleMr = page.locator(customerForm + "#field-id_gender-1");
        this.socialTitleMrs = page.locator(customerForm + "#field-id_gender-2");
        this.firstNameInput = page.locator(customerForm + "#field-firstname");
        this.lastNameInput = page.locator(customerForm + "#field-lastname");
        this.emailInput = page.locator(customerForm + "#field-email");
        this.passwordInput = page.locator(customerForm + "#field-password");
        this.dobInput = page.locator(customerForm + "#field-birthday");
        this.termsAndConditionsCheckbox = page.locator(customerForm + "input[name=psgdpr]");
        this.customerPrivacyCheckbox = page.locator(customerForm + "input[name=customer_privacy]");
        this.continueButton = page.locator(customerForm + "button[name=continue]");
    }

    public OrderAddressSection enterPersonalInformation() {
        selectSocialTitleMr()
                .enterFirstName("Bartek")
                .enterLastName("Test")
                .enterEmail(EmailUtils.generateRandomEmail())
                .enterPassword("123456789!@#$%^__")
                .enterDob("1997-10-10")
                .checkTermsAndConditions()
                .checkCustomerPrivacy()
                .clickContinueButton();
        return new OrderAddressSection(page);
    }

    private OrderPersonalInformationSection selectSocialTitleMr() {
        socialTitleMr.click();
        return this;
    }

    private OrderPersonalInformationSection selectSocialTitleMrs() {
        socialTitleMrs.click();
        return this;
    }

    private OrderPersonalInformationSection enterFirstName(String firstName) {
        firstNameInput.fill(firstName);
        return this;
    }

    private OrderPersonalInformationSection enterLastName(String lastName) {
        lastNameInput.fill(lastName);
        return this;
    }

    private OrderPersonalInformationSection enterEmail(String email) {
        emailInput.fill(email);
        return this;
    }

    private OrderPersonalInformationSection enterPassword(String password) {
        passwordInput.fill(password);
        return this;
    }

    private OrderPersonalInformationSection enterDob(String dob) {
        dobInput.fill(dob);
        return this;
    }

    private OrderPersonalInformationSection checkTermsAndConditions() {
        termsAndConditionsCheckbox.check();
        return this;
    }

    private OrderPersonalInformationSection checkCustomerPrivacy() {
        customerPrivacyCheckbox.check();
        return this;
    }

    private OrderPersonalInformationSection clickContinueButton() {
        continueButton.click();
        return this;
    }
}
