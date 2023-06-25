package com.example.webstormtest.tests;

import com.example.webstormtest.pages.MainPage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainPageTest extends BaseTest{
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        mainPage = new MainPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        mainPage.searchButton.click();

        WebElement searchField = driver.findElement(By.cssSelector("[data-test='search-input']"));
        searchField.sendKeys("Selenium");

        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
        submitButton.click();

        WebElement searchPageField = driver.findElement(By.cssSelector("input[data-test='search-input']"));
        assertEquals("Selenium", searchPageField.getAttribute("value"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        WebElement menuPopup = driver.findElement(By.cssSelector("div[data-test='main-submenu']"));
        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        WebElement productsList = driver.findElement(By.id("products-page"));
        assertTrue(productsList.isDisplayed());
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}
