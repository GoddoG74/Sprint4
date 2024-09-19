package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import homepageloc.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentalFormPagePom {

    private WebDriver driver;
    private HomePage homePage;
    private WebDriverWait wait;

    public RentalFormPagePom(WebDriver driver, HomePage homePage) {
        this.driver = driver;
        this.homePage = homePage;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Метод для выбора даты доставки
    public void selectDeliveryDate() {
        WebElement deliveryDateField = driver.findElement(homePage.fieldDelivery);
        deliveryDateField.click(); // Клик по полю даты

        // Ожидание появления и выбор сегодняшней даты
        WebElement todayDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.todayDate));
        todayDateElement.click();
    }


    // Метод для установки срока аренды
    public void setRentalTerm() {
        WebElement rentalTermField = driver.findElement(homePage.rentalTerm);
        rentalTermField.click(); // Клик по полю срока аренды

        // Выбор первого варианта в выпадающем списке
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'Dropdown-menu')]//div[1]")));
        firstOption.click();
    }


    public void clickOrderButtonFormPage() {
        driver.findElement(homePage.orderButtonFormPage).click();
    }


}
