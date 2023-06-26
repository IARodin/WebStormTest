package com.example.webstormtest.tests;

import com.example.webstormtest.AllureAttachmentManager;
import com.example.webstormtest.MyExtension;
import com.example.webstormtest.pages.WebStormDownloadPage;
import com.example.webstormtest.pages.WebStormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class WebStormTest extends BaseTest{
    private WebStormPage WebStormPage;
    private WebStormDownloadPage WebStormDownloadPage;
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
    @Test
    @DisplayName("Проверим, кнопка скачивания .dmg для apple silicon активна")
    public void siliconDmgButtonCheck(){
        WebStormPage.transDownloadButton();
        WebStormDownloadPage.switchToMacOSTab();
        WebStormDownloadPage.clickDmgButton();
        assertTrue(WebStormDownloadPage.checkIfSiliconDmgClikable(), "Кнопка скачивания не активна");
    }
}