package pl.akademiaqa.pages.section.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.section.modals.AddToCartConfirmationModalPage;

public class AddToCartSection extends BasePage {

    private Locator addToCartButton;

    public AddToCartSection(Page page) {
        super(page);
        this.addToCartButton = page.locator(".add-to-cart");
    }

    public AddToCartConfirmationModalPage addProductToCart() {
        addToCartButton.click();
        return new AddToCartConfirmationModalPage(page);
    }
}
