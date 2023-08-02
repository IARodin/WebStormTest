package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

//page url https://www.jetbrains.com/webstorm/whatsnew/
public class WhatsNewPage {
    public final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(WhatsNewPage.class));
    WebDriver driver;
    @FindBy(xpath = "//a[@href='/webstorm/whatsnew/']")
    private WebElement whatsNewButton;
    @FindBy(xpath = "//a[@href='/webstorm/buy/']")
    public WebElement prisingButton;

    public WhatsNewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void whatsNewButtonClick() {
        whatsNewButton.click();
        LOG.infoWithScreenshot("Переход на страницу Whats New");
    }
}
