package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;


public class firstTest {
    @Test
    public void makingChromeDo() throws InterruptedException {

        System.setProperty("webDriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://www.google.com";
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().deleteCookieNamed ("CONSENT");
        driver.manage().addCookie(new Cookie("CONSENT","YES+shp.gws-"+ LocalDate.now().toString().replace("-","")+"-0-RC2.en+FX+374"));
        driver.navigate().refresh();
        driver.findElement(By.className("gLFyf")).sendKeys("potato");
        driver.findElement(By.name("btnK")).click();
        Thread.sleep(3000);
        driver.quit();



    }
}