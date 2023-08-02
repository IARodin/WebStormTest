package com.example.webstormtest.tests;

import com.example.webstormtest.MyExtension;
import com.example.webstormtest.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class WebStormTest extends BaseTest {
    private final WebStormPage WebStormPage = new WebStormPage(getDriver());
    private final WebStormDownloadPage WebStormDownloadPage = new WebStormDownloadPage(getDriver());
    private final WhatsNewPage WhatsNewPage = new WhatsNewPage(getDriver());
    private final LearnPage LearnPage = new LearnPage(getDriver());
    private final ChooseYourRegion ChooseYourRegion = new ChooseYourRegion(getDriver());
    private final FeaturesPage FeaturesPage = new FeaturesPage(getDriver());
    private final WebStormBlogPage WebStormBlogPage = new WebStormBlogPage(getDriver());
    private final PricingPage PricingPage = new PricingPage(getDriver());
    private final SearchPage SearchPage = new SearchPage(getDriver());
    private final AccountPage AccountPage = new AccountPage(getDriver());

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.jetbrains.com/webstorm/");
    }

    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck() {
        assertTrue(WebStormPage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка отображения кнопки Pricing на странице What's New")
    public void visiblePrisingButton() {
        WhatsNewPage.whatsNewButtonClick();
        assertTrue(WhatsNewPage.prisingButton.isEnabled(), "Элемент не отображается");
    }

    @Test
    @DisplayName("Проверим, кнопка скачивания .dmg для apple silicon активна")
    public void siliconDmgButtonCheck() {
        WebStormPage.transDownloadButton();
        WebStormDownloadPage.switchToMacOSTab();
        WebStormDownloadPage.clickDmgButton();
        assertTrue(WebStormDownloadPage.checkIfSiliconDmgClikable(), "Кнопка скачивания не активна");
    }

    @Test
    @DisplayName("Проверка отображения блока 'База знаний' в разделе 'Учиться' ")
    public void checkBlockGetStarted() {
        LearnPage.clickButtonLearn();
        assertTrue(LearnPage.checkGetStartedIsVisible(), "Блока с название 'Get Started' не найдено на странице");
    }

    @Test
    @DisplayName("Проверка смены Региона на странице WebStorm на Австралию")
    public void checkRegion() {
        ChooseYourRegion.clickCountryButton();
        ChooseYourRegion.setCountry();
        assertTrue(ChooseYourRegion.selectedAustralia.isDisplayed(), "Выбрана другая страна");
    }

    @Test
    @DisplayName("Проверка формы 'Email' для отправки заявки на получение новостей")
    public void emailInputValidation() {
        WebStormPage.inputEmail();
        assertTrue(WebStormPage.tabletThanksY.isDisplayed(), "Не удалось отправить запрос на подписку");
    }

    @Test
    @DisplayName("Проверка перехода на главную страницу https://www.jetbrains.com/.")
    public void comingPageLinkCheck() {
        assertEquals(WebStormPage.takeCurrentUrl(), "https://www.jetbrains.com/", "Адрес не совпадает");

    }

    @Test
    @DisplayName("Проверка смены языка на русский")
    public void chooseRussianLanguage() {
        WebStormPage.swapLanguage();
        assertTrue(WebStormPage.selectedRus.isDisplayed(), "Выбран не верный язык");
    }

    @Test
    @DisplayName("Проверка, вспылающее окно Cookies отображается на странице.")
    public void checkWindowCookies(){
        assertTrue(WebStormPage.acceptAll(), "Элемент на странице не найден");
    }

    @Test
    @DisplayName("Проверка в меню функции перехода по странице в раздел 'Настраиваемая среда' с помощью бокового меню")
    public void checkFunctionsMenu() {
        FeaturesPage.clickFeaturesButtonPage();
        assertTrue(FeaturesPage.checkCustomizableEnvironmentButton(), "Элемент на странице не работает");
    }

    @Test
    @DisplayName("Проверка, в разделе что в разделе блоги, есть карточка с вебинаром 'Начало работы с Vitest в WebStorm'.")
    public void checkWebStormBlog() {
        WebStormBlogPage.clickButtonBlog();
        WebStormBlogPage.clickWebinars();
        assertTrue(WebStormBlogPage.cardGettingStarted.isDisplayed(), "Такой карточки не найдено");
    }

    @Test
    @DisplayName("Проверка на странице с ценами, что цена для частных лиц на первый год составляет US $69.00.")
    public void checkPriceFirstYear() {
        PricingPage.clickButtonPricing();
        assertEquals(PricingPage.getElementText(), "US $69.00");
    }

    @Test
    @DisplayName("Проверка перехода на страницу WebStorm из результатов поисковой строки.")
    public void resultsPageSearch() {
        SearchPage.enterToSearchPanel();
        assertTrue(SearchPage.checkResultSearch(), "Элемент на странице поиска не найден");
    }

    @Test
    @DisplayName("Проверка, что кнопка Take a tour на главной странице активна. ")
    public void checkButtonTakeATourIsActive() {
        assertTrue(WebStormPage.checkButtonTakeATour(), "Элемент на странице не активен");
    }

    @Test
    @DisplayName("Проверка перехода на страницу https://www.jetbrains.com/webstorm/ , через меню Developer Tools.")
    public void checkDeveloperToolsMenu() {
        WebStormPage.clickButtonTopMenu();
        assertTrue(WebStormPage.checkButtonWebStormInTopMenu(), "Кнопка не перехода не активна в меню D.Tools");
    }

    @Test
    @DisplayName("Проверка кнопки перехода на страницу WebStorm со страницы Learn. ")
    public void checkButtonWebStormPage() {
        LearnPage.clickButtonLearn();
        assertTrue(LearnPage.checkButtonToWebStormPage(), "Клавиша на странице Learn не работает");
    }

    @Test
    @DisplayName("Проверка, на странице блога в разделе 'Советы и хитрости', присутствие статьи про 10 лучших тем оформления.")
    public void checkCardTenBestThemes() {
        WebStormBlogPage.clickButtonBlog();
        WebStormBlogPage.clickTipsAndTricks();
        assertTrue(WebStormBlogPage.checkCard(), "Карточка не найдена на странице");
    }

    @Test
    @DisplayName("Проверка страницы с регистрацией вводим адрес эл. почты, проверяем, что нас переводит на страницу 'Thank you for registering your JetBrains Account!'")
    public void checkPositiveMessageForRegAcc() {
        WebStormPage.clickButtonAccountPage();
        AccountPage.inputTrueEmailAddress();
        assertTrue(AccountPage.messageMadeAccount.isDisplayed(), "Сообщение не отображается");
    }

    @Test
    @DisplayName("Негативный тест. Проверка страницы с регистрацией, вводим заведомо неверный формат адреса эл. почты, проверяем, что высвечивается сообщение 'Please check the email format.'")
    public void checkNegativeMessageForRegAcc() {
        WebStormPage.clickButtonAccountPage();
        AccountPage.inputNotTrueEmailAddress();
        assertTrue(AccountPage.messageCheckEmailFormat.isDisplayed(), "Сообщение не отображается");
    }

    @Test
    @DisplayName("Неверный логин или пароль")
    public void checkNegativeAccount() {
        WebStormPage.clickButtonAccountPage();
        AccountPage.inputUserNameAndPassword();
        assertTrue(AccountPage.messageIncorrectUnAndPass.isDisplayed(), "Сообщение не отображается");
    }
}