package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class OrderFormPagePom {

    private WebDriver driver;
    private WebDriverWait wait;

    // Приватные локаторы для элементов формы заказа
    private By fieldName = By.xpath("//input[@placeholder='* Имя']");
    private By fieldLastName = By.xpath("//input[@placeholder='* Фамилия']");
    private By fieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private By fieldStation = By.xpath("//input[@class='select-search__input']");
    private By fieldPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNext = By.xpath("//button[text()='Далее']");

    public OrderFormPagePom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Установка времени ожидания в 10 секунд
    }

    // Метод для заполнения формы заказа
    public void fillOrderForm(String name, String lastName, String address, String station, String phone) {
        driver.findElement(fieldName).sendKeys(name);
        driver.findElement(fieldLastName).sendKeys(lastName);
        driver.findElement(fieldAddress).sendKeys(address);
        selectStation(station);  // Выбор станции
        driver.findElement(fieldPhone).sendKeys(phone);
    }

    // Метод для выбора станции из предложенного списка
    private void selectStation(String station) {
        WebElement stationField = driver.findElement(fieldStation);
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
        driver.findElement(buttonNext).click();
    }
}
