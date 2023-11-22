package Modules;

import java.time.Duration;
import java.util.Set;

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

public class Calendar extends Data{

	@Test
	public void Appointment() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);

		Login2();

		System.out.println();
		System.out.println("New one on one Appointment type ----->");	

		WebElement e = driver.findElement(By.cssSelector("div.hidden.sidebar-bg-color"));
		action.moveToElement(e).perform();
		jse.executeScript("document.querySelector('html > body > div > div:nth-of-type(2)').scrollTop=400");
		String apcnt= driver.findElement(By.cssSelector("a[title=\"Calendar\"]>span.msg-badge.bubble-number.ml-2")).getText();
		System.out.println("Appointment Count Before Sceduling Appointment: "+apcnt);
		driver.findElement(By.linkText("Appointment Types")).click();

		//Checking for duplicate
		driver.findElement(By.name("search")).sendKeys("Test Appointment 110022");
		action.sendKeys(Keys.ENTER).perform();

		try 
		{
			driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>a")).click();//appointment menu
			driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>div>a:nth-of-type(4)")).click(); // delete option
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("form#formdeleteactionmodaldiv>div>button")).click();
		}
		catch(Exception q) 
		{	

		}

		//Creating New Appointment
		driver.findElement(By.id("eventtypebutton")).click();
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div[2]/a")).click();
		driver.findElement(By.id("appttypename_title")).sendKeys("Test Appointment 110022");
		driver.findElement(By.cssSelector("div.mb-5.loc>div.nice-select:first-of-type")).click();
		jse.executeScript("scroll(0,200)");
		driver.findElement(By.cssSelector("li[data-value=\"inperson\"]")).click();
		driver.findElement(By.id("appttypedesc")).sendKeys("Test user");
		jse.executeScript("scroll(0,0)");
		driver.findElement(By.cssSelector("div.appt-head-section>div:nth-of-type(3)>button[type=\"button\"]")).click();
		Thread.sleep(2000);

		jse.executeScript("scroll(0,500)");		
		driver.findElement(By.cssSelector("div.scheduleinnerdata>div:first-child>div>div+div")).click();
		driver.findElement(By.cssSelector("span.select2-selection__rendered")).click();
		driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("Asia/Kolkata");
		action.sendKeys(Keys.ENTER).perform();

		try
		{
			jse.executeScript("document.getElementsByName('to_time[0][]')[0].setAttribute('value','11:45 PM')");
		}
		catch (Exception JavaScriptException)
		{
			driver.findElement(By.cssSelector("a[data-dayid = \"0\"]")).click();
			jse.executeScript("document.getElementsByName('to_time[0][]')[0].setAttribute('value','11:45 PM')");
		}

		driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>a")).click();

		for(int i=3;i<=8;i++)
		{
			driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>div>label:nth-child("+i+")>span")).click();
		}

		driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>div>div>button")).click();
		jse.executeScript("scroll(0,0)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[4]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,200)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[6]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,400)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[7]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,400)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[8]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		String event = driver.findElement(By.cssSelector("div.toast")).getText();
		System.out.println(event);
		jse.executeScript("scroll(0,0)");
		String evstat = driver.findElement(By.cssSelector("label[for=\"toggleB\"]>div")).getText();
		System.out.println("Event status : "+evstat);
		Thread.sleep(2000);
		String pwindo = driver.getWindowHandle();

		//validating landing page
		driver.findElement(By.cssSelector("a[data-url]")).click();
		Set<String> handles = driver.getWindowHandles();

		for (String handle: handles) 
		{
			driver.switchTo().window(handle);
		}

		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a[href=\"#\"]:first-of-type")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.time-button:first-of-type")).click();
		Thread.sleep(1000);

		try 
		{
			driver.findElement(By.xpath("//*[@id=\"block0body\"]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/button[2]")).click();
		}
		catch(Exception NoSuchElementException) 
		{
			driver.findElement(By.cssSelector("tr:nth-of-type(4)>td[data-handler=selectDay]:nth-of-type(2)>a[href=\"#\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("button.time-button:first-of-type")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"block0body\"]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/button[2]")).click();
			//System.out.println("Unable to validate this appointment in Day, Week, month view please check it manually");
		}

		driver.findElement(By.name("contactname")).sendKeys("Test name 110022");
		driver.findElement(By.name("contactemail")).sendKeys("nadsoft.test99@gmail.com");
		driver.findElement(By.name("contactphone")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("button.sch-event-btn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("h2[style= \"font-size: 1.25rem;\"]")).getText());
		System.out.println(driver.findElement(By.cssSelector("span.evt-time-selected")).getText());
		System.out.println(driver.findElement(By.cssSelector("span.evt-date-selected")).getText());
		driver.close();
		driver.switchTo().window(pwindo);

		// Validating appointment on calendar----->
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement r = driver.findElement(By.cssSelector("div.hidden.sidebar-bg-color"));
		action.moveToElement(r).perform();
		jse.executeScript("document.querySelector('html > body > div > div:nth-of-type(2)').scrollTop=300");
		String afterapcnt = driver.findElement(By.cssSelector("a[title=\"Calendar\"]>span.msg-badge.bubble-number.ml-2")).getText();
		driver.navigate().to("https://app.deposyt.com/index.php?m=appointments&d=tableview");
		System.out.println("Appointment Count After Sceduling Appointment: "+afterapcnt);
		driver.findElement(By.name("search")).sendKeys("Test Appointment 110022");
		action.sendKeys(Keys.ENTER).perform();
		String timeDetails = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>div:first-of-type")).getText();
		String datedetails = driver.findElement(By.cssSelector("h4.text-xl.font-extrabold.darkColor.mr-auto")).getText();
		String Apptname = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>h5")).getText();
		//String appid = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg")).getAttribute("data-appointment_id");
		System.out.println();
		System.out.println("Actual Details showing on the Appointment page");
		System.out.println("Appointment Name: "+Apptname);
		System.out.println("Appointment Date: "+datedetails);
		System.out.println("Appotment Time: "+timeDetails);

		driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>h5")).click();
		driver.findElement(By.cssSelector("#new-open-comman-appointmentdetails-modal>div>div>div.appt-content.grid.mt-5>div.pr-8.relative>a:nth-child(3)")).click();
		//driver.findElement(By.xpath("//*[@id=\"new-open-comman-calappointmentdetails-modal\"]/div/div/div[2]/div[2]/a[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"formdeleteactionmodaldiv\"]/div/button")).click();
		System.out.println("Appointment deleted");

	}

	@Test
	public void GroupAppointmentType() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		
		Login2();

		//New Group Appointment Type
		driver.navigate().to(Calendar);
		System.out.println();
		System.out.println("New Group Appointment type ----->");	

		driver.findElement(By.cssSelector("a.customer-filter-btn")).click();
		Thread.sleep(2000);
		String grpapcnt= driver.findElement(By.cssSelector("span.message-count-for-change>span")).getText();
		driver.navigate().to(AppType);

		//Checking for duplicate
		driver.findElement(By.name("search")).sendKeys("Test Appointment- Group 110022");
		action.sendKeys(Keys.ENTER).perform();

		try 
		{
			driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>a")).click();//appointment menu
			driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>div>a:nth-of-type(4)")).click(); // delete option
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("form#formdeleteactionmodaldiv>div>button")).click();
		}
		catch(Exception q) 
		{	

		}

		//Creating New Appointment
		driver.findElement(By.id("eventtypebutton")).click();
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div[3]/a")).click();
		driver.findElement(By.id("appttypename_title")).sendKeys("Test Appointment- Group 110022");
		driver.findElement(By.cssSelector("div.mb-5.loc>div.nice-select:first-of-type")).click(); //add location
		driver.findElement(By.cssSelector("li[data-value=\"inperson\"]")).click();
		jse.executeScript("scroll(0,200)");
		driver.findElement(By.id("appttypedesc")).sendKeys("Test user");
		jse.executeScript("scroll(0,200)");
		driver.findElement(By.id("max_group_invitee")).sendKeys("3");
		driver.findElement(By.id("is_group_invitee")).click();
		jse.executeScript("scroll(0,0)");
		driver.findElement(By.cssSelector("div.appt-head-section>div:nth-of-type(3)>button[type=\"button\"]")).click();
		Thread.sleep(2000);

		jse.executeScript("scroll(0,500)");		
		driver.findElement(By.cssSelector("div.scheduleinnerdata>div:first-child>div>div+div")).click();
		driver.findElement(By.cssSelector("span.select2-selection__rendered")).click();
		driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("Asia/Kolkata");
		action.sendKeys(Keys.ENTER).perform();

		try
		{
			jse.executeScript("document.getElementsByName('to_time[0][]')[0].setAttribute('value','11:45 PM')");
		}
		catch (Exception JavaScriptException)
		{
			driver.findElement(By.cssSelector("a[data-dayid = \"0\"]")).click();
			jse.executeScript("document.getElementsByName('to_time[0][]')[0].setAttribute('value','11:45 PM')");
		}

		driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>a")).click();

		for(int i=3;i<=8;i++)
		{
			driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>div>label:nth-child("+i+")>span")).click();
		}

		driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>div>div>button")).click();
		jse.executeScript("scroll(0,0)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[4]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,200)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[6]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,400)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[7]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,400)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[8]/div[1]/div[2]/button")).click();
		Thread.sleep(2000);
		String event = driver.findElement(By.cssSelector("div.toast")).getText();
		System.out.println("Creating New Appointment Type:");
		System.out.println("	"+event);
		jse.executeScript("scroll(0,0)");
		String evstat = driver.findElement(By.cssSelector("label[for=\"toggleB\"]>div")).getText();
		System.out.println("	Event status : "+evstat);
		Thread.sleep(2000);
		String pwindo = driver.getWindowHandle();

		//validating landing page
		driver.findElement(By.cssSelector("a[data-url]")).click();
		Set<String> handles = driver.getWindowHandles();

		for (String handle: handles) 
		{
			driver.switchTo().window(handle);
		}

		Thread.sleep(5000);
		driver.findElement(By.cssSelector("a[href=\"#\"]:first-of-type")).click();
		Thread.sleep(2000);
		String beforbookingSlots = driver.findElement(By.cssSelector("button.time-button:first-of-type>div:nth-child(2)")).getText();
		driver.findElement(By.cssSelector("button.time-button:first-of-type")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/button[2]")).click();

		driver.findElement(By.name("contactname")).sendKeys("Test grpname 110022");
		driver.findElement(By.name("contactemail")).sendKeys("nadsoft.test99@gmail.com");
		driver.findElement(By.name("contactphone")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("button.sch-event-btn")).click();
		Thread.sleep(2000);
		System.out.println("	"+driver.findElement(By.cssSelector("h2[style= \"font-size: 1.25rem;\"]")).getText());
		System.out.println("	"+driver.findElement(By.cssSelector("div.details>div:nth-child(2)>div>span.evt-time-selected")).getText());
		System.out.println("	"+driver.findElement(By.cssSelector("div.details>div:nth-child(2)>div>span.evt-date-selected")).getText());

		//Slot validation
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("a[href=\"#\"]:first-of-type")).click();
		Thread.sleep(2000);
		String afterbookingSlots = driver.findElement(By.cssSelector("button.time-button:first-of-type>div:nth-child(2)")).getText();
		System.out.println();
		System.out.println("	Spots available Before Booking Appointment: "+beforbookingSlots);
		System.out.println("	Spots available After Booking Appointment: "+afterbookingSlots);
		Assert.assertEquals(afterbookingSlots, "2 spots left", "Slots count Mismatched");
		Thread.sleep(1000);

		driver.close();
		driver.switchTo().window(pwindo);

		// Validating appointment on calendar----->
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().to(Calendar);

		driver.findElement(By.cssSelector("a.customer-filter-btn")).click();
		Thread.sleep(2000);
		String aftergrpapcnt= driver.findElement(By.cssSelector("span.message-count-for-change>span")).getText();
		System.out.println("	Appointment Count Before Sceduling Appointment: "+grpapcnt);
		System.out.println("	Appointment Count After Sceduling Appointment: "+aftergrpapcnt);
		int a = Integer.parseInt(grpapcnt);
		int b = Integer.parseInt(aftergrpapcnt);
		a = a + 1;
		Assert.assertEquals(a, b, "Count Mismatched After Booking new appointment");
		driver.findElement(By.cssSelector("a.customer-filter-btn")).click();

		driver.findElement(By.name("search")).sendKeys("Test Appointment- Group 110022");
		action.sendKeys(Keys.ENTER).perform();
		String timeDetails = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>div:first-of-type")).getText();
		String datedetails = driver.findElement(By.cssSelector("h4.text-xl.font-extrabold.darkColor.mr-auto")).getText();
		String Apptname = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>h5")).getText();
		//String appid = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg")).getAttribute("data-appointment_id");
		System.out.println();
		System.out.println("	Actual Details showing on the Appointment page");
		System.out.println("	Appointment Name: "+Apptname);
		System.out.println("	Appointment Date: "+datedetails);
		System.out.println("	Appotment Time: "+timeDetails);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>h5")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#new-open-comman-appointmentdetails-modal>div>div>div:nth-child(2)>div:nth-child(2)>a:nth-child(3)")).click();
		driver.findElement(By.xpath("//*[@id=\"formdeleteactionmodaldiv\"]/div/button")).click();
		Thread.sleep(500);
		System.out.println("	Appointment Deleted Successfully");
	}

	@Test
	public void RRAppointmentType() throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		JavascriptExecutor jse= (JavascriptExecutor)driver;

		Login2();
		
		//New Round Robin Appointment Type
		driver.navigate().to("https://app.deposyt.com/index.php?m=appointments&d=tableview");
		System.out.println();
		System.out.println("New Round Robin Appointment type ----->");	

		driver.findElement(By.cssSelector("a.customer-filter-btn")).click();
		Thread.sleep(2000);
		String grpapcnt= driver.findElement(By.cssSelector("span.message-count-for-change>span")).getText();
			
		driver.navigate().to("https://app.deposyt.com/index.php?m=appointments&d=eventtypes");

		//Checking for duplicate
		driver.findElement(By.name("search")).sendKeys("Test Appointment- RR 110022");
		action.sendKeys(Keys.ENTER).perform();
		
		try 
		{
			driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>a")).click();//appointment menu
			driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>div>a:nth-of-type(4)")).click(); // delete option
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("form#formdeleteactionmodaldiv>div>button")).click();
		}
		catch(Exception q) 
		{

		}

		//Creating New Appointment
		driver.findElement(By.id("eventtypebutton")).click();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div[5]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#host-popup>div>div>div>div>div>input")).click();
		Thread.sleep(2000);
		String User1id = driver.findElement(By.cssSelector("#host-popup>div>div>div>div>div:first-child>div>div:first-child")).getAttribute("data-id");
		String User2id = driver.findElement(By.cssSelector("#host-popup>div>div>div>div>div:first-child>div>div:nth-child(3)")).getAttribute("data-id");
		driver.findElement(By.cssSelector("#host-popup>div>div>div>div>div:first-child>div>div:nth-child(3)")).click();
		driver.findElement(By.id("linkdoneapplyss")).click();

		driver.findElement(By.id("appttypename_title")).sendKeys("Test Appointment- RR 110022");
		driver.findElement(By.id("appttypedesc")).sendKeys("Test user");
		jse.executeScript("scroll(0,0)");
		driver.findElement(By.cssSelector("div.appt-head-section>div:nth-of-type(3)>button[type=\"button\"]")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,200)");

		//Location
		driver.findElement(By.cssSelector("div.host-detail>div:nth-of-type(2)>div:first-child>div>div>div")).click();
		driver.findElement(By.cssSelector("div.appt-location.open>ul>li[data-value=\"inperson\"]")).click();
		driver.findElement(By.cssSelector("div.roundrobinteamdistribution[data-id=\""+User1id+"\"]>div:nth-child(3)>div:nth-child(2)>input")).sendKeys("Test");
		jse.executeScript("scroll(0,300)");
		driver.findElement(By.cssSelector("div.host-detail>div:nth-of-type(2)>div:nth-child(2)>div>div>div")).click();
		driver.findElement(By.cssSelector("div.appt-location.open>ul>li[data-value=\"inperson\"]")).click();
		driver.findElement(By.cssSelector("div.roundrobinteamdistribution[data-id=\""+User2id+"\"]>div:nth-child(3)>div:nth-child(2)>input")).sendKeys("Test");
		jse.executeScript("scroll(0,0)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[4]/div[1]/div[2]/button")).click();// next button
