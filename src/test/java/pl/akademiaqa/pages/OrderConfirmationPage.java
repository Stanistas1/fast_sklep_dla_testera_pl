package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.section.orderConfirmationPage.OrderConfirmationDetailsPage;

@Getter
public class OrderConfirmationPage extends BasePage {

    private OrderConfirmationDetailsPage orderConfirmationDetailsPage;

    public OrderConfirmationPage(Page page) {
        super(page);
        this.orderConfirmationDetailsPage = new OrderConfirmationDetailsPage(page);
    }
}
