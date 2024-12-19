package pl.akademiaqa.tests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaqa.fasades.AddProductToCartFacade;
import pl.akademiaqa.fasades.OrderProductFacade;
import pl.akademiaqa.pages.*;
import pl.akademiaqa.pages.section.modals.AddToCartConfirmationModalPage;
import pl.akademiaqa.pages.section.orderDetailsPage.OrderAddressSection;
import pl.akademiaqa.pages.section.orderDetailsPage.OrderPaymentSection;
import pl.akademiaqa.pages.section.orderDetailsPage.OrderShippingSection;
import pl.akademiaqa.utils.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class FullPurchaseTest extends BaseTest {

    private final String productName = "Customizable Mug";

    private HomePage homePage;
    private AddProductToCartFacade addProductToCartFacade;
    private OrderProductFacade orderProductFacade;

    @BeforeEach
    void beforeEach() {
        homePage = new HomePage(page);
        addProductToCartFacade = new AddProductToCartFacade(homePage);
        orderProductFacade = new OrderProductFacade();
    }

    @Test
    void should_purchase_selected_product_test() {
        SearchResultsPage searchResultsPage = homePage.getTopMenuAndSearchSection().searchForProducts(productName);
        ProductDetailsPage productDetailsPage = searchResultsPage.getSearchResultSection().viewProductDetails(productName);
        productDetailsPage.getCustomizationSection().customizeProduct(productName);
        AddToCartConfirmationModalPage confirmationModalPage = productDetailsPage.getAddToCartSection().addProductToCart();
        Assertions.assertThat(confirmationModalPage.getConfirmationMessage()).contains("Product successfully added to your shopping cart");
        ShoppingCartPage shoppingCartPage = confirmationModalPage.clickProceedToCheckout();
        OrderDetailsPage orderDetailsPage = shoppingCartPage.getSummarySection().proceedToCheckout();

        OrderAddressSection addressSection = orderDetailsPage.getPersonalInformation().enterPersonalInformation();
        OrderShippingSection shippingSection = addressSection.enterAddress();
        OrderPaymentSection orderPaymentSection = shippingSection.selectShippingMethod();
        OrderConfirmationPage confirmationPage = orderPaymentSection.placeOrder();
        confirmationPage.getOrderConfirmationDetailsPage().getConfirmationTittle();

        Assertions.assertThat(confirmationPage.getOrderConfirmationDetailsPage().getConfirmationTittle()).containsIgnoringCase("Your order is confirmed");

        page.waitForTimeout(3000);
    }

    @Test
    void should_purchase_selected_product_v2_test() {
        AddToCartConfirmationModalPage confirmationModal =
                homePage
                        .searchForProduct(productName)
                        .viewProductDetails(productName)
                        .customizeProduct(productName)
                        .addToCart();

        assertThat(confirmationModal.getConfirmationMessage().contains("Product successfully added to your shopping cart"));

        OrderConfirmationPage confirmationPage = confirmationModal
                .clickProceedToCheckout()
                .proceedToCheckoutOnShoppingCartPage()
                .enterOrderDetails();

        assertThat(confirmationPage.getOrderConfirmationDetailsPage()
                .getConfirmationTittle()).containsIgnoringCase("Your order is confirmed");
    }

    @Test
    void should_purchase_selected_product_v3_test() {
        AddToCartConfirmationModalPage confirmationModal = addProductToCartFacade.addProductWithCustomizationToCart(productName);
        assertThat(confirmationModal.getConfirmationMessage().contains("Product successfully added to your shopping cart"));

        OrderConfirmationPage confirmationPage = orderProductFacade.orderProduct(confirmationModal);
        assertThat(confirmationPage.getOrderConfirmationDetailsPage()
                .getConfirmationTittle()).containsIgnoringCase("Your order is confirmed");
    }
}
