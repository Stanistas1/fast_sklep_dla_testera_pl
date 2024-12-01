package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import lombok.Getter;
import pl.akademiaqa.pages.section.searchResultPage.SearchResultSection;
import pl.akademiaqa.utils.PageUtils;

public class SearchResultsPage {

    @Getter
    private SearchResultSection searchResultSection;

    public SearchResultsPage(Page page) {
        PageUtils.wiatForPageToLoad(page);
        this.searchResultSection = new SearchResultSection(page);
    }

}
