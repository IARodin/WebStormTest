package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

//page url = https://www.jetbrains.com/webstorm/
public class WebStormPage {
    public final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(WebStormPage.class));
    WebDriver driver;
    @FindBy(css = "a[data-test='button' ][href ='/webstorm/download/download-thanks.html']")
    private WebElement downloadButton;
    @FindBy(xpath = "//*[@id=\"js-menu-second-desktop\"]/a[6]")
    private WebElement setDownloadButton;
    @FindBy(xpath = "//div/input[@placeholder='Email']")
    public WebElement inputEmail;
    @FindBy(xpath = "//div/button[@type='submit']")
    public WebElement buttonSubmit;
    @FindBy(xpath = "//p[@class = 'rs-text-2 rs-text-2_hardness_hard rs-text-2_theme_light wt-offset-top-24']")
    public WebElement tabletThanksY;
    @FindBy(xpath = "//*[@id=\"footer-container\"]/footer/div/div[2]/div[2]/div/span/button")
    public WebElement buttonLang;
    @FindBy(xpath = "//span[@class='wt-list-item__content'][contains(text(), 'Русский')]")
    private WebElement setRussian;
    @FindBy(xpath = "//button[@data-test='language-picker'][contains(text(), 'Русский')]")
    public WebElement selectedRus;
    @FindBy(xpath = "//button[@data-test='button'][contains(text(), 'Take ')]")
    private WebElement takeATourButton;
    @FindBy(xpath = "//button[@aria-label=\"Developer Tools: Open submenu\"][contains(text(), 'Developer Tools')]")
    private WebElement buttonTopMenu;
    @FindBy(xpath = "//a[@data-test='site-header-profile-action']")
    private WebElement buttonAccountPage;
    @FindBy(xpath = "//button[@class=\"jetbrains-cookies-banner-3-button jetbrains-cookies-banner-3-button--accent jetbrains-cookies-banner-3__action\"]")
    private WebElement windowCookies;
    @FindBy(xpath = "//a[@aria-label='Navigate to main page']")
    private WebElement buttonToMainPage;

    public WebStormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean checkIfDownloadButtonIsClickable() {
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public void transDownloadButton() {
        setDownloadButton.click();
        LOG.infoWithScreenshot("Переход на страницу загрузки");
    }

    public void inputEmail() {
        String email = "1112@sw.gnu";
        LOG.infoWithScreenshot("Вводим Email в поле");
        inputEmail.sendKeys(email);
        buttonSubmit.click();
        LOG.info("Нажимаем на клавишу Submit");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(buttonSubmit));
        LOG.info("Воспользуемся явным ожиданием чтобы убедиться что элемент не отображается на странице");
    }

    public void waitWindowCookies() {
        LOG.info("Используем явное ожидание баннера");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(windowCookies));
    }
    public String takeCurrentUrl() {
        LOG.info("Нажимаем на элемент на странице");
        buttonToMainPage.click();
        String currentUrl = driver.getCurrentUrl();
        LOG.info("Полученный адрес " + currentUrl);
        return currentUrl;
    }
    public boolean acceptAll() {
        LOG.info("Проверка, отображения кнопки 'Accept All'");
        return windowCookies.isEnabled();
    }

    public void swapLanguage() {
        waitWindowCookies();
        windowCookies.click();
        buttonLang.click();
        LOG.infoWithScreenshot("Нажимаем на клавишу смены языка");
        setRussian.click();
        LOG.infoWithScreenshot("Выбираем Русский язык");
    }

    public boolean checkButtonTakeATour() {
        LOG.infoWithScreenshot("Кнопка Take a tour активна.");
        return takeATourButton.isEnabled();
    }

    public void clickButtonTopMenu() {
        LOG.infoWithScreenshot("Открытие меню Developer Tools");
        buttonTopMenu.click();
    }

    public boolean checkButtonWebStormInTopMenu() {
        LOG.info("Проверка что кнопка WebStorm в меню Developer Tools активна");
        return buttonTopMenu.isEnabled();
    }

    public void clickButtonAccountPage() {
        LOG.info("Переход на страницу Аккаунта Jet Brains");
        buttonAccountPage.click();
    }
}
