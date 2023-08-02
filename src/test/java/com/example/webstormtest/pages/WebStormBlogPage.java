package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class WebStormBlogPage {
    WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(WebStormBlogPage.class));

    public WebStormBlogPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class = 'social-footer__link rs-link rs-link_mode_classic rs-link_theme_light'][contains(text(), 'WebStorm blog')]")
    private WebElement buttonWebStormBlog;
    @FindBy(xpath = "//a[@href='/webstorm/category/webinars/']")
    private WebElement buttonWebinars;
    @FindBy(xpath = "//div/h3[contains(text(), 'Webinar Recording: Getting Started With Vitest in WebStorm')]")
    public WebElement cardGettingStarted;
    @FindBy(xpath = "//a[@href='/webstorm/category/tips-tricks/']")
    private WebElement tapTipsAndTricks;
    @FindBy(xpath = "//h3[contains(text(), '10 Best WebStorm Themes')]")
    private WebElement cardBestWebStormThemes;

    public void clickButtonBlog() {
        buttonWebStormBlog.click();
        LOG.infoWithScreenshot("Переход на страницу блога Web Storm");

    }

    public void clickWebinars() {
        buttonWebinars.click();
        LOG.infoWithScreenshot(" Выбор вкладки вебинары");
    }

    public void clickTipsAndTricks() {
        tapTipsAndTricks.click();
        LOG.infoWithScreenshot("Выбор вкладки Советы и хитрости.");
    }

    public boolean checkCard() {
        LOG.info("Проверка, что карточка со про 10 лучших тем оформления видна на странице.");
        return cardBestWebStormThemes.isDisplayed();
    }
}
