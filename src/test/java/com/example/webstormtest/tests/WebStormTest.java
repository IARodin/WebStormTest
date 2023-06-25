package com.example.webstormtest.tests;

import com.example.webstormtest.pages.WebStormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebStormTest extends BaseTest{
    private WebStormPage WebStormPage;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/webstorm/");
        WebStormPage = new WebStormPage(getDriver());
    }
    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheak(){
        assertTrue(WebStormPage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }
    @Test
    @DisplayName("Проверка отображения кнопки Pricing на странице What's New")
    public void visibleButton(){
        WebStormPage.whatsNewButtonClick();
        assertTrue(WebStormPage.prisingButton.isEnabled(), "Элемент не отображается");
    }
}