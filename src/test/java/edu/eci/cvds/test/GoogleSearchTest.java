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
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.JavascriptExecutor;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
                options.addArguments("test-type");
                options.addArguments("start-maximized");
                options.addArguments("--enable-automation");
                options.addArguments("test-type=browser");
                options.addArguments("disable-infobars");
                driver = new ChromeDriver(options);
		//driver.manage().window().maximize();
		driver.get("http://ecibrary.herokuapp.com/");
	}

	@Test
	public void testGooglePage() {
	    /*	
	    WebElement searchBox = driver.findElement(By.name("q"));
	    searchBox.clear();
	    searchBox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software");
	    searchBox.submit();
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	    assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Google Search",driver.getTitle());
            */
	}
	
	/*@Test void localizadores() {
		 
		By locator = By.id("id_del_elemento");
		
		By locator_name = By.name("name_elemnt");
		
		By locator_className = By.className("clase_elemento");
		
		By locator_tagName = By.tagName("tag");
		
		By locator_linktext = By.linkText("texto_link");
		
		By locator_partialLinkText = By.partialLinkText("parte_texto");
		
		By locator_cssSelector = By.cssSelector("input[name='q']");
		
		By locator_Xpath = By.xpath("//input[@name='q']");
		
		// JavaScript
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement searchBox = (WebElement)js.executeScript("return document.getElementsByName('q')[0]");
		
	}*/
	
	//@After
	//public void tearDown() {
	//	driver.quit();
	//}

}
