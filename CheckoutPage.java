package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage extends BasePage {
    
public CheckoutPage(WebDriver driver){
    super(driver);
}
String firstName = "Ana";
String lastName = "Samardzija";
String zipCode = "18000";
By firstNameButtonBy = By.id("first-name");
By lastNameButtonBy = By.id("last-name");
By zipPostalCodeButtonBy = By.id("postal-code");
By continueButtonBy = By.xpath("//*[@id='continue']");
By finishButtonBy = By.id("finish");
By thankYouMessageBy = By.className("complete-header");
String expectedMessage = "THANK YOU FOR YOUR ORDER";

By p1 = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[3]/div[2]/div[2]/div");
By p2 = By.xpath("//*[@id='checkout_summary_container']/div/div[1]/div[4]/div[2]/div[2]/div");
By itemTotalBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[5]");
By taxBy= By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[6]");
By totalBy = By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[7]");


public CheckoutPage clickOnContinueButton(){
    writeText(firstNameButtonBy,firstName );
    writeText(lastNameButtonBy, lastName);
    writeText(zipPostalCodeButtonBy, zipCode);
    click(continueButtonBy);
    return this;
}

public CheckoutPage verifyTotalPrice(){
    double c1 = Double.parseDouble(readText(p1).substring(1));
    double c2 = Double.parseDouble(readText(p2).substring(1));
    double c3 = Double.parseDouble(readText(itemTotalBy).substring(13));
    double c4 = Double.parseDouble(readText(taxBy).substring(6));
    double c5 = Double.parseDouble(readText(totalBy).substring(8));
    
    double itemTotalSum = (c1+c2);
    assertDoubleEquals(itemTotalSum, c3);
    double totalSum = (c3+c4);
    assertDoubleEquals(totalSum, c5);
    return this;
}

public CheckoutPage clickOnFinishButton(){
    click(finishButtonBy);
    return this;

}

public CheckoutPage verifySuccessfulShoppingMessage(){
    String actualMessage = readText(thankYouMessageBy);
    assertTextEquals(expectedMessage, actualMessage);
    return this;
}
}
