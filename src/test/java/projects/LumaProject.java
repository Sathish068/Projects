package projects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class LumaProject {
	
WebDriver driver = new FirefoxDriver();
	
	@SuppressWarnings("deprecation")
	@Test(priority =1)
	public void openBrowser() throws InterruptedException
	{
		System.setProperty("Webdriver.gecko.Driver","C:\\Users\\Mokshi\\eclipse-workspace\\Selenium\\Driver\\geckodriver.exe");
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a")).click();
				
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority =2)
	public void Login() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		driver.findElement(By.name("login[username]")).sendKeys("Sathish068@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Sathish2022@P");
		driver.findElement(By.id("send2")).click();
		
	}
		
	@SuppressWarnings("deprecation")
	@Test(priority =3)
	public void searchProducts() throws AWTException, InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.id("search")).sendKeys("Helios");
		Thread.sleep(2000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@Test(priority =4)
	public void addcart() throws AWTException, InterruptedException

	{
		WebElement move = driver.findElement(By.className("product-image-photo"));
		move.click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("option-label-size-143-item-167")).click();
		driver.findElement(By.id("option-label-color-93-item-57")).click();
		
		driver.findElement(By.id("product-addtocart-button")).click();
		
		Thread.sleep(2000);
		WebElement Scroll = driver.findElement(By.className("logo"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(false)", Scroll);
		
		
		driver.findElement(By.xpath("//div[@data-block='minicart']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		
				
	}
	
	
	@Test(priority=5)
	public void confirmorder() throws InterruptedException, AWTException
	{	
		
		Thread.sleep(10000);
		WebElement scrol = driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
		scrol.click();
		Thread.sleep(7000);
		driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();	
		
	}
	
	@Test(priority=6)
	public void screenshot() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		TakesScreenshot tk= (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Mokshi\\eclipse-workspace\\Selenium\\Screenshot\\alert.png");
		FileHandler.copy(src, des);
		driver.close();
	}	
	
	
	

}
