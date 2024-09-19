package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import homepageloc.HomePage;

public class ConfirmationPagePom {

    private WebDriver driver;
    private HomePage homePage;

    public ConfirmationPagePom(WebDriver driver, HomePage homePage) {
        this.driver = driver;
        this.homePage = homePage;
    }

    public By getConfirmButtonLocator() {
        return homePage.confirmButton;
    }

    public void clickConfirmButton() {
        driver.findElement(getConfirmButtonLocator()).click();
    }
}