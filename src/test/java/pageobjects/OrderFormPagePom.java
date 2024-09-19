package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import homepageloc.HomePage;

import java.time.Duration;

public class OrderFormPagePom {

    private WebDriver driver;
    private HomePage homePage;
    private WebDriverWait wait;

    public OrderFormPagePom(WebDriver driver, HomePage homePage) {
        this.driver = driver;
        this.homePage = new HomePage();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Установка времени ожидания в 10 секунд
    }

    // Метод для заполнения формы заказа
    public void fillOrderForm(String name, String lastName, String address, String station, String phone) {
        driver.findElement(homePage.fieldName).sendKeys(name);
        driver.findElement(homePage.fieldLastName).sendKeys(lastName);
        driver.findElement(homePage.fieldAddress).sendKeys(address);
        selectStation(station);  // Выбор станции
        driver.findElement(homePage.fieldPhone).sendKeys(phone);
    }

    // Метод для выбора станции из предложенного списка
    private void selectStation(String station) {
        WebElement stationField = driver.findElement(homePage.fieldStation);
        stationField.click(); // Клик по полю, чтобы открыть список

        // Вводим станцию в поле "select-search__value"
        stationField.sendKeys(station);

        // Ожидание появления выпадающего списка "select-search__select"
        WebElement optionsList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select-search__select")));

        // Клик по первому элементу выпадающего списка
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.className("select-search__select")));
        firstOption.click();
    }

    // Метод для клика на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(homePage.buttonNext).click();
    }
}

