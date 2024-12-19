package pl.akademiaqa.pages.section.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import pl.akademiaqa.pages.BasePage;

public class OrderAddressSection extends BasePage {
    private final String addressSection = "#checkout-addresses-step ";
    private Locator addressInput;
    private Locator zipCode;
    private Locator city;
    private Locator continuedButton;
    private Locator state;
    private Locator country;
    private Locator phoneNumber;
    private Locator errorText;

    public OrderAddressSection(Page page) {
        super(page);
        this.addressInput = page.locator(addressSection + "#field-address1");
        this.zipCode = page.locator(addressSection + "#field-postcode");
        this.city = page.locator(addressSection + "#field-city");
        this.country = page.locator(addressSection + "#field-id_country");
        this.phoneNumber = page.locator(addressSection + "#field-phone");
        this.continuedButton = page.locator(addressSection + "button[name=confirm-addresses]");
    }

    public OrderShippingSection enterAddress() {
        addressInput.fill("Testowa 1");
        zipCode.fill("12-345");
        city.fill("City");
        country.selectOption("Poland");
        phoneNumber.fill("123456789");
        continuedButton.click();
        return new OrderShippingSection(page);
    }
}
