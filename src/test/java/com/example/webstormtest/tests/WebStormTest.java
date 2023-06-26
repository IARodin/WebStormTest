package com.example.webstormtest.tests;

import com.example.webstormtest.MyExtension;
import com.example.webstormtest.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class WebStormTest extends BaseTest{
    private WebStormPage WebStormPage;
    private WebStormDownloadPage WebStormDownloadPage;
    private WhatsNewPage WhatsNewPage;
    private LearnPage LearnPage;
    private ChooseYourRegion ChooseYourRegion;

    @BeforeEach
    @Override
    public void setUp(){
        super.setUp();
        getDriver().get("https://www.jetbrains.com/webstorm/");
        WebStormPage = new WebStormPage(getDriver());
        WebStormDownloadPage = new WebStormDownloadPage(getDriver());
        WhatsNewPage = new WhatsNewPage(getDriver());
        LearnPage = new LearnPage(getDriver());
        ChooseYourRegion = new ChooseYourRegion(getDriver());
    }
    @Test
    @DisplayName("Проверка, что кнопка скачивания активна")
    public void buttonCheck(){
        assertTrue(WebStormPage.checkIfDownloadButtonIsClickable(), "Кнопка скачивания не активна");
    }
    @Test
    @DisplayName("Проверка отображения кнопки Pricing на странице What's New")
    public void visiblePrisingButton(){
        WhatsNewPage.whatsNewButtonClick();
        assertTrue(WhatsNewPage.prisingButton.isEnabled(), "Элемент не отображается");
    }
    @Test
    @DisplayName("Проверим, кнопка скачивания .dmg для apple silicon активна")
    public void siliconDmgButtonCheck(){
        WebStormPage.transDownloadButton();
        WebStormDownloadPage.switchToMacOSTab();
        WebStormDownloadPage.clickDmgButton();
        assertTrue(WebStormDownloadPage.checkIfSiliconDmgClikable(), "Кнопка скачивания не активна");
    }
    @Test
    @DisplayName("Проверка отображения блока 'База знаний' в разделе 'Учиться' ")
    public void checkBlockGetStarted() {
        LearnPage.clickButtonLearn();
        assertTrue(LearnPage.checkGetStartedIsVisible(), "Блока с название 'Get Started' не найдено на странице");
    }
    @Test
    @DisplayName("Проверка смены Региона на странице WebStorm на Австралию")
    public void checkRegion(){
        ChooseYourRegion.clickCountryButton();
        ChooseYourRegion.setCountry();
        assertTrue(ChooseYourRegion.selectedAustralia.isDisplayed(), "Выбрана другая страна");
    }
}