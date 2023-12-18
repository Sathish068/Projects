package projects;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Addactin {
	
	
@Test	
public void hotelapp() throws InterruptedException, IOException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://adactinhotelapp.com/index.php");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Sathish068");
		driver.findElement(By.name("password")).sendKeys("Sathish2022@P");
		driver.findElement(By.name("login")).click();
		Thread.sleep(15000);
		WebElement Location = driver.findElement(By.name("location"));
		Select s= new Select(Location);
		s.selectByValue("Melbourne");
		WebElement Hotel = driver.findElement(By.name("hotels"));
		Select s1= new Select(Hotel);
		s1.selectByIndex(1);
		WebElement Roomtype = driver.findElement(By.id("room_type"));
		Select s2= new Select(Roomtype);
		s2.selectByVisibleText("Deluxe");
		WebElement RoomCount = driver.findElement(By.name("room_nos"));
		Select s3= new Select(RoomCount);
		s3.selectByValue("3");
		WebElement datepick_in = driver.findElement(By.name("datepick_in"));
		datepick_in.clear();
		datepick_in.sendKeys("27/08/2023");
		WebElement datepick_out = driver.findElement(By.name("datepick_out"));
		datepick_out.clear();
		datepick_out.sendKeys("29/08/2023");
		WebElement AdultRoom = driver.findElement(By.id("adult_room"));
		Select s4= new Select(AdultRoom);
		s4.selectByValue("3");
		WebElement ChildRoom = driver.findElement(By.id("child_room"));
		Select s5= new Select(ChildRoom);
		s5.selectByValue("3");
		driver.findElement(By.id("Submit")).click();
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		driver.findElement(By.name("continue")).click();
		driver.findElement(By.name("first_name")).sendKeys("Sathishkumar");
		driver.findElement(By.name("last_name")).sendKeys("R");
		driver.findElement(By.name("address")).sendKeys("Chennai");
		driver.findElement(By.name("cc_num")).sendKeys("6789045678123456");
		WebElement CCtype = driver.findElement(By.name("cc_type"));
		Select s6= new Select(CCtype);
		s6.selectByValue("MAST");	
		WebElement CCmonth = driver.findElement(By.name("cc_exp_month"));
		Select s7= new Select(CCmonth);
		s7.selectByIndex(3);
		WebElement CCyear = driver.findElement(By.name("cc_exp_year"));
		Select s8= new Select(CCyear);
		s8.selectByValue("2024");
		driver.findElement(By.name("cc_cvv")).sendKeys("678");
		WebElement scrollDown = driver.findElement(By.name("book_now"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scrollDown);
		Thread.sleep(500);
		driver.findElement(By.name("book_now")).click();
		Thread.sleep(7000);
		WebElement scrollDown1 = driver.findElement(By.name("search_hotel"));
		JavascriptExecutor js1 =(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView(true)",scrollDown1);
		Thread.sleep(500);
		WebElement Orderid = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td/form/table/tbody/tr[18]/td[2]/input"));
		System.out.println("Your Booking Id is:"+Orderid.getAttribute("value"));
		Thread.sleep(7000);
		TakesScreenshot tk= (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Mokshi\\eclipse-workspace\\Selenium\\Screenshot\\Booking.png");
		FileHandler.copy(src, des);
		
		driver.quit();
		
	}

}
