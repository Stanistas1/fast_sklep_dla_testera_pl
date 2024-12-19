package pl.akademiaqa.fasades;

import pl.akademiaqa.pages.OrderConfirmationPage;
import pl.akademiaqa.pages.section.modals.AddToCartConfirmationModalPage;

public class OrderProductFacade {

    public OrderConfirmationPage orderProduct(AddToCartConfirmationModalPage confirmationPage) {
        return confirmationPage
                .clickProceedToCheckout()
                .proceedToCheckoutOnShoppingCartPage()
                .enterOrderDetails();
    }
}
