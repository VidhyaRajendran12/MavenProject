package knowMaven.myPack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class leafGroundUrl {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test(priority = 0)
	public void leafGround() throws InterruptedException {

		driver.get("https://leafground.com/button.xhtml;");
		driver.findElement(By.xpath("//*[text()='Click']")).click();
		String titlePage = driver.getTitle();
		Assert.assertEquals("Dashboard", titlePage);

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}
}
