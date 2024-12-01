package pl.akademiaqa.pages.section.searchResultPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;

public class SearchResultSection {

    @Getter
    private List<Locator> products;

    public SearchResultSection(Page page) {
        products = page.locator(".js-product").all();
    }
}
