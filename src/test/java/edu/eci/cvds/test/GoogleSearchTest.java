/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.test;

/**
 *
 * @author 2150244
 */
//import static org.junit.Assert.*;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.JavascriptExecutor;

public class GoogleSearchTest {
	
//	private WebDriver driver;
//	private WebDriver driver2;
//
//	 @Before
//	 public void setUp() throws Exception {
//	 	System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
//
////	 	driver.manage().window().maximize();
//
//
//	 }
//
//	 @Test
//	 public void deberiaConsultarRecursosDisponibles() throws InterruptedException {
//             ChromeOptions options = new ChromeOptions();
//             options.addArguments("test-type");
//             options.addArguments("start-maximized");
//             options.addArguments("--enable-automation");
//             options.addArguments("test-type=browser");
//             options.addArguments("disable-infobars");
//             driver = new ChromeDriver(options);
//             driver.get("http://ecibrary.herokuapp.com/");
//             Actions action=new Actions(driver);
//             action.moveToElement(driver.findElement(By.className("actions"))).build().perform();
//             Thread.sleep(3000);
//             driver.findElement(By.xpath("//div[@class='actions']//a[text()='Consultar recursos']")).click();
//             String URL = driver.getCurrentUrl();
//             Assert.assertEquals(URL, "http://ecibrary.herokuapp.com/faces/recursosDisponibles.xhtml");
//             Thread.sleep(3000);
//             driver.quit();
//
//	 }
//
//         @Test
//	 public void deberiaDevolverseVistainicioDeVistaRecurDisponibles() throws InterruptedException {
//             ChromeOptions options2 = new ChromeOptions();
//             options2.addArguments("test-type");
//             options2.addArguments("start-maximized");
//             options2.addArguments("--enable-automation");
//             options2.addArguments("test-type=browser");
//             options2.addArguments("disable-infobars");
//             driver2 = new ChromeDriver(options2);
//             driver2.get("http://ecibrary.herokuapp.com/faces/recursosDisponibles.xhtml");
//             Actions action=new Actions(driver2);
//             action.moveToElement(driver2.findElement(By.className("aw-item-link"))).build().perform();
//             Thread.sleep(3000);
//             driver2.findElement(By.xpath("//li//a//i[@class='fa fa-fw  fa-angle-left pull-right']")).click();
//             Thread.sleep(3000);
//             driver2.findElement(By.xpath("//li//ul//li//a[@value='login yas']")).click();
//             Thread.sleep(3000);
//             String URL = driver2.getCurrentUrl();
//             Assert.assertEquals(URL, "http://ecibrary.herokuapp.com/faces/index.html");
//             driver2.quit();
//         }

}
