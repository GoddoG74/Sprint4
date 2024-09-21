package tests;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.*;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTests {

    private WebDriver driver;
    private HomePagePom homePagePom;
    private OrderFormPagePom orderFormPagePom;
    private RentalFormPagePom rentalFormPagePom;
    private ConfirmationPagePom confirmationPagePom;
    private OrderCompletedPagePom orderCompletedPagePom;

    private String name;
    private String lastName;
    private String address;
    private String station;
    private String phone;

    public OrderTests(String name, String lastName, String address, String station, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.station = station;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Александр", "Иванов", "Петровка, 37", "Лубянка", "899911133322"},
                {"Венера", "Милосская", "Коммунистическая, 124", "Черкизовская", "888834341453"}
        });
    }

    private void initializePageObjects() {
        homePagePom = new HomePagePom(driver);
        orderFormPagePom = new OrderFormPagePom(driver);
        rentalFormPagePom = new RentalFormPagePom(driver);
        confirmationPagePom = new ConfirmationPagePom(driver);
        orderCompletedPagePom = new OrderCompletedPagePom(driver);
    }

    @Test
    public void testOrderButtonHeader() {
        driver = new ChromeDriver();
        initializePageObjects();

        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePagePom.clickCookieButton(); // Клик по кнопке куки
        homePagePom.clickOrderButtonHeader(); // Клик по кнопке 'Заказать' вверху страницы

        orderFormPagePom.fillOrderForm(name, lastName, address, station, phone); // Заполнение формы 'Для кого самокат'
        orderFormPagePom.clickNextButton(); // Переход к форме аренды

        rentalFormPagePom.selectDeliveryDate(); // Выбор даты доставки
        rentalFormPagePom.setRentalTerm(); // Установка срока аренды
        rentalFormPagePom.clickOrderButtonFormPage(); // Нажатие кнопки 'Заказать' на странице аренды

        // Ожидание всплывающего окна и нажатие 'Да'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(confirmationPagePom.getConfirmButtonLocator())).click();

        // Ожидание и проверка успешного заказа
        boolean isOrderCompleted = orderCompletedPagePom.isOrderCompleted();
        assertTrue("Окно успешного заказа не появилось", isOrderCompleted);
    }

    @Test
    public void testOrderButtonCenter() {
        driver = new ChromeDriver();
        initializePageObjects();

        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePagePom.clickCookieButton(); // Клик по кнопке куки
        homePagePom.clickOrderButtonCenter(); // Клик по кнопке 'Заказать' в центре страницы

        orderFormPagePom.fillOrderForm(name, lastName, address, station, phone); // Заполнение формы 'Для кого самокат'
        orderFormPagePom.clickNextButton(); // Переход к форме аренды

        rentalFormPagePom.selectDeliveryDate(); // Выбор даты доставки
        rentalFormPagePom.setRentalTerm(); // Установка срока аренды
        rentalFormPagePom.clickOrderButtonFormPage(); // Нажатие кнопки 'Заказать' на странице аренды

        // Ожидание всплывающего окна и нажатие 'Да'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(confirmationPagePom.getConfirmButtonLocator())).click();

        // Ожидание и проверка успешного заказа
        boolean isOrderCompleted = orderCompletedPagePom.isOrderCompleted();
        assertTrue("Окно успешного заказа не появилось", isOrderCompleted);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
