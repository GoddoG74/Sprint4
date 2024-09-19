package homepageloc;

import org.openqa.selenium.By;

public class HomePage {

    // Кнопка «Заказать» в верхней части страницы
    public By orderButtonHeader = By.xpath("//button[text()='Заказать'][1]");

    // Кнопка «Заказать» в центре страницы
    public By orderButtonCenter = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

    // Локатор для кнопки с куки
    public By cookieButton = By.className("App_CookieButton__3cvqF");

    // Вопросы о важном (с ответами)
    public By questionHowMuch = By.xpath("//div[text()='Сколько это стоит? И как оплатить?']/..//div[contains(@class,'accordion__button')]");
    public By answerHowMuch = By.xpath("//div[@id='accordion__panel-0']");
    public By questionSeveral = By.xpath("//div[text()='Хочу сразу несколько самокатов! Так можно?']/..//div[contains(@class,'accordion__button')]");
    public By answerSeveral = By.xpath("//div[@id='accordion__panel-1']");
    public By questionRentTime = By.xpath("//div[text()='Как рассчитывается время аренды?']/..//div[contains(@class,'accordion__button')]");
    public By answerRentTime = By.xpath("//div[@id='accordion__panel-2']");
    public By questionOrderToday = By.xpath("//div[text()='Можно ли заказать самокат прямо на сегодня?']/..//div[contains(@class,'accordion__button')]");
    public By answerOrderToday = By.xpath("//div[@id='accordion__panel-3']");
    public By questionExtendReturn = By.xpath("//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']/..//div[contains(@class,'accordion__button')]");
    public By answerExtendReturn = By.xpath("//div[@id='accordion__panel-4']");
    public By questionCharger = By.xpath("//div[text()='Вы привозите зарядку вместе с самокатом?']/..//div[contains(@class,'accordion__button')]");
    public By answerCharger = By.xpath("//div[@id='accordion__panel-5']");
    public By questionOrderCancel = By.xpath("//div[text()='Можно ли отменить заказ?']/..//div[contains(@class,'accordion__button')]");
    public By answerOrderCancel = By.xpath("//div[@id='accordion__panel-6']");
    public By questionMkadLife = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div/div[8]");
    public By answerMkadLife = By.xpath("//div[@id='accordion__panel-7']");

    // Форма заказа (первая форма)
    public static By fieldName = By.xpath("//input[@placeholder='* Имя']");
    public static By fieldLastName = By.xpath("//input[@placeholder='* Фамилия']");
    public static By fieldAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    public By fieldStation = By.xpath("//input[@class='select-search__input']");
    public static By fieldPhone = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    public static By buttonNext = By.xpath("//button[text()='Далее']");

    // Форма "Про аренду" (вторая форма)
    public By fieldDelivery = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    public By rentalTerm = By.xpath("//div[contains(@class,'Dropdown-placeholder') and text()='* Срок аренды']");
    public By orderButtonFormPage = By.xpath("/html/body/div[1]/div/div[2]/div[3]/button[2]");
    public By todayDate = By.xpath("//div[contains(@class,'react-datepicker__day--today')]");

    // Окно подтверждения заказа
    public By confirmButton = By.xpath("//button[text()='Да']");


}