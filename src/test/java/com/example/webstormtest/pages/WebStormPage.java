package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//page url = https://www.jetbrains.com/webstorm/
public class WebStormPage {
    public final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(WebStormPage.class));
    WebDriver driver;
    @FindBy(css = "a[data-test='button' ][href ='/webstorm/download/download-thanks.html']")
    private WebElement downloadButton;
    @FindBy(xpath = "//*[@id=\"js-menu-second-desktop\"]/a[6]")
    private WebElement setDownloadButton;

    public WebStormPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public Boolean checkIfDownloadButtonIsClickable(){
        LOG.info("Проверка активности кнопки загрузки");
        return downloadButton.isEnabled();
    }

    public void transDownloadButton(){
        setDownloadButton.click();
        LOG.infoWithScreenshot("Переход на страницу загрузки");
    }


}
