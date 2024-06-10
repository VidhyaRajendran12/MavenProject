package knowMaven.myPack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleSearchPage {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

	}

	@Test(priority = 0)
	public void googleSearch() throws InterruptedException {

		String searchContent = "mvnrepository";
		driver.get("https://www.google.co.in/");

		driver.findElement(By.id("APjFqb")).sendKeys(searchContent);

		WebElement searchBox = driver.findElement(By.id("APjFqb"));
		searchBox.sendKeys(searchContent);

		searchBox.sendKeys(Keys.ENTER);
		String firstResult = driver.findElement(By.cssSelector(".VuuXrf")).getText();

		Assert.assertTrue(firstResult.contains("Maven"));
	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}
}
