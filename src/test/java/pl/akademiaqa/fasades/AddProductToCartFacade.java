package pl.akademiaqa.fasades;

import pl.akademiaqa.pages.HomePage;
import pl.akademiaqa.pages.section.modals.AddToCartConfirmationModalPage;

public class AddProductToCartFacade {

    private HomePage homePage;

    public AddProductToCartFacade(HomePage homePage) {
        this.homePage = homePage;
    }

    public AddToCartConfirmationModalPage addProductWithCustomizationToCart(String productName) {
        return homePage
                .searchForProduct(productName)
                .viewProductDetails(productName)
                .customizeProduct(productName)
                .addToCart();
    }

    public AddToCartConfirmationModalPage addProductToCart(String productName) {
        return homePage
                .searchForProduct(productName)
                .viewProductDetails(productName)
                .addToCart();

    }
}
