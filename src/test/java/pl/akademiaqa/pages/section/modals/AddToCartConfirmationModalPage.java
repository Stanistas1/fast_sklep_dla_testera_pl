package pl.akademiaqa.pages.section.modals;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.ShoppingCartPage;
import pl.akademiaqa.utils.PageUtils;

public class AddToCartConfirmationModalPage extends BasePage {

    private Locator confirmationLabel;
    private Locator proceedToCheckoutButton;

    public AddToCartConfirmationModalPage(Page page) {
        super(page);
        PageUtils.wiatForPageToLoad(page);
        this.confirmationLabel = page.locator("#myModalLabel");
        this.proceedToCheckoutButton = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed to checkout"));
    }

    public String getConfirmationMessage() {
        return confirmationLabel.innerText();
    }

    public ShoppingCartPage clickProceedToCheckout() {
        proceedToCheckoutButton.click();
        return new ShoppingCartPage(page);
    }
}
