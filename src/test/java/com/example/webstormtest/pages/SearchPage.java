package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(SearchPage.class));
    @FindBy(xpath = "//input[@placeholder='Ctrl+K for advanced search']")
    public WebElement setSearchPanel;
    @FindBy(css = "button[aria-label='Open search']")
    private WebElement buttonSearch;
    @FindBy(xpath = "//a[@href='https://www.jetbrains.com/webstorm/']")
    private WebElement resultOfSearch;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterToSearchPanel() {
        buttonSearch.click();
        LOG.info("Открытие строки поиска.");
        setSearchPanel.sendKeys("Web Storm");
        LOG.infoWithScreenshot("Ввод в поисковую строку WebStrom");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(), ': The Smartest JavaScript IDE, by JetBrains' )]")));
        setSearchPanel.sendKeys(Keys.ENTER);
        LOG.info("Нажимаем кнопку ввод");
    }

    public boolean checkResultSearch() {
        LOG.info("Проверка что на странице поиска присутствует ссылка на страницу Web Storm");
        return resultOfSearch.isDisplayed();
    }
}
