package com.example.webstormtest.pages;

import com.example.webstormtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class AccountPage {
    public final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(AccountPage.class));
    WebDriver driver;
    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@placeholder='Your email address']")
    private WebElement inputEmailAddress;
    @FindBy(xpath = "//button[contains(text(), 'Sign Up')]")
    private WebElement buttonSignUp;
    @FindBy(xpath = "//h2[contains(text(), 'Thank you for registering your JetBrains Account!')]")
    public WebElement messageMadeAccount;
    @FindBy(xpath = "//div[@class='alert alert-danger'][contains(text(), 'Please check the email format.')]")
    public WebElement messageCheckEmailFormat;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//button[contains(text(), 'Sign In')]")
    private WebElement buttonSignIn;
    @FindBy(xpath = "//div[@class=\"js-auth-dialog-div-errors text-danger\"][contains(text(), 'Incorrect username and/or password')]")
    public WebElement messageIncorrectUnAndPass;

    public void inputTrueEmailAddress(){
        inputEmailAddress.sendKeys("sssdaxssss@mail.com");
        LOG.infoWithScreenshot("Вводим верный email адрес");
        buttonSignUp.click();
        LOG.info("Нажимаем клавишу создания акк.");
    }
    public void inputNotTrueEmailAddress(){
        inputEmailAddress.sendKeys("_Sasdasdedasda@s.ss");
        LOG.infoWithScreenshot("Вводим заведомо не верный email адрес");
        buttonSignUp.click();
        LOG.info("Нажимаем клавишу создания акк.");
    }
    public void inputUserNameAndPassword(){
        inputUserName.sendKeys("ssddasd");
        inputPassword.sendKeys("sadasdas");
        LOG.infoWithScreenshot("Вводим заведомо не верный email адрес и пароль");
        buttonSignIn.click();
        LOG.info("Нажимаем на клавишу войти");
    }
}
