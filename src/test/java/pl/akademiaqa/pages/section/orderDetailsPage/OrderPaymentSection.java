package pl.akademiaqa.pages.section.orderDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.OrderConfirmationPage;

public class OrderPaymentSection extends BasePage {
    private final String paymentSection = "#checkout-payment-step ";
    private Locator payBYCashOnDelivery;
    private Locator termsAndConditions;
    private Locator placeOrderButton;

    public OrderPaymentSection(Page page) {
        super(page);
        this.payBYCashOnDelivery = page.locator(paymentSection + "#payment-option-2");
        this.termsAndConditions = page.locator(paymentSection + "input[name='conditions_to_approve[terms-and-conditions]']");
        this.placeOrderButton = page.locator(paymentSection + "#payment-confirmation button");
    }

    public OrderConfirmationPage placeOrder() {
        payBYCashOnDelivery.check();
        termsAndConditions.check();
        placeOrderButton.click();
        return new OrderConfirmationPage(page);
    }
}
