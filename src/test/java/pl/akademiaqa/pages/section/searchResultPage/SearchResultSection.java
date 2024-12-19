package pl.akademiaqa.pages.section.searchResultPage;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.junit.jupiter.params.provider.Arguments;
import pl.akademiaqa.dto.ProductDto;
import pl.akademiaqa.pages.BasePage;
import pl.akademiaqa.pages.ProductDetailsPage;
import pl.akademiaqa.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchResultSection extends BasePage {


    @Getter
    private List<Locator> products;

    public SearchResultSection(Page page) {
        super(page);
        products = page.locator(".js-product").all();
    }

    public ProductDetailsPage viewProductDetails(String productName) {
        ProductDto productDto = productsToDto().stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Product not found:" + productName));

        productDto.getThumbnail().click();

        return new ProductDetailsPage(page);
    }

    public List<ProductDto> productsToDto() {

        return products.stream()
                .map(p -> ProductDto.builder()
                        .thumbnail(p.locator(".thumbnail-top"))
                        .name(p.locator(".product-title").innerText())
                        .price(Double.parseDouble(p.locator(".price").innerText()
                                        .replaceAll(StringUtils.toUTF8("zł"), "")
                                        .replace(",", ".")
                                        .replaceAll("[^\\d.]", "")))
                        .build())
                .collect(Collectors.toList());
    }

}
