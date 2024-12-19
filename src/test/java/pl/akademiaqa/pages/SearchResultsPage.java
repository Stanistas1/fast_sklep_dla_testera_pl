package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.Getter;
import org.junit.jupiter.params.provider.Arguments;
import pl.akademiaqa.pages.section.searchResultPage.SearchResultSection;
import pl.akademiaqa.utils.PageUtils;

import java.util.stream.Stream;

public class SearchResultsPage {

    @Getter
    private SearchResultSection searchResultSection;

    public SearchResultsPage(Page page) {
        PageUtils.wiatForPageToLoad(page);
        this.searchResultSection = new SearchResultSection(page);
    }

    public ProductDetailsPage viewProductDetails(String productName) {
        return searchResultSection.viewProductDetails(productName);
    }

}
