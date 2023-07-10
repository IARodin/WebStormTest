package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

//page url = https://www.jetbrains.com/webstorm/nextversion/
public class ComingInPage {
    public final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ComingInPage.class));
    WebDriver driver;
    @FindBy(xpath = "//a[@href='/webstorm/nextversion/']")
    private WebElement buttonComingIn;
    @FindBy(xpath = "//button[@data-test='dropdown-trigger']")
    private WebElement tarButton;
    @FindBy(xpath = "//span[@class= '_content_1v6h6tr_40'][contains(text(), '.tar.gz (Linux ARM64)')]")
    private WebElement linuxDownload;

    public ComingInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setButtonComingIn() {
        buttonComingIn.click();
        LOG.infoWithScreenshot("Переход на страницу Coming in 2023.2");
    }
    public String takeCurrentUrl(){
        String currentUrl = driver.getCurrentUrl();
        LOG.info("Полученный адрес "+ currentUrl);
        return currentUrl;
    }
    public void clickTarButton(){
        buttonComingIn.click();
        LOG.info("Переход на страницу Coming in 2023.2");
        tarButton.click();
        LOG.info("Нажатие на клавишу с расширением файлов для загрузки");

    }
    public boolean checkButtonLinuxDownload() {
        linuxDownload.isDisplayed();
        LOG.infoWithScreenshot("Выбор версии для Linux ARM 64 с расширением taz.gz ");
        return linuxDownload.isEnabled();
    }
}
