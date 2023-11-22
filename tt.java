package Modules;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import AccessLevel.Data;

public class tt extends Data {
	@Test
	@Parameters({"uname", "pass"})
	public void te(String uname, String pass) throws Exception {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			Actions action = new Actions(driver);
			JavascriptExecutor jse = (JavascriptExecutor)driver;

			//validation - Other
			driver.navigate().to(Customers);
			driver.findElement(By.id("showCustomerTVFilters")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("div.customer-adv-filters")).isDisplayed();
			jse.executeScript("document.querySelector('#campuser').scrollTop = 300");
			driver.findElement(By.id("ctformsIds")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("label[data-text=\"New Test Form !!))@@\"]")).click();
			driver.findElement(By.id("ctformsIds")).click();
			Thread.sleep(5000);
			String a = driver.findElement(By.cssSelector("div.filter-bottom-box>div>a>span")).getText();
			Assert.assertEquals(a, "1", "Count mismatched in customer filter");
			
		}
}