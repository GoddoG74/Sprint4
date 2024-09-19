package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderCompletedPagePom {
    private WebDriver driver;
    private WebDriverWait wait;

    // Конструктор
    public OrderCompletedPagePom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Установка времени ожидания в 10 секунд
    }

    // Метод для получения локатора успешного заказа
    public By getOrderCompletedLocator() {
        return By.xpath("//div[contains(text(),'Заказ оформлен')]");
    }

    // Метод для проверки успешного завершения заказа
    public boolean isOrderCompleted() {
        WebElement orderCompletedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(getOrderCompletedLocator()));
        return orderCompletedMessage.isDisplayed();
    }
}