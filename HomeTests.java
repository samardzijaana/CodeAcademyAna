package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class HomeTests extends BaseTest{
    
    public LoginPage loginPage;
    public HomePage homePage;
    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";
    int numberOfAllItems = 6;


    @Test
public void verifyNumberofItemsOnHomePage(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(expectedText);
    homePage.numberOfProducts(numberOfAllItems);

    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
}

    @Test
    public void verifySucessfulAddToCart (){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(expectedText);
    homePage.verifyThatProductsAreAddedToCart();
    
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }

}


    
@Test
public void verifyLogout(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(expectedText);
    homePage.clickOnHamburgerMenu();
    homePage.clickOnLogoutButton();
    loginPage.verifyLogout();

    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }

}
}
