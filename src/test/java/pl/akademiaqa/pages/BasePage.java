package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.section.TopMenuAndSearchSection;
import pl.akademiaqa.pages.section.TopNavigationSection;

public class BasePage {

    protected Page page;
    @Getter
    protected TopMenuAndSearchSection topMenuAndSearchSection;
    @Getter
    protected TopNavigationSection topNavigationSection;

    public BasePage(Page page) {
        this.page = page;
        this.topMenuAndSearchSection = new TopMenuAndSearchSection(page);
        this.topNavigationSection = new TopNavigationSection(page);
    }

    public SearchResultsPage searchForProduct(String productName) {
        return topMenuAndSearchSection.searchForProducts(productName);
    }

    public void setPageLanguageToEnglish() {
        topNavigationSection.setPageLanguageToEnglish();
    }
    public ArtPage clickArtLink() {
        return topMenuAndSearchSection.clickArtLink();
    }
}
