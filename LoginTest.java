package tests;

import org.junit.Test;

import pages.LoginPage;

import pages.HomePage;

public class LoginTest extends BaseTest{
    
    public LoginPage loginPage;
    

    String lockedOutUser = "locked_out_user";
    String errorText = "Epic sadface: Sorry, this user has been locked out.";
    String emptyUsername = "";
    String emptyUsernameError = "Epic sadface: Username is required";
    String badPassword = "Test";
    String BadPasswordError = "Epic sadface: Username and password do not match any user in this service";

    String standardUsername = "standard_user";
    String password = "secret_sauce";
    String expectedText = "PRODUCTS";

    
    @Test
    
    public void verifyUnsuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);

    loginPage.basePage();
    loginPage.login(lockedOutUser, password);
    loginPage.verifyUnsuccesfulLogin(errorText);

    
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
}
    @Test
    
    public void verifyUnsuccesfulLoginWithEmptyUsername(){
    LoginPage loginPage = new LoginPage(driver);

    loginPage.basePage();
    loginPage.login(emptyUsername, password);
    loginPage.verifyUnsuccesfulLogin(emptyUsernameError);

    
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
    
 } 

 
    
@Test
    
public void verifyUnsuccesfulLoginWithBadPassword(){
LoginPage loginPage = new LoginPage(driver);

loginPage.basePage();
loginPage.login(standardUsername,badPassword);
loginPage.verifyUnsuccesfulLogin(BadPasswordError);


try{
    Thread.sleep(5000);
}
catch(InterruptedException e){
    e.printStackTrace();
}

} 

@Test
    public void verifySucessfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(expectedText);

    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }


}

}




