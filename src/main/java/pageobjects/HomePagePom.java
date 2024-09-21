package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePagePom {
    private WebDriver driver;
    public WebDriverWait wait;

    // Приватные локаторы для вопросов и ответов
    private By questionHowMuch = By.xpath("//div[text()='Сколько это стоит? И как оплатить?']/..//div[contains(@class,'accordion__button')]");
    private By answerHowMuch = By.xpath("//div[@id='accordion__panel-0']");
    private By questionSeveral = By.xpath("//div[text()='Хочу сразу несколько самокатов! Так можно?']/..//div[contains(@class,'accordion__button')]");
    private By answerSeveral = By.xpath("//div[@id='accordion__panel-1']");
    private By questionRentTime = By.xpath("//div[text()='Как рассчитывается время аренды?']/..//div[contains(@class,'accordion__button')]");
    private By answerRentTime = By.xpath("//div[@id='accordion__panel-2']");
    private By questionOrderToday = By.xpath("//div[text()='Можно ли заказать самокат прямо на сегодня?']/..//div[contains(@class,'accordion__button')]");
    private By answerOrderToday = By.xpath("//div[@id='accordion__panel-3']");
    private By questionExtendReturn = By.xpath("//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']/..//div[contains(@class,'accordion__button')]");
    private By answerExtendReturn = By.xpath("//div[@id='accordion__panel-4']");
    private By questionCharger = By.xpath("//div[text()='Вы привозите зарядку вместе с самокатом?']/..//div[contains(@class,'accordion__button')]");
    private By answerCharger = By.xpath("//div[@id='accordion__panel-5']");
    private By questionOrderCancel = By.xpath("//div[text()='Можно ли отменить заказ?']/..//div[contains(@class,'accordion__button')]");
    private By answerOrderCancel = By.xpath("//div[@id='accordion__panel-6']");
    private By questionMkadLife = By.xpath("//div[text()='Я жизу за МКАДом, привезёте?']/..//div[contains(@class,'accordion__button')]");
    private By answerMkadLife = By.xpath("//div[@id='accordion__panel-7']");

    // Приватные локаторы для кнопок
    private By orderButtonHeader = By.xpath("//button[text()='Заказать'][1]");
    private By orderButtonCenter = By.xpath("//div[contains(@class, 'Home_FinishButton')]//button");
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    // Конструктор
    public HomePagePom(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ожидание в 10 секунд
    }

    // Метод для прокрутки к элементу и клика по нему
    public void scrollToElementAndClick(By locator) throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

        Thread.sleep(1000); // Задержка в 1 секунду

        element.click();
    }

    // Методы для работы с вопросами
    public String getAnswerHowMuch() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerHowMuch)).getText();
    }

    public String getAnswerSeveral() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerSeveral)).getText();
    }

    public String getAnswerRentTime() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerRentTime)).getText();
    }

    public String getAnswerOrderToday() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerOrderToday)).getText();
    }

    public String getAnswerExtendReturn() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerExtendReturn)).getText();
    }

    public String getAnswerCharger() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerCharger)).getText();
    }

    public String getAnswerOrderCancel() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerOrderCancel)).getText();
    }

    public String getAnswerMkadLife() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(answerMkadLife)).getText();
    }

    // Методы для работы с кнопками
    public void clickOrderButtonHeader() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonHeader)).click();
    }

    public void clickOrderButtonCenter() {
        wait.until(ExpectedConditions.elementToBeClickable(orderButtonCenter)).click();
    }

    public void clickCookieButton() {
        wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
    }

    public By getQuestionHowMuch() {
        return questionHowMuch;
    }

    public By getQuestionSeveral() {
        return questionSeveral;
    }

    public By getQuestionRentTime() {
        return questionRentTime;
    }

    public By getQuestionOrderToday() {
        return questionOrderToday;
    }

    public By getQuestionExtendReturn() {
        return questionExtendReturn;
    }

    public By getQuestionCharger() {
        return questionCharger;
    }

    public By getQuestionOrderCancel() {
        return questionOrderCancel;
    }

    public By getQuestionMkadLife() {
        return questionMkadLife;
    }
}
