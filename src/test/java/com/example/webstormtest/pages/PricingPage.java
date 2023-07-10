package com.example.webstormtest.pages;


import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class PricingPage {
    WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(PricingPage.class));
    public PricingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@class= 'wt-col-inline wt-button wt-button_size_s wt-button_mode_outline'][@href= '/webstorm/buy/']")
    private WebElement buttonPricing;
    @FindBy(xpath = "//div[contains(text(), 'For Individual Use')]")
    private WebElement individualUsePrice;
    @FindBy(xpath = "//div[@class='nowrap rs-subtitle-2 rs-subtitle-2_theme_light'][contains(text(), '69.00')]")
    public WebElement priceForFirstYear;

    public void clickButtonPricing(){
        buttonPricing.click();
        LOG.infoWithScreenshot("Переход на страницу с ценами");
        individualUsePrice.click();
        LOG.info("Выбираем вкладку 'Для частных лиц'");
    }
    public String getElementText(){
        String textForFirstYear = priceForFirstYear.getText();
        LOG.info("Получаем с ценой из элемента на странице");
        return textForFirstYear;
    }
}
