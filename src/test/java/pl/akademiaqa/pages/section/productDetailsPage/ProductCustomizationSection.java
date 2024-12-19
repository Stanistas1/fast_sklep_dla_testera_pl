package pl.akademiaqa.pages.section.productDetailsPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import pl.akademiaqa.pages.BasePage;

public class ProductCustomizationSection extends BasePage {

    private Locator customMessegaInput;
    private Locator saveCustomizationButton;
    private Locator customizationLabel;

    public ProductCustomizationSection(Page page) {
        super(page);
        this.customMessegaInput = page.locator("#field-textField1");
        this.saveCustomizationButton = page.locator("button[name=submitCustomizedData]");
        this.customizationLabel = page.locator(".customization-message");
    }

    public void customizeProduct(String customMessage) {
        customMessegaInput.fill(customMessage);
        saveCustomizationButton.click();
        page.waitForCondition(() -> customizationLabel.isVisible());
    }
}
