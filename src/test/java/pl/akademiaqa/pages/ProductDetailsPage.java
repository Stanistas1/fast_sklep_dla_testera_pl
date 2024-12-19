package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.section.modals.AddToCartConfirmationModalPage;
import pl.akademiaqa.pages.section.productDetailsPage.AddToCartSection;
import pl.akademiaqa.pages.section.productDetailsPage.ProductCustomizationSection;
import pl.akademiaqa.utils.PageUtils;

@Getter
public class ProductDetailsPage {

    private ProductCustomizationSection customizationSection;
    private AddToCartSection addToCartSection;

    public ProductDetailsPage(Page page) {
        PageUtils.wiatForPageToLoad(page);
        this.customizationSection = new ProductCustomizationSection(page);
        this.addToCartSection = new AddToCartSection(page);
    }

    public ProductDetailsPage customizeProduct(String customMessage) {
        customizationSection.customizeProduct(customMessage);
        return this;
    }
    public AddToCartConfirmationModalPage addToCart() {
        return addToCartSection.addProductToCart();
    }
}
