package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ConfirmationPagePom {

    private WebDriver driver;

    private By confirmButton = By.xpath("//button[text()='Да']");

    public ConfirmationPagePom(WebDriver driver) {
        this.driver = driver;
    }

    public By getConfirmButtonLocator() {
        return confirmButton;
    }

}
