package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class FeaturesPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(FeaturesPage.class));
    WebDriver driver;

    @FindBy(css = ".menu-item + a[href='/webstorm/features/']")
    private WebElement featuresButtonPage;
    @FindBy(xpath = "//a[@class='toc-item toc-item--selected toc-item--theme-light timeline-react_link _without-control']")
    private WebElement customizableEnvironmentButton;

    public FeaturesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void clickFeaturesButtonPage() {
        featuresButtonPage.click();
        LOG.infoWithScreenshot("Переход на страницу 'Features'");
        customizableEnvironmentButton.click();
        LOG.infoWithScreenshot("Нажатие на клавишу  'Customizable environment' в боковом меню.");
    }

    public boolean checkCustomizableEnvironmentButton() {
        LOG.info("Проверка, что кнопка 'Customizable Environment' активна");
        return customizableEnvironmentButton.isEnabled();
    }
}
