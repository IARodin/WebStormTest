package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class WebStormDownloadPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(WebStormDownloadPage.class));
    WebDriver driver;

    @FindBy(xpath = "//div[contains(text(), 'macOS')]")
    private WebElement macOSTab;
    @FindBy(xpath = "//button[contains(text(), '.dmg')]")
    private WebElement dmgButton;
    @FindBy(xpath = "//span[contains(text(), '.dmg (Apple Silicon)')]")
    private WebElement siliconDownload;

    public WebStormDownloadPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchToMacOSTab(){
        macOSTab.click();
        LOG.info("Переход во вкладку macOS");
    }

    public void clickDmgButton() {
        dmgButton.click();
        LOG.infoWithScreenshot("Клик по кнопке dmg");
    }
    public Boolean checkIfSiliconDmgClikable(){
        LOG.info("Проверка, что кнопка .dmg (Apple Silicon) активна");
        return siliconDownload.isEnabled();
    }

}
