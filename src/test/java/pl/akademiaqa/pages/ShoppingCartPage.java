package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.section.shoppingCartPage.SummarySection;
import pl.akademiaqa.utils.PageUtils;

@Getter
public class ShoppingCartPage {

    private SummarySection summarySection;

    public ShoppingCartPage(Page page) {
        PageUtils.wiatForPageToLoad(page);
        this.summarySection = new SummarySection(page);
    }

    public OrderDetailsPage proceedToCheckoutOnShoppingCartPage() {
        return summarySection.proceedToCheckout();
    }
}
