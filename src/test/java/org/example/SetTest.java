package org.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SetTest {

    private PageObject1 pageObject1;

    @Before
    public void setUp() {
        ChromeDriver chromeDriver = new ChromeDriver();
        //WebDriver firefoxDriver = new FirefoxDriver();
        pageObject1 = new PageObject1(chromeDriver, new Actions(chromeDriver));
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        pageObject1.getDriver().quit();
    }

    @Test
    //1. Авторизация с валидными данными. Позитивный тест.
    public void successfulAuthorizationTest() {
        pageObject1.getDriver().get("https://lmslite47vr.demo.mirapolis.ru/mira");
        pageObject1.setLogin("fominaelena");
        pageObject1.setPassword("1P73BP4Z");
        pageObject1.setButton_submit_login();
        Assert.assertNotNull(pageObject1.getDriver().findElement(By.cssSelector(".avatar")));
        pageObject1.getDriver().findElement(By.cssSelector(".avatar")).click();
        pageObject1.getDriver().findElement(By.cssSelector(".request > .mira-link-text")).click();
        pageObject1.getDriver().close();

    }

    @Test
    //2. Авторизация с пустыми полями логин и пароль. Негативный тест.
    public void emptyAuthorizationFields() {
        pageObject1.getDriver().get("https://lmslite47vr.demo.mirapolis.ru/mira");
        pageObject1.setButton_submit_login();
        Alert alert = pageObject1.getDriver().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Неверные данные для авторизации.");
        alert.accept();
        pageObject1.getDriver().close();

    }

    @Test
    //3. Авторизация с логином без пароля
    public void loginWithoutPassword() {
        pageObject1.getDriver().get("https://lmslite47vr.demo.mirapolis.ru/mira");
        pageObject1.setLogin("fominaelena");
        pageObject1.setButton_submit_login();
        Alert alert = pageObject1.getDriver().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Неверные данные для авторизации.");
        alert.accept();
        pageObject1.getDriver().close();

    }

    @Test
    //4. Авторизация с паролем без логина
    public void passwordWithoutLogin() {
        pageObject1.getDriver().get("https://lmslite47vr.demo.mirapolis.ru/mira");
        pageObject1.setPassword("1P73BP4Z");
        pageObject1.setButton_submit_login();
        Alert alert = pageObject1.getDriver().switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Неверные данные для авторизации.");
        alert.accept();
        pageObject1.getDriver().close();
        Assert.assertTrue(true);
    }

    //5. Проверка работоспособности ссылки «Забыли пароль»
    @Test
    public void linkForgotPassword() {
        pageObject1.getDriver().get("https://lmslite47vr.demo.mirapolis.ru/mira");
        pageObject1.setForget_pass_link();
        String text = pageObject1.getDriver().findElement(By.cssSelector(".info-title")).getText();
        Assert.assertEquals(text, "Восстановление пароля");
        pageObject1.getDriver().close();

    }

    //6.Возвращение на страницу авторизации со страницы восстановления пароля после нажатия ссылки "Назад к входу системы"
    @Test
    public void backToTheAuthorizationPage() {
        pageObject1.getDriver().get("https://lmslite47vr.demo.mirapolis.ru/mira");
        pageObject1.setForget_pass_link();
        pageObject1.getDriver().findElement(By.cssSelector(".mira-page-forgot-password-link")).click();
        String text = pageObject1.getDriver().findElement(By.cssSelector(".info-title")).getText();
        Assert.assertEquals(text, "Вход в систему");
        pageObject1.getDriver().close();
    }

    //7. Отображение раскрытых значений скрытого пароля на странице авторизации после нажатия на кнопку отображения пароля в поле "пароль".
    @Test
    public void passwordDisplay() {
        pageObject1.getDriver().get("https://lmslite47vr.demo.mirapolis.ru/mira");
        pageObject1.setPassword("qwerty123");
        pageObject1.setSee_password();
        String seePasswordValue = pageObject1.getPasswordValue();
        Assert.assertEquals(seePasswordValue,"qwerty123");
        pageObject1.getDriver().close();

    }



}