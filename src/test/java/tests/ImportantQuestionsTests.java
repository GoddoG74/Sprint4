package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.HomePagePom;
import homepageloc.HomePage;

import static org.junit.Assert.assertEquals;

public class ImportantQuestionsTests {

    private WebDriver driver;
    private HomePagePom homePagePom;
    private HomePage homePageLocators;

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
        homePageLocators = new HomePage();
        homePagePom = new HomePagePom(driver, homePageLocators);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Закрытие браузера
        }
    }

    @Test
    public void testImportantQuestions() throws InterruptedException {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePagePom.clickCookieButton(); // Клик по кнопке куки

        // Проверка вопроса "Сколько стоит аренда"
        homePagePom.clickQuestionHowMuch();
        String answerHowMuch = homePagePom.getAnswerHowMuch();
        assertEquals(EXPECTED_ANSWER_HOW_MUCH, answerHowMuch);

        // Проверка вопроса "Можно ли заказать несколько самокатов сразу?"
        homePagePom.clickQuestionSeveral();
        String answerSeveral = homePagePom.getAnswerSeveral();
        assertEquals(EXPECTED_ANSWER_SEVERAL, answerSeveral);

        // Проверка вопроса "На какой срок можно арендовать самокат?"
        homePagePom.clickQuestionRentTime();
        String answerRentTime = homePagePom.getAnswerRentTime();
        assertEquals(EXPECTED_ANSWER_RENT_TIME, answerRentTime);

        // Проверка вопроса "Можно ли заказать самокат сегодня?"
        homePagePom.clickQuestionOrderToday();
        String answerOrderToday = homePagePom.getAnswerOrderToday();
        assertEquals(EXPECTED_ANSWER_ORDER_TODAY, answerOrderToday);

        // Проверка вопроса "Можно ли продлить аренду?"
        homePagePom.clickQuestionExtendReturn();
        String answerExtendReturn = homePagePom.getAnswerExtendReturn();
        assertEquals(EXPECTED_ANSWER_EXTEND_RETURN, answerExtendReturn);

        // Проверка вопроса "Нужно ли заряжать самокат?"
        homePagePom.clickQuestionCharger();
        String answerCharger = homePagePom.getAnswerCharger();
        assertEquals(EXPECTED_ANSWER_CHARGER, answerCharger);

        // Проверка вопроса "Можно ли отменить заказ?"
        homePagePom.clickQuestionOrderCancel();
        String answerOrderCancel = homePagePom.getAnswerOrderCancel();
        assertEquals(EXPECTED_ANSWER_ORDER_CANCEL, answerOrderCancel);

        // Проверка вопроса "Как самокат ведет себя за МКАД?"
        homePagePom.clickQuestionMkadLife();
        String answerMkadLife = homePagePom.getAnswerMkadLife();
        assertEquals(EXPECTED_ANSWER_MKAD_LIFE, answerMkadLife);
    }
}