/*
		jse.executeScript("scroll(0,300)");
		WebElement icon = driver.findElement(By.cssSelector("button.seccdivsection +a.secondsectionactiontoggle"));
		action.moveToElement(icon).click().build().perform();
		jse.executeScript("scroll(0,800)");
		driver.findElement(By.cssSelector("div.appt-availability-section>div>div:nth-child(5)>div>div:nth-child(5)")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.appt-availability-section>div>div:nth-child(5)>div>div:nth-child(5)>ul>li:nth-child(2)")).click();

		try 
		{
			String Status = driver.findElement(By.cssSelector("#deactive-time-div-0>p")).getText();
			if(Status.equalsIgnoreCase("Unavailable"))
			{
				driver.findElement(By.cssSelector("#deactive-time-div-0+div>a")).click();	
			}
		}
		catch(Exception e)
		{
			driver.findElement(By.cssSelector("div.time-div-0>div>input:last-of-type")).sendKeys("11:00 PM");
		}
		driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>a")).click();

		for(int i=3;i<=8;i++)
		{
			driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>div>label:nth-child("+i+")>span")).click();
		}
		driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>div>div>button")).click();
		jse.executeScript("scroll(0,290)");
		Thread.sleep(2000);
		*/
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[5]/div[1]/div[2]/button")).click();// next button
		String event = driver.findElement(By.cssSelector("div.toast")).getText();
		System.out.println("Creating New Appointment Type:");
		System.out.println("	"+event);
		jse.executeScript("scroll(0,0)");
		String evstat = driver.findElement(By.cssSelector("label[for=\"toggleB\"]>div")).getText();
		System.out.println("	Event status : "+evstat);
		Thread.sleep(2000);
		String pwindo = driver.getWindowHandle();

		//validating landing page
		action.sendKeys(Keys.PAGE_UP).perform();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[data-url]")).click();//preview button
		Set<String> handles = driver.getWindowHandles();
		for (String handle: handles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		try
		{
			driver.findElement(By.cssSelector("a[href=\"#\"]:first-of-type")).click();
		}
		catch (Exception e)
		{
			System.out.println(driver.findElement(By.id("block0body")).getText());
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.time-button:first-of-type")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/button[2]")).click();

		driver.findElement(By.name("contactname")).sendKeys("Test grpname 110022");
		driver.findElement(By.name("contactemail")).sendKeys("nadsoft.test99@gmail.com");
		driver.findElement(By.name("contactphone")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("button.sch-event-btn")).click();
		Thread.sleep(2000);
		System.out.println("	"+driver.findElement(By.cssSelector("h2[style= \"font-size: 1.25rem;\"]")).getText());
		System.out.println("	"+driver.findElement(By.cssSelector("div.details>div:nth-child(2)>div>span.evt-time-selected")).getText());
		System.out.println("	"+driver.findElement(By.cssSelector("div.details>div:nth-child(2)>div>span.evt-date-selected")).getText());

		driver.navigate().refresh();

		//Booking second Appointment
		driver.findElement(By.cssSelector("a[href=\"#\"]:first-of-type")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.time-button:first-of-type")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/button[2]")).click();

		driver.findElement(By.name("contactname")).sendKeys("Test2 grpname2 110022");
		driver.findElement(By.name("contactemail")).sendKeys("nadsoft.test02@gmail.com");
		driver.findElement(By.name("contactphone")).sendKeys("1234567812");
		driver.findElement(By.cssSelector("button.sch-event-btn")).click();
		Thread.sleep(2000);
		System.out.println("	"+driver.findElement(By.cssSelector("h2[style= \"font-size: 1.25rem;\"]")).getText());
		System.out.println("	"+driver.findElement(By.cssSelector("div.details>div:nth-child(2)>div>span.evt-time-selected")).getText());
		System.out.println("	"+driver.findElement(By.cssSelector("div.details>div:nth-child(2)>div>span.evt-date-selected")).getText());
		/*/Slot validation
		driver.navigate().refresh();
		driver.findElement(By.cssSelector("a[href=\"#\"]:first-of-type")).click();
		Thread.sleep(2000);
		String afterbookingSlots = driver.findElement(By.cssSelector("button.time-button:first-of-type>div:nth-child(2)")).getText();
		System.out.println();
		System.out.println("	Spots available Before Booking Appointment: "+beforbookingSlots);
		System.out.println("	Spots available After Booking Appointment: "+afterbookingSlots);
		Assert.assertEquals(afterbookingSlots, "2 spots left", "Slots count Mismatched");
		Thread.sleep(1000);*/

		driver.close();
		driver.switchTo().window(pwindo);

		// Validating appointment on calendar----->
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().to("https://app.deposyt.com/index.php?m=appointments&d=tableview");

		driver.findElement(By.cssSelector("a.customer-filter-btn")).click();
		Thread.sleep(2000);
		String aftergrpapcnt= driver.findElement(By.cssSelector("span.message-count-for-change>span")).getText();
		System.out.println("	Appointment Count Before Sceduling Appointment: "+grpapcnt);
		System.out.println("	Appointment Count After Sceduling Appointment: "+aftergrpapcnt);
		int a = Integer.parseInt(grpapcnt);
		int b = Integer.parseInt(aftergrpapcnt);
		a = a + 1;
		Assert.assertEquals(a, b, "Count Mismatched After Booking new appointment");
		driver.findElement(By.cssSelector("a.customer-filter-btn")).click();

		driver.findElement(By.name("search")).sendKeys("Test Appointment- Group 110022");
		action.sendKeys(Keys.ENTER).perform();
		String timeDetails = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>div:first-of-type")).getText();
		String datedetails = driver.findElement(By.cssSelector("h4.text-xl.font-extrabold.darkColor.mr-auto")).getText();
		String Apptname = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>h5")).getText();
	
		System.out.println();
		System.out.println("	Actual Details showing on the Appointment page");
		System.out.println("	Appointment Name: "+Apptname);
		System.out.println("	Appointment Date: "+datedetails);
		System.out.println("	Appotment Time: "+timeDetails);

		driver.findElement(By.cssSelector("div.new-appointment-box>div:nth-child(3)>div>h5")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#new-open-comman-appointmentdetails-modal>div>div>div:nth-child(2)>div:nth-child(2)>a:nth-child(3)")).click();
		driver.findElement(By.xpath("//*[@id=\"formdeleteactionmodaldiv\"]/div/button")).click();
		System.out.println("	"+driver.findElement(By.cssSelector("#toast-container>div>div")).getText());
	}
	
	@Test
	public void CollectiveAppointment() throws Exception 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		
		Login2();	
		//New Collective Appointment Type
		driver.navigate().to("https://app.deposyt.com/index.php?m=appointments&d=tableview");
		System.out.println();
		System.out.println("New Collective Appointment type ----->");	

		driver.findElement(By.cssSelector("a.customer-filter-btn")).click();
		Thread.sleep(2000);
		String colaptcnt= driver.findElement(By.cssSelector("span.message-count-for-change>span")).getText();
		 		
		driver.navigate().to("https://app.deposyt.com/index.php?m=appointments&d=eventtypes");

		//Checking for duplicate
		driver.findElement(By.name("search")).sendKeys("Test Appointment- Collective 110022");
		action.sendKeys(Keys.ENTER).perform();
		try 
		{
			driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>a")).click();//appointment menu
			driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>div>a:nth-of-type(4)")).click(); // delete option
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("form#formdeleteactionmodaldiv>div>button")).click();
		}
		catch(Exception q) 
		{

		}

		//Creating New Appointment
		driver.findElement(By.id("eventtypebutton")).click();
		action.sendKeys(Keys.PAGE_DOWN).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div/div[1]/div[1]/div/div[4]/a")).click();

		driver.findElement(By.cssSelector("#host-popup>div>div>div>div>div:first-child>input")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#host-popup>div>div>div>div>div:first-child>div>div:nth-child(2)")).click();
		driver.findElement(By.id("linkdoneapplyss")).click();

		driver.findElement(By.id("appttypename_title")).sendKeys("Test Appointment- Collective 110022");
		driver.findElement(By.id("appttypedesc")).sendKeys("Test user");
		jse.executeScript("scroll(0,0)");
		driver.findElement(By.cssSelector("div.appt-head-section>div:nth-of-type(3)>button[type=\"button\"]")).click();
		Thread.sleep(2000);
		jse.executeScript("scroll(0,200)");
		
		driver.findElement(By.cssSelector("div.mb-5.loc>div.appt-location")).click();
		driver.findElement(By.cssSelector("div.appt-location.open>ul>li[data-value=\"inperson\"]")).click();
		driver.findElement(By.id("inperson_address")).sendKeys("Test Address");
		jse.executeScript("scroll(0,0)");
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[4]/div[1]/div[2]/button")).click();// next button

		jse.executeScript("scroll(0,800)");
		driver.findElement(By.cssSelector("div.appt-availability-section>div>div:nth-child(5)>div>div:nth-child(5)")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.appt-availability-section>div>div:nth-child(5)>div>div:nth-child(5)>ul>li:nth-child(2)")).click();
		Thread.sleep(1000);
		
		//setting Custom availibility
		driver.findElement(By.cssSelector("span[id^=select2-state]")).click();
		driver.findElement(By.cssSelector("input.select2-search__field")).sendKeys("Asia/Kolkata");
		action.sendKeys(Keys.ENTER).perform();

		try
		{
			jse.executeScript("document.getElementsByName('to_time[0][]')[0].setAttribute('value','11:45 PM')");
		}
		catch (Exception JavaScriptException)
		{
			driver.findElement(By.cssSelector("a[data-dayid = \"0\"]")).click();
			jse.executeScript("document.getElementsByName('to_time[0][]')[0].setAttribute('value','11:45 PM')");
		}
		
		driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>a")).click();

		for(int i=3;i<=8;i++)
		{
			driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>div>label:nth-child("+i+")>span")).click();
		}
		driver.findElement(By.cssSelector("#deactive-time-div-0+div>div>div>div>button")).click();
		jse.executeScript("scroll(0,290)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/div/div[5]/div[1]/div[2]/button")).click();// next button
		String event = driver.findElement(By.cssSelector("div.toast")).getText();
		System.out.println("Creating New Appointment Type:");
		System.out.println("	"+event);
		jse.executeScript("scroll(0,0)");
		String evstat = driver.findElement(By.cssSelector("label[for=\"toggleB\"]>div")).getText();
		System.out.println("	Event status : "+evstat);
		Thread.sleep(2000);
		String pwindo = driver.getWindowHandle();

		//validating landing page
		action.sendKeys(Keys.PAGE_UP).perform();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[data-url]")).click();//preview button
		Set<String> handles = driver.getWindowHandles();
		for (String handle: handles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		try
		{
			driver.findElement(By.cssSelector("a[href=\"#\"]:first-of-type")).click();
		}
		catch (Exception e)
		{
			System.out.println(driver.findElement(By.id("block0body")).getText());
		}
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.time-button:first-of-type")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"block0body\"]/div/div/div[2]/div[1]/div/div[2]/div/div/div[1]/button[2]")).click();

		driver.findElement(By.name("contactname")).sendKeys("Test grpname 110022");
		driver.findElement(By.name("contactemail")).sendKeys("nadsoft.test99@gmail.com");
		driver.findElement(By.name("contactphone")).sendKeys("1234567890");
		driver.findElement(By.cssSelector("button.sch-event-btn")).click();
		Thread.sleep(2000);
		System.out.println("	"+driver.findElement(By.cssSelector("h2[style= \"font-size: 1.25rem;\"]")).getText());
		System.out.println("	"+driver.findElement(By.cssSelector("div.details>div:nth-child(2)>div>span.evt-time-selected")).getText());
		System.out.println("	"+driver.findElement(By.cssSelector("div.details>div:nth-child(2)>div>span.evt-date-selected")).getText());

		driver.close();
		driver.switchTo().window(pwindo);
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().to(Calendar);

		driver.findElement(By.cssSelector("a.customer-filter-btn")).click();
		Thread.sleep(2000);
		String aftergrpapcnt= driver.findElement(By.cssSelector("span.message-count-for-change>span")).getText();
		System.out.println("	Appointment Count Before Sceduling Appointment: "+colaptcnt);
		System.out.println("	Appointment Count After Sceduling Appointment: "+aftergrpapcnt);
		int a = Integer.parseInt(colaptcnt);
		int b = Integer.parseInt(aftergrpapcnt);
		a = a + 1;
		Assert.assertEquals(a, b, "Count Mismatched After Booking new appointment");
		driver.findElement(By.cssSelector("a.customer-filter-btn")).click();

		driver.findElement(By.name("search")).sendKeys("Test Appointment- Collective 110022");
		action.sendKeys(Keys.ENTER).perform();
		String timeDetails = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>div:first-of-type")).getText();
		String datedetails = driver.findElement(By.cssSelector("h4.text-xl.font-extrabold.darkColor.mr-auto")).getText();
		String Apptname = driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>h5")).getText();

		System.out.println();
		System.out.println("	Actual Details showing on the Appointment page");
		System.out.println("	Appointment Name: "+Apptname);
		System.out.println("	Appointment Date: "+datedetails);
		System.out.println("	Appotment Time: "+timeDetails);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.new-single-appointment.grid.rounded-lg>h5")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#new-open-comman-appointmentdetails-modal>div>div>div:nth-child(2)>div:nth-child(2)>a:nth-child(3)")).click();
		driver.findElement(By.xpath("//*[@id=\"formdeleteactionmodaldiv\"]/div/button")).click();
		Thread.sleep(500);
		System.out.println("	Appointment Deleted Successfully");


	}
	

	@Test
	public void Apptypeoparations() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);

		System.out.println();

		action.moveToElement(driver.findElement(By.cssSelector("div.hidden.sidebar-bg-color"))).perform();
		jse.executeScript("document.querySelector('html > body > div > div:nth-of-type(2)').scrollTop=400");
		driver.findElement(By.linkText("Appointment Types")).click();

		String aptname = driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>a")).getText();
		driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>a")).click();//appointment menu
		driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>div>a:nth-of-type(3)")).click(); // duplicate option

		Thread.sleep(2000);
		jse.executeScript("document.querySelector('#cloneeventtypepopup').scrollTop=200");
		driver.findElement(By.cssSelector("#cloneeventtypepopupcontent>div>div>div:nth-child(4)>button")).click();
		System.out.println(driver.findElement(By.id("toast-container")).getText());
		driver.findElement(By.name("search")).sendKeys("Copy Of "+aptname);
		action.sendKeys(Keys.ENTER).perform();

		driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>a")).click();//appointment menu
		driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>div>a:nth-of-type(4)")).click(); // delete option
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("form#formdeleteactionmodaldiv>div>button")).click();

		driver.findElement(By.name("search")).sendKeys("Copy Of "+aptname);
		action.sendKeys(Keys.ENTER).perform();
		try {
			driver.findElement(By.cssSelector("div.eventcontentdiv>div:first-of-type>div>div>a")).click();//appointment menu
			System.out.println("Appointment Not Deleted");
		}catch(Exception e) {
			System.out.println("Appointment Deleted Successfully!");
		}

	}

	@Test
	public void AppointmentCount() throws Exception {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Login2();
		System.out.println();
		System.out.println("Validating Appointment Count on Dashboard ----->");
		String Total = driver.findElement(By.cssSelector("div.top-header>div:nth-child(2)>div>div:nth-child(2)>h1>span")).getText();
		String a = driver.findElement(By.cssSelector("div.top-header>div:nth-child(2)>div>div:nth-child(3)>a:first-child")).getText();
		String arr[] = a.split(" ",3);
		String Today1 = arr[2];

		String b = driver.findElement(By.cssSelector("div.mini-messages.dash-appointments>div>div:last-child>div>h1")).getText();
		String arr1[] = b.split(" ",4);
		String Today2 = arr1[2];
		Assert.assertEquals(Today1, Today2, "Count Mismatched on Dashboard");

		driver.navigate().to("https://app.deposyt.com/index.php?m=appointments&d=tableview");
		driver.findElement(By.cssSelector("a.customer-filter-btn.calendar-filter-btn")).click();
		Thread.sleep(3000);
		String Totalincalendar = driver.findElement(By.cssSelector("span.message-count-for-change>span")).getText();
		System.out.println("	Total Appointment Call On Dashboard : "+Total);
		System.out.println("	Total Count on Calendar : "+Totalincalendar);

		driver.findElement(By.id("ctSchedulesStartfilter")).click();
		driver.findElement(By.cssSelector("button.applyBtn ")).click();
		Thread.sleep(3000);
		String Todayincalendar = driver.findElement(By.cssSelector("span.message-count-for-change>span")).getText();
		System.out.println();
		System.out.println("	Today's Appointment Count on Dashboard : "+Today1);
		System.out.println("	Today's Count on Calendar : "+Todayincalendar);

		Assert.assertEquals(Total, Totalincalendar, "Total Appointment Count Mismatch In Dashboard and Calendar");
		Assert.assertEquals(Today1, Todayincalendar, "Today's Appointment Count Mismatch In Dashboard and Calendar");
	}

	//@Test
	public void deleve() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		Actions action = new Actions(driver);

		System.out.println();	

		WebElement e = driver.findElement(By.cssSelector("div.hidden.sidebar-bg-color"));
		action.moveToElement(e).perform();
		jse.executeScript("document.querySelector('html > body > div > div:nth-of-type(2)').scrollTop=400");
		driver.findElement(By.linkText("Appointment Types")).click();

		String s = driver.findElement(By.cssSelector("div.eventcontentdiv:first-of-type>div>div.flex.justify-between.items-center")).getText();
		if(s.equals("Test Appointment 110022"))
		{
			driver.findElement(By.cssSelector("a#dropdown-steps > i:first-of-type")).click();
			driver.findElement(By.xpath("//*[@id=\"block0body\"]/div[2]/div[2]/div/div[1]/div/div/div/div[2]/div/div/div/div/div[1]/div[1]/div/div/a[3]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"formdeleteactionmodaldiv\"]/div/button")).click();
		}

	}
	
	public void Login2() throws InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));

		// Login to diff test account
				driver.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).click();
				driver.findElement(By.linkText("Logout")).click();

				Thread.sleep(8000);
				WebElement emf = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
				emf.sendKeys(User2login);
				driver.findElement(By.id("password")).sendKeys(User2pass);
				driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div[4]/button[1]")).click();
				Thread.sleep(5000);
	}
}
