package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckOutPage {

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By checkoutBtn = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.xpath("//button[@id='finish']");
    By successMessage = By.className("complete-header");

    //Actions
    public void clickCheckout(){
        driver.findElement(checkoutBtn).click();
    }

     public void enterDetails(String Sumeer, String Bhatia, String pCode){
            driver.findElement(firstName).sendKeys(Sumeer);
            driver.findElement(lastName).sendKeys(Bhatia);
            driver.findElement(postalCode).sendKeys(pCode);
     }

     public void clickContinue(){
        driver.findElement(continueBtn).click();
     }

     public void clickFinish()   {
         WaitUtils.waitForElementClickable(driver, finishBtn);
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(finishBtn));
         driver.findElement(finishBtn).click();

//         WaitUtils.waitForElementClickable(driver, finishBtn);
//         driver.findElement(finishBtn).click();
     }

     public String getSuccessMessage(){
        return driver.findElement(successMessage).getText();
     }
}
