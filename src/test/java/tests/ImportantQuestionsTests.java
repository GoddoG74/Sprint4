package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.HomePagePom;

import static org.junit.Assert.assertEquals;

public class ImportantQuestionsTests {

    private WebDriver driver;
    private HomePagePom homePagePom;

    // Эталонные ответы
    private final String EXPECTED_ANSWER_HOW_MUCH = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private final String EXPECTED_ANSWER_SEVERAL = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private final String EXPECTED_ANSWER_RENT_TIME = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private final String EXPECTED_ANSWER_ORDER_TODAY = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private final String EXPECTED_ANSWER_EXTEND_RETURN = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private final String EXPECTED_ANSWER_CHARGER = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private final String EXPECTED_ANSWER_ORDER_CANCEL = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private final String EXPECTED_ANSWER_MKAD_LIFE = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        homePagePom = new HomePagePom(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрытие браузера
        }
    }

    private void scrollToElementAndClick(By locator) throws InterruptedException {
        WebElement element = homePagePom.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        Thread.sleep(1000); // Задержка в 1 секунду
        element.click();
    }

    private void testQuestion(By questionLocator, String expectedAnswer, String getAnswerMethod) throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePagePom.clickCookieButton(); // Клик по кнопке куки
        scrollToElementAndClick(questionLocator);
        String actualAnswer;

        switch (getAnswerMethod) {
            case "howMuch":
                actualAnswer = homePagePom.getAnswerHowMuch();
                break;
            case "several":
                actualAnswer = homePagePom.getAnswerSeveral();
                break;
            case "rentTime":
                actualAnswer = homePagePom.getAnswerRentTime();
                break;
            case "orderToday":
                actualAnswer = homePagePom.getAnswerOrderToday();
                break;
            case "extendReturn":
                actualAnswer = homePagePom.getAnswerExtendReturn();
                break;
            case "charger":
                actualAnswer = homePagePom.getAnswerCharger();
                break;
            case "orderCancel":
                actualAnswer = homePagePom.getAnswerOrderCancel();
                break;
            case "mkadLife":
                actualAnswer = homePagePom.getAnswerMkadLife();
                break;
            default:
                actualAnswer = "";
        }

        assertEquals(expectedAnswer, actualAnswer);
    }

    @Test
    public void testHowMuchQuestion() throws InterruptedException {
        testQuestion(homePagePom.getQuestionHowMuch(), EXPECTED_ANSWER_HOW_MUCH, "howMuch");
    }

    @Test
    public void testSeveralQuestion() throws InterruptedException {
        testQuestion(homePagePom.getQuestionSeveral(), EXPECTED_ANSWER_SEVERAL, "several");
    }

    @Test
    public void testRentTimeQuestion() throws InterruptedException {
        testQuestion(homePagePom.getQuestionRentTime(), EXPECTED_ANSWER_RENT_TIME, "rentTime");
    }

    @Test
    public void testOrderTodayQuestion() throws InterruptedException {
        testQuestion(homePagePom.getQuestionOrderToday(), EXPECTED_ANSWER_ORDER_TODAY, "orderToday");
    }

    @Test
    public void testExtendReturnQuestion() throws InterruptedException {
        testQuestion(homePagePom.getQuestionExtendReturn(), EXPECTED_ANSWER_EXTEND_RETURN, "extendReturn");
    }

    @Test
    public void testChargerQuestion() throws InterruptedException {
        testQuestion(homePagePom.getQuestionCharger(), EXPECTED_ANSWER_CHARGER, "charger");
    }

    @Test
    public void testOrderCancelQuestion() throws InterruptedException {
        testQuestion(homePagePom.getQuestionOrderCancel(), EXPECTED_ANSWER_ORDER_CANCEL, "orderCancel");
    }

    @Test
    public void testMkadLifeQuestion() throws InterruptedException {
        testQuestion(homePagePom.getQuestionMkadLife(), EXPECTED_ANSWER_MKAD_LIFE, "mkadLife");
    }
}
