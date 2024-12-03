package pl.akademiaqa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.SearchResultsPage;
import pl.akademiaqa.utils.Properties;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest extends BaseTest {

    private HomePage homePage;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        page.navigate(Properties.getProperty("app.url"));
        homePage.getTopNavigationSection().setPageLanguageToEnglish();
    }

    @Test
    void should_return_products_by_search_name_mug() {
        SearchResultsPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("mug");
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(5);
    }

    @Test
    void should_return_products_by_search_name_frame() {
        SearchResultsPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("frame");
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(4);
    }

    @Test
    void should_return_products_by_search_name_tshirt() {
        SearchResultsPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts("t-shirt");
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(1);
    }

  /*  @ParameterizedTest
    @ValueSource(strings = {"mug", "frame", "t-shirt"})
    void should_return_products_by_product_name(String productName) {
        SearchResultsPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts(productName);
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isGreaterThan(0);
    }*/

    @DisplayName("Search for products")
    @ParameterizedTest(name = "Search for {0} should return {1} product(s)")
    @MethodSource("searchData")
    void should_return_products_by_product_name(String productName, int productCounter) {
        SearchResultsPage searchResultPage = homePage.getTopMenuAndSearchSection().searchForProducts(productName);
        assertThat(searchResultPage.getSearchResultSection().getProducts().size()).isEqualTo(productCounter);
    }

    private static Stream<Arguments> searchData(){
        return Stream.of(
                Arguments.of("mug", 5),
                Arguments.of("frame", 4),
                Arguments.of("t-shirt", 1),
                Arguments.of("notebook", 3),
                Arguments.of("graphics", 3)
        );
    }
}