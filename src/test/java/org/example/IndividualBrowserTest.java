package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IndividualBrowserTest {
        WebDriver driver;

        @Test
        public void testExamplePageOnMultipleBrowsersOnChrome() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
            String text = driver.findElement(By.cssSelector(".info-title")).getText();
            Assert.assertEquals(text, "Вход в систему");
            driver.close();

        }

        @Test
        public void testExamplePageOnMultipleBrowsersOnFirefox() {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get("https://lmslite47vr.demo.mirapolis.ru/mira");
            String text = driver.findElement(By.cssSelector(".info-title")).getText();
            Assert.assertEquals(text, "Вход в систему");
            driver.close();
        }
    }

