package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RentalFormPagePom {

    private WebDriver driver;
    private WebDriverWait wait;

    // Приватные локаторы
    private By rentalTerm = By.xpath("//div[contains(@class,'Dropdown-placeholder') and text()='* Срок аренды']");
    private By fieldDelivery = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private By orderButtonFormPage = By.xpath("//div[contains(@class, 'Order_Buttons')]//button[contains(text(), 'Заказать')]");
    private By todayDate = By.xpath("//div[contains(@class,'react-datepicker__day--today')]");

    public RentalFormPagePom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Метод для выбора даты доставки
    public void selectDeliveryDate() {
        WebElement deliveryDateField = driver.findElement(fieldDelivery);
        deliveryDateField.click(); // Клик по полю даты

        // Ожидание появления и выбор сегодняшней даты
        WebElement todayDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(todayDate));
        todayDateElement.click();
    }

    // Метод для установки срока аренды
    public void setRentalTerm() {
        WebElement rentalTermField = driver.findElement(rentalTerm);
        rentalTermField.click(); // Клик по полю срока аренды

        // Выбор первого варианта в выпадающем списке
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'Dropdown-menu')]//div[1]")));
        firstOption.click();
    }

    public void clickOrderButtonFormPage() {
        driver.findElement(orderButtonFormPage).click();
    }
}
