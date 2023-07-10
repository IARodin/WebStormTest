package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class LearnPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(LearnPage.class));
    WebDriver driver;

    @FindBy(xpath = "//a[@href='/webstorm/learn/']")
    private WebElement buttonLearn;
    @FindBy(xpath = "//h3[@class='wt-h3 wt-h3_theme_light wt-offset-top-24 learn-documentation-card__title'][contains(text(), 'Get Started')]")
    public WebElement blockGetStarted;
    @FindBy(xpath = "//span[@class='menu-second-title-box__title wt-h3']")
    public WebElement buttonToWebStormPage;

    public LearnPage(WebDriver driver){
       this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButtonLearn() {
        buttonLearn.click();
        LOG.infoWithScreenshot("Переход на страницу Learn");
    }
    public boolean checkGetStartedIsVisible(){
        LOG.info("Проверка видимости блока 'Get Started'");
        return buttonLearn.isDisplayed();
    }
    public boolean checkButtonToWebStormPage(){
        LOG.info("Проверка ч");
        return buttonToWebStormPage.isEnabled();
    }

}
