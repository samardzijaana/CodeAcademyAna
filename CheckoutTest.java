package tests;

import org.junit.Test;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;




public class CheckoutTest extends BaseTest{


public LoginPage loginPage;
public HomePage homePage;
public CheckoutPage checkoutPage;
String standardUsername = "standard_user";
String password = "secret_sauce";
String expectedText = "PRODUCTS";




    @Test
    public void verifyTotalPriceAmount(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(expectedText);
    homePage.verifyThatProductsAreAddedToCart();
    homePage.clickOnShoppingCartBadge();
    homePage.clickOnCheckoutButton();
    checkoutPage.clickOnContinueButton();
    checkoutPage.verifyTotalPrice();
    
    
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
    
    }

    @Test
    public void verifySuccessfulShoppingMessage(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(expectedText);
    homePage.verifyThatProductsAreAddedToCart();
    homePage.clickOnShoppingCartBadge();
    homePage.clickOnCheckoutButton();
    checkoutPage.clickOnContinueButton();
    checkoutPage.clickOnFinishButton();
    checkoutPage.verifySuccessfulShoppingMessage();
    
    
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
    
    }

}