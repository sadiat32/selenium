package com.mycompanyname;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver driver;

    @BeforeMethod
     public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sadia\\Downloads\\chromedriver_win32 (1).exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");}
    @Test
    public void test1() throws InterruptedException {
        String expectedTitle = "Amazon is number one.";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "title validation success");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }
    @Test
    public void test2() throws InterruptedException {///looking for an iphone
       // WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        // searchBox.sendKeys("Iphone x");
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).click();

    }
    @AfterMethod
    public void afterMethod(){
        driver.close();}
}
