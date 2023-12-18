package projects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Booking {
	
	
	@Test
	public void bookingcom() throws InterruptedException, AWTException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.booking.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("ss")).sendKeys("New York");
		driver.findElement(By.className("f73e6603bf")).click();
		driver.findElement(By.xpath("//span[@aria-label='25 November 2023']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@aria-label='30 November 2023']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
		
		
		
		driver.findElement(By.xpath("(//div[@class='a7a72174b8'])[1]//div[2]//button[1]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"indexsearch\"]/div[2]/div/form/div[1]/div[3]/div/div/div/button"));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		
		WebElement Hotels = driver.findElement(By.xpath("//div [contains(text(),'5 stars')]"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",Hotels);
		Hotels.click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Less than 1 km')]")).click();
		
		Thread.sleep(6000);
		
		WebElement Hotelname = driver.findElement(By.xpath("//div[contains(text(),'Hard Rock Hotel New York')]"));
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView(true)",Hotelname);
		Hotelname.click();
		
		Thread.sleep(10000);
		
		
		
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{

		String child_window=I1.next();


		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}

		}
	
		driver.findElement(By.xpath("//span[contains(text(),'Info & prices')]")).click();
		
		WebElement availability = driver.findElement(By.xpath("//span[contains(text(),'Info & prices')]"));
		JavascriptExecutor js2 =(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].scrollIntoView(true)",availability);
		
		Thread.sleep(2000);
		
		WebElement roomsel = driver.findElement(By.id("availability_target"));
		JavascriptExecutor js3 =(JavascriptExecutor)driver;
		js3.executeScript("arguments[0].scrollIntoView(true)",roomsel);
		
		
		Thread.sleep(3000);
		
		WebElement roomcount = driver.findElement(By.id("hprt_nos_select_757761801_373084877_2_41_0"));
		
		Thread.sleep(2000);
		
		Select s1= new Select(roomcount);
		s1.selectByValue("1");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
	
		Thread.sleep(2000);
		
		driver.findElement(By.id("firstname")).sendKeys("Sathishkumar");
		driver.findElement(By.id("lastname")).sendKeys("R");
		driver.findElement(By.id("email")).sendKeys("Sathish606085@gmail.com");
		
		
		driver.findElement(By.id("address1")).sendKeys("123,Chennai");
		driver.findElement(By.id("city")).sendKeys("Chennai");
		driver.findElement(By.id("zip")).sendKeys("600001");
		
		driver.findElement(By.id("phone")).sendKeys("8925377089");
		
		Thread.sleep(2000);	
		
		WebElement arrivaltime = driver.findElement(By.id("checkin_eta_hour"));
		JavascriptExecutor js4=(JavascriptExecutor)driver;
		js4.executeScript("arguments[0].scrollIntoView[true]",arrivaltime);
		Select s2=new Select(arrivaltime);
		s2.selectByValue("-1");
		Thread.sleep(2000);		
		
		WebElement find = driver.findElement(By.xpath("//span[contains(text(),'We Price Match')]"));
		JavascriptExecutor js5=(JavascriptExecutor)driver;
		js5.executeScript("arguments[0].scrollIntoView[true]", find);
		
		
		Thread.sleep(2000);			
		
		driver.findElement(By.xpath("//span[contains(text(),' Next: Final details ')]")).click();
		
		
		
		Thread.sleep(10000);
	
		if(driver.findElement(By.className("bui-button__text"))!=null)
		{
			driver.findElement(By.className("bui-button__text"));
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(2000);
			
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
				
		Thread.sleep(2000);
		
		
		WebElement cc_type = driver.findElement(By.id("cc_type"));
		Select s3=new Select(cc_type);
		s3.selectByValue("MasterCard");
		
		Thread.sleep(2000);
		WebElement cc_number = driver.findElement(By.id("cc_number"));
		cc_number.sendKeys("5455");
		Thread.sleep(1000);
		cc_number.sendKeys("3307");
		Thread.sleep(1000);
		cc_number.sendKeys("6000");
		Thread.sleep(1000);
		cc_number.sendKeys("0018");
		
		Thread.sleep(2000);
		WebElement cc_month = driver.findElement(By.id("cc_month"));
		Select s4=new Select(cc_month);
		s4.selectByIndex(3);			
		Thread.sleep(2000);
		WebElement cc_Year = driver.findElement(By.id("ccYear"));
		Select s5=new Select(cc_Year);
		s5.selectByIndex(6);
		Thread.sleep(2000);
		driver.findElement(By.id("cc_cvc")).sendKeys("786");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),' Complete booking ')]")).click();
		Thread.sleep(5000);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}

}
