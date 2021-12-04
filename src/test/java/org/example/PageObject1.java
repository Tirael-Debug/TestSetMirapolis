package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PageObject1 {
    private WebDriver chromeDriver;
    private WebDriver firefoxDriver;
    private Actions builder;
    private String login = "user";
    private String password="password";
    private String button_submit_login="button_submit_login_form";
    private String forget_pass_link = ".mira-default-login-page-link > div";
    private String see_password="show_password";

    public PageObject1(WebDriver driver, Actions builder) {
        this.chromeDriver = driver;
        this.builder = builder;
    }

    public WebDriver getDriver() {
        return chromeDriver;
    }

    public void setLogin(String loginValue){
        chromeDriver.findElement(By.name(login)).sendKeys(loginValue);
    }

    public void setPassword(String passwordValue){
        chromeDriver.findElement(By.name(password)).sendKeys(passwordValue);
    }

    public String getPasswordValue(){
        return chromeDriver.findElement(By.name(password)).getAttribute("value");
    }


    public void setForget_pass_link(){
        chromeDriver.findElement(By.cssSelector(forget_pass_link)).click();
    }

    public void setButton_submit_login(){
        chromeDriver.findElement(By.id(button_submit_login)).click();
    }

    public void setSee_password(){
        chromeDriver.findElement(By.id(see_password)).click();
    }

}
