package pageobjects;

import org.openqa.selenium.WebDriver;
import homepageloc.HomePage;

public class HomePagePom {

    private WebDriver driver;
    private HomePage homePage;

    public HomePagePom(WebDriver driver, HomePage homePage) {
        this.driver = driver;
        this.homePage = homePage;
    }

    public void clickCookieButton() {
        driver.findElement(homePage.cookieButton).click();
    }

    public void clickOrderButtonHeader() {
        driver.findElement(homePage.orderButtonHeader).click();
    }

    public void clickOrderButtonCenter() {
        driver.findElement(homePage.orderButtonCenter).click();
    }

    public void clickQuestionHowMuch() {
        driver.findElement(homePage.questionHowMuch).click();
    }

    public String getAnswerHowMuch() {
        return driver.findElement(homePage.answerHowMuch).getText();
    }

    public void clickQuestionSeveral() {
        driver.findElement(homePage.questionSeveral).click();
    }

    public String getAnswerSeveral() {
        return driver.findElement(homePage.answerSeveral).getText();
    }

    public void clickQuestionRentTime() {
        driver.findElement(homePage.questionRentTime).click();
    }

    public String getAnswerRentTime() {
        return driver.findElement(homePage.answerRentTime).getText();
    }

    public void clickQuestionOrderToday() {
        driver.findElement(homePage.questionOrderToday).click();
    }

    public String getAnswerOrderToday() {
        return driver.findElement(homePage.answerOrderToday).getText();
    }

    public void clickQuestionExtendReturn() {
        driver.findElement(homePage.questionExtendReturn).click();
    }

    public String getAnswerExtendReturn() {
        return driver.findElement(homePage.answerExtendReturn).getText();
    }

    public void clickQuestionCharger() {
        driver.findElement(homePage.questionCharger).click();
    }

    public String getAnswerCharger() {
        return driver.findElement(homePage.answerCharger).getText();
    }

    public void clickQuestionOrderCancel() {
        driver.findElement(homePage.questionOrderCancel).click();
    }

    public String getAnswerOrderCancel() {
        return driver.findElement(homePage.answerOrderCancel).getText();
    }

    public void clickQuestionMkadLife() {
        driver.findElement(homePage.questionMkadLife).click();
    }

    public String getAnswerMkadLife() {
        return driver.findElement(homePage.answerMkadLife).getText();
    }
}
