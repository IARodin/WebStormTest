package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class ChooseYourRegion {
    String country = "Australia";
    WebDriver driver;
    public static AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ChooseYourRegion.class));

    @FindBy(xpath = "//button[@data-test='footer-country-button']")
    private WebElement countryButton;
    @FindBy(xpath = "//input[@data-test='search-input']")
    private WebElement entryField;
    @FindBy(xpath = "//li/span[@class='wt-list-item__content']")
    private WebElement chooseCountry;
    @FindBy(xpath = "//button[@data-test = 'footer-popup-confirm-country']")
    private WebElement closeAfterSelected;
    @FindBy(xpath = "//button[@data-test='footer-country-button'][contains(text(), country)]")
    public WebElement selectedAustralia;

    public ChooseYourRegion(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCountryButton() {
        countryButton.click();
        LOG.infoWithScreenshot("Открытие окна смены региона");
    }

    public void setCountry() {
        entryField.sendKeys(country);
        chooseCountry.click();
        closeAfterSelected.click();
        LOG.info("Смена региона на Australia");
    }

}
