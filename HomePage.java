package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    
public HomePage(WebDriver driver){
    super(driver);
}

By homePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
By numerOfItemsBy = By.className("inventory_item");
By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
By addToCardButton2By = By.id("add-to-cart-sauce-labs-bike-light");
By shoppingCartBadgeBy = By.className("shopping_cart_badge");
By checkoutButtonBy = By.name("checkout");
By hamburgerMenuBy = By.id("react-burger-menu-btn");
By logoutButtonBy = By.id("logout_sidebar_link");



public HomePage verifySuccesfulLogin (String expectedText){
    String actualText = readText(homePageTitleBy);
    assertTextEquals(expectedText, actualText);
    return this;
}

public HomePage numberOfProducts(int expectedNumberOfProducts){
    int actualNumberOfProducts = countItems(numerOfItemsBy);
    assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
    return this;

}
public HomePage verifyThatProductsAreAddedToCart(){
    click(addToCartButton1By);
    click(addToCardButton2By);
    waitVisability(shoppingCartBadgeBy);
    return this;
}

public HomePage clickOnShoppingCartBadge(){
    click(shoppingCartBadgeBy);
    return this;
}

public HomePage clickOnCheckoutButton(){
    click(checkoutButtonBy);
    return this;

}

public HomePage clickOnHamburgerMenu(){
    click(hamburgerMenuBy);
    return this;
}


public HomePage clickOnLogoutButton(){
    click(logoutButtonBy);
    return this;
    }

}
