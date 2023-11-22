

/*
		@Test
		public void Settings() throws Exception {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Actions action = new Actions(driver);
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			
			driver.navigate().to(UMpage);
			String Access = driver.findElement(By.cssSelector("table>tbody>tr:first-of-type")).getAttribute("data-access-level");
			List <WebElement> test = driver.findElements(By.cssSelector("ul.list>li.selectinviterole"));

			driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=access_level_list");
			String a = null;
			for(int i=2; i<= test.size()+1;i++)
			{
				a = driver.findElement(By.cssSelector("div#accesslevel_section>div:nth-of-type("+i+")>div>div>div>h1:first-of-type")).getText();
				if(Access.equalsIgnoreCase (a))
				{
					driver.findElement(By.cssSelector("div#accesslevel_section>div:nth-of-type("+i+")>div>div+div>a:first-of-type")).click();
					break;
				}
			}
			String url = driver.getCurrentUrl();
   //Settings Access level ----->
		//None access
		action.sendKeys(Keys.PAGE_DOWN).perform();
		for(int i=2; i<=6;i++) {
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div.module-wrapper:first-of-type>div:nth-of-type("+i+")>div.flex.access-level-buttons>button:first-of-type")).click();
		}
		driver.findElement(By.cssSelector("button[data-type=access_level]")).click();//save button in access level
		driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=list");//user profile page
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>a")).click();
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>div>a:first-of-type")).click();//login to user account
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		//validations
		driver.navigate().to("https://app.deposyt.com/index.php?m=settings&d=businessprofile");//Bussiness profile page
		//assertTrue(driver.getPageSource().contains("Access Denied!"));
		driver.navigate().to("https://app.deposyt.com/index.php?m=employeedetails&d=security");//Security
		//assertTrue(driver.getPageSource().contains("Access Denied!"));
		driver.navigate().to("https://app.deposyt.com/index.php?m=settings&d=calendar&from=settings");//Calendar setting
		//assertTrue(driver.getPageSource().contains("Access Denied!"));
		driver.navigate().to("https://app.deposyt.com/index.php?m=employeedetails&d=myprofile");//my profile
		//assertTrue(driver.getPageSource().contains("Access Denied!"));
		driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=access_level_list");//access Level
		//assertTrue(driver.getPageSource().contains("Access Denied!"));
		driver.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).click();
		driver.findElement(By.linkText("Re-Login Back")).click();
		driver.navigate().to(url);
		
		//Settings - view access
		action.sendKeys(Keys.PAGE_DOWN).perform();
		for(int i=2; i<=6;i++) {
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div.module-wrapper:first-of-type>div:nth-of-type("+i+")>div.flex.access-level-buttons>button:nth-of-type(2)")).click();
		}
		driver.findElement(By.cssSelector("button[data-type=access_level]")).click();//save button in access level
		driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=list");//user profile page
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>a")).click();
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>div>a:first-of-type")).click();//login to user account
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		//validations
		driver.navigate().to("https://app.deposyt.com/index.php?m=settings&d=businessprofile");//Bussiness profile page
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		try {
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
			System.out.println("User is able to Edit Business profile page");
		}catch(Exception e) {	}
		
		driver.navigate().to("https://app.deposyt.com/index.php?m=employeedetails&d=security");//Security
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		try {
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
			System.out.println("User is able to Edit Security page");
		}catch(Exception e) {}
		
		driver.navigate().to("https://app.deposyt.com/index.php?m=settings&d=calendar&from=settings");//Calendar setting
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		try {
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
			System.out.println("User is able to Edit Settings page");
		}catch(Exception e) {}
		
		driver.navigate().to("https://app.deposyt.com/index.php?m=employeedetails&d=myprofile");//my profile
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		try 
		{
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
			System.out.println("User is able to Edit My profile page");
		}
		catch(Exception e) 
		{
			
		}
		
		driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=access_level_list");//access Level
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		try 
		{
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
			System.out.println("User is able to Edit Access Level page");
		}
		catch(Exception e) 
		{
			
		}
		driver.navigate().to(url);

		//Settings - Modify access
		action.sendKeys(Keys.PAGE_DOWN).perform();
		
		for(int i=2; i<=6;i++) 
		{
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("div.module-wrapper:first-of-type>div:nth-of-type("+i+")>div.flex.access-level-buttons>button:nth-of-type(2)")).click();
		}
		
		driver.findElement(By.cssSelector("button[data-type=access_level]")).click();//save button in access level
		driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=list");//user profile page
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>a")).click();
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>div>a:first-of-type")).click();//login to user account
		driver.switchTo().alert().accept();
		Thread.sleep(2000);

		//validations
		driver.navigate().to("https://app.deposyt.com/index.php?m=settings&d=businessprofile");//Bussiness profile page
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		try 
		{
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
		}
		catch(Exception e) 
		{
			System.out.println("User is able to Edit Business profile page");
		}
 
		driver.navigate().to("https://app.deposyt.com/index.php?m=employeedetails&d=security");//Security
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		try 
		{
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
		}
		catch(Exception e) 
		{
			System.out.println("User is unable to Edit Security page");
		}

		driver.navigate().to("https://app.deposyt.com/index.php?m=settings&d=calendar&from=settings");//Calendar setting
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		try 
		{
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
		}
		catch(Exception e) 
		{
			System.out.println("User is Unable to Edit Settings page");
		}

		driver.navigate().to("https://app.deposyt.com/index.php?m=employeedetails&d=myprofile");//my profile
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		try 
		{
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
		}
		catch(Exception e) 
		{
			System.out.println("User is Unable to Edit My profile page");
		}

		driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=access_level_list");//access Level
		Assert.assertFalse(driver.getPageSource().contains("Access Denied!"));
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		try 
		{
			driver.findElement(By.cssSelector("button[type=\"submit\"]"));
		}
		catch(Exception e) 
		{
			System.out.println("User is Unable to Edit Access Level page");
		}
		
		driver.navigate().to(url);
		}
		
		@Test
		public void Customer() throws Exception 
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Actions action = new Actions(driver);
			
			driver.navigate().to(UMpage);
			String Access = driver.findElement(By.cssSelector("table>tbody>tr:first-of-type")).getAttribute("data-access-level");
			//String Uid = driver.findElement(By.cssSelector("table>tbody>tr:first-of-type")).getAttribute("data-id");
			List <WebElement> test = driver.findElements(By.cssSelector("ul.list>li.selectinviterole"));

			driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=access_level_list");
			String a = null;
			for(int i=2; i<= test.size()+1;i++)
			{
				a = driver.findElement(By.cssSelector("div#accesslevel_section>div:nth-of-type("+i+")>div>div>div>h1:first-of-type")).getText();
				if(Access.equalsIgnoreCase (a))
				{
					driver.findElement(By.cssSelector("div#accesslevel_section>div:nth-of-type("+i+")>div>div+div>a:first-of-type")).click();
					break;
				}
			}
			String url = driver.getCurrentUrl();
			
		//Customer Access - None access ------>
		action.scrollByAmount(0, 1758).perform();
		Thread.sleep(1000);
		for(int i=2;i<=10;i++)
		{
			Thread.sleep(1000);
			if(i==4) 
			{
				action.scrollByAmount(0, 2158).perform();
			}
			else 
			{
			driver.findElement(By.cssSelector("div.module-wrapper:nth-of-type(4)>div:nth-of-type("+i+")>div.flex.access-level-buttons>button:nth-of-type(1)")).click();
			}
		}
		driver.findElement(By.cssSelector("button[data-type=access_level]")).click();//save button in access level
		driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=list");//user profile page
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>a")).click();
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>div>a:first-of-type")).click();//login to user account
		driver.switchTo().alert().accept();
		
		//Validations-none access
		Thread.sleep(3000);
		driver.navigate().to("https://app.deposyt.com/index.php?m=customers");
		Assert.assertEquals(driver.findElement(By.id("at0-cell-chk1-0")).getText(),"Nothing found","User get access for Contacts");
		
		try 
		{
			driver.findElement(By.linkText("Export")).isDisplayed();
			Assert.assertEquals(true, false,"Export button Get Displyed");
		}
		catch(Exception e) 
		{
			
		}
		
		try 
		{
			driver.findElement(By.xpath("//*[@id=\"block0body\"]/div/div[1]/div/div[1]/a[1]")).click();
			Assert.assertEquals(true, false,"Add customer button Get Displyed");
		}
		catch(Exception e) 
		{
		
		}
		
		driver.navigate().to(Message);
		
		try 
		{
			driver.findElement(By.cssSelector("a[data-original-title=\"Call\"]")).isDisplayed();
			Assert.assertEquals(true, false,"call button Get Displyed");
		}
		catch(Exception e) 
		{
		}
		
		try 
		{
			driver.findElement(By.cssSelector("div.custom-sms-contact-list>div")).isDisplayed();
			driver.findElement(By.id("msgbox_messages")).isDisplayed();
			Assert.assertEquals(true, false,"contacts/send SMS button Get Displyed");
		}
		catch(Exception e) 
		{
		}
		
		driver.findElement(By.xpath("//*[@id=\"dropdownMenu1\"]")).click();
		driver.findElement(By.cssSelector("#dropdownMenu1+div>a:nth-of-type(3)")).click();
		
		driver.navigate().to(url);
		
		//contact - view access
		action.scrollByAmount(0, 1758).perform();
		Thread.sleep(1000);
		for(int i=2;i<=10;i++)
		{
			Thread.sleep(1000);
			if(i==4) 
			{
				action.scrollByAmount(0,2158).perform();
			}
			else 
			{
			driver.findElement(By.cssSelector("div.module-wrapper:nth-of-type(4)>div:nth-of-type("+i+")>div.flex.access-level-buttons>button:nth-of-type(2)")).click();
			}
		}
		driver.findElement(By.cssSelector("button[data-type=access_level]")).click();//save button in access level
		driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=list");//user profile page
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>a")).click();
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>div>a:first-of-type")).click();//login to user account
		driver.switchTo().alert().accept();
		
		//Validations-view access(On access for others)
		Thread.sleep(3000);
		driver.navigate().to("https://app.deposyt.com/index.php?m=customers");
		//Assert.assertEquals("User get access for Contacts",driver.findElement(By.id("at0-cell-chk1-0")).getText(),"Nothing found");
		try
		{
			driver.findElement(By.linkText("Export")).isDisplayed();
		}
		catch(Exception e) 
		{
			Assert.assertEquals(true, false,"Export button not Get Displyed");
		}
		try
		{
			driver.findElement(By.xpath("//*[@id=\"block0body\"]/div/div[1]/div/div[1]/a[1]")).isDisplayed();
		}
		catch(Exception e) 
		{
			Assert.assertEquals(true, false,"Add customer button not Get Displyed");
		}
		driver.navigate().to(MsgModule);
		
		try
		{
			driver.findElement(By.cssSelector("a[data-original-title=\"Call\"]")).click();
			driver.findElement(By.id("globalcall_dialer")).isDisplayed();
			driver.findElement(By.cssSelector("a[data-original-title=\"Call\"]")).click();
		}
		catch(Exception e) 
		{
			Assert.assertEquals(true, false,"call button not Get Displyed");
		}
		try 
		{
			driver.findElement(By.cssSelector("div.custom-sms-contact-list>div")).isDisplayed();
			driver.findElement(By.id("msgbox_messages")).isDisplayed();
		}
		catch(Exception e) 
		{
			Assert.assertEquals(true, false,"contacts/send SMS button not Get Displyed");
		}
		driver.navigate().to(url);
		
		//To be continue for view validations and modify access
		}
		
		@Test
		public void Pipeline() throws Exception 
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Actions action = new Actions(driver);
			
			driver.navigate().to(UMpage);
			String Access = driver.findElement(By.cssSelector("table>tbody>tr:first-of-type")).getAttribute("data-access-level");
			List <WebElement> test = driver.findElements(By.cssSelector("ul.list>li.selectinviterole"));

			driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=access_level_list");
			String a = null;
			
			//Selecting Access level
			for(int i=2; i<= test.size()+1;i++)
			{
				a = driver.findElement(By.cssSelector("div#accesslevel_section>div:nth-of-type("+i+")>div>div>div>h1:first-of-type")).getText();
				if(Access.equalsIgnoreCase (a))
				{
					driver.findElement(By.cssSelector("div#accesslevel_section>div:nth-of-type("+i+")>div>div+div>a:first-of-type")).click();
					break;
				}
			}
		String url = driver.getCurrentUrl();
		
		action.scrollByAmount(0, 2690).perform();
		//Access Level -Pipeline Module(No Access)
		Thread.sleep(1000);
		for(int i=2;i<=12;i++)
		{
			Thread.sleep(1000);
			if(i==8) {
				action.sendKeys(Keys.PAGE_DOWN).perform();
			}
			else {
				driver.findElement(By.cssSelector("div.access-level-info>div:nth-child(9)>div:nth-child("+i+")>div:nth-child(2)>button:first-child")).click();
			}
			i++;
		}
		driver.findElement(By.cssSelector("button[data-type=access_level]")).click();//save button in access level
		driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=list");//user profile page
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>a")).click();
		driver.findElement(By.cssSelector("table>tbody>tr:first-of-type>td:nth-child(8)>div>div>a:first-of-type")).click();//login to user account
		driver.switchTo().alert().accept();
		
		//Sidebar
		WebElement sidebar = driver.findElement(By.cssSelector("div.hidden.sidebar-bg-color"));
		action.moveToElement(sidebar).perform();
		try 
		{
			driver.findElement(By.cssSelector("a[title=\"Pipelines\"]")).click();
		}
		catch(Exception NoSuchElement)
		{
			System.out.println("Test passed - Pipline Option not get displyed in sidebar for none access");
		}
		
		//Dashboard verification - No Access
		try
		{
			driver.findElement(By.cssSelector("div.top-header>div:first-of-type>div>div+a"));
			driver.findElement(By.cssSelector("#dashboard_leads>div>div.a")).click();
			Assert.assertFalse(true,"Dashboard pipeline popup opened");
		}
		catch(Exception e)
		{
			System.out.println("Test passed for Dashboard Pipeline popup");
		}
		
		//Message
		driver.navigate().to(MsgModule);
		
		
		
		//driver.close();
	}
		
		@Test
		public void Message() throws Exception {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Actions action = new Actions(driver);
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			
			driver.navigate().to(UMpage);
			String Access = driver.findElement(By.cssSelector("table>tbody>tr:first-of-type")).getAttribute("data-access-level");
			//String Uid = driver.findElement(By.cssSelector("table>tbody>tr:first-of-type")).getAttribute("data-id");
			List <WebElement> test = driver.findElements(By.cssSelector("ul.list>li.selectinviterole"));

			driver.navigate().to("https://app.deposyt.com/index.php?m=usersmgmt&d=access_level_list");
			String a = null;
			for(int i=2; i<= test.size()+1;i++)
			{
				a = driver.findElement(By.cssSelector("div#accesslevel_section>div:nth-of-type("+i+")>div>div>div>h1:first-of-type")).getText();
				if(Access.equalsIgnoreCase (a))
				{
					driver.findElement(By.cssSelector("div#accesslevel_section>div:nth-of-type("+i+")>div>div+div>a:first-of-type")).click();
					break;
				}
			}
			String url = driver.getCurrentUrl();
		}
}
*/