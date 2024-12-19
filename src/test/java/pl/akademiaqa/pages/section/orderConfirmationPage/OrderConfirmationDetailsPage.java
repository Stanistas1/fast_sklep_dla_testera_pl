package pl.akademiaqa.pages.section.orderConfirmationPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class OrderConfirmationDetailsPage extends BasePage {

    private final String orderConfirmationSection = "#content-hook_order_confirmation ";
    private Locator tittle;

    public OrderConfirmationDetailsPage(Page page) {
        super(page);
        this.tittle = page.locator(orderConfirmationSection + ".card-title");
    }

    public String getConfirmationTittle() {
        return tittle.innerText();
    }
}
