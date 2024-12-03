package pl.akademiaqa.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;
import pl.akademiaqa.pages.section.products.FilterBySection;
import pl.akademiaqa.pages.section.products.ProductsSection;
import pl.akademiaqa.utils.PageUtils;

import static pl.akademiaqa.utils.PageUtils.wiatForPageToLoad;

@Getter
public class ArtPage {

    private ProductsSection productsSection;
    private FilterBySection filterBySection;
    public ArtPage(Page page) {
        PageUtils.wiatForPageToLoad(page);
        this.productsSection = new ProductsSection(page);
        this.filterBySection = new FilterBySection(page);
    }
}
