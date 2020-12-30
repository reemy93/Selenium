package rahulshettyacademy.Mavenjava;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.annotation.DependsOn;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Reemy {

	@Test
	public static void main() throws InterruptedException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("*************************************\n");
		System.out.println("\t\t\t\t\t\tWELCOME\n");
		System.out.println("*************************************");
		
		
	    SoftAssert softAssert =new SoftAssert();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		
		// entering wibbitz.com 
		//deleting all coockies and maximizing the window 
		// enters email & password then clicks on LogIn
		// implicit wait is defined for maximum time of 15 sec
		
		driver.get("https://studio.wibbitz.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(2000L);
		driver.findElement(By.id("1-email")).click();
		driver.findElement(By.id("1-email")).sendKeys("Reemy93@gmail.com");             // email address
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Rn204404065!");  // password
		driver.findElement(By.cssSelector("span[class='auth0-label-submit']")).click(); // clicking on submit buttom      
        driver.findElement(By.cssSelector("span[data-test-id='Templates']")).click();    // clicking on templates
        driver.findElement(By.xpath("//*[@class='simple-video-grid-masonry']/div" )).click();  // using parent child method in css , div is in '0' index

		// move cursor to the video component in order to see invisible locators 
		Actions actions = new Actions(driver);
		WebElement video = driver.findElement(By.cssSelector("div[class='video-player landscape']"));
		actions.moveToElement(video).perform();
		String currentDuration = driver.findElement(By.cssSelector("p[class='current-time  dark-theme'")).getText();
        String totalDuration = driver.findElement(By.cssSelector("p[class='total-time dark-theme']")).getText();
        // the time duration in the video does not reach 0:24 wich is the total time 
        // the while loop is always true 
		
		Volume(driver);

		while (currentDuration != totalDuration) {
			actions.moveToElement(video).perform();

			currentDuration = driver.findElement(By.cssSelector("p[class='current-time  dark-theme'")).getText();
			// after displaying the video i click on close button
			if (currentDuration.equalsIgnoreCase("0:23")) {
				driver.findElement(By.cssSelector("button[data-test-id='video-page-close-button'")).click();
				break;
			}
		}
	Thread.sleep(2000L);
	MoveTo(driver);
	Thread.sleep(5000L);
	CheckList(driver);
	Thread.sleep(7000L);
	SignOut(driver);
	//Intercom(driver);	  	   		
	}
	
	
	// this method turn the volume off then on 
	public static void Volume(WebDriver driver) throws InterruptedException {		
		driver.findElement(By.cssSelector("span[class='icon icon-VolumeOn     ']")).click();
		Thread.sleep(1000L);
		driver.findElement(By.cssSelector("span[class='icon icon-VolumeOff     ']")).click();
		
	}
	
		
	
	// this method moves to social media category , then playes a video 'best quote'
	// and closes it
	public static void MoveTo(WebDriver driver) throws IOException, InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[5]/div[1]/div/div[1]/div/div[6]/div")).click();
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div/div[5]/div[2]/div[2]/div[3]/div/div[1]/img")).click();
		Thread.sleep(17000L);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/span/button")).click();

	}
  	
  	
  	
  	
  	// for some reason after running this test a couple of times, the Intercom button disappeared from the web page
  	// this method clicks on the intercom button by switching to it's frame first
  	// then it types in the text-box 'hello' and sends it 
  	// waits for a reply and prints the first message it gets back from wibbitz intercom 

    @Test (dependsOnMethods = { "main" })
  	public static void Intercom(WebDriver driver) throws InterruptedException {
  		driver.findElement(By.cssSelector("div[aria-label='Open Intercom Messenger']")).click();
		driver.switchTo().frame("intercom-messenger-frame");
		driver.findElement(By.xpath("//div[@class='intercom-18biwo esf9qb11']")).click();
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("hello");
		driver.findElement(By.cssSelector("button[aria-label='Send a message…']")).click();
		System.out.println("\nwibbitz response : \n");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"intercom-container\"]/div/div/div[1]/div/div[3]/div/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div")).getText());
		System.out.println("finished Intercom");
  	}
  	
  	
  	//this method signs out of the Wibbitz account 
  	public static void SignOut(WebDriver driver) {
  		
  		driver.findElement(By.cssSelector("div[class='dropdown-arrow-container']")).click();
  		driver.findElement(By.cssSelector("div[class='logout-button-container']")).click();
  	}
  	
  	
  	
  	
  	// this method clicks on HOME, then clicks on ' All formats' checklist 
  	// then it unchecks the 'Landscape' checkbox 
  	// it verifies that the checkbox is unchecked by using soft assert 
  	// then clicks on apply 
  	public static void CheckList(WebDriver driver) {
  		driver.findElement(By.cssSelector("span[data-test-id='Home']")).click();
  		driver.findElement(By.cssSelector("div[data-test-id='formats-dropdown']")).click();
  		driver.findElement(By.cssSelector("label[class='bp3-control bp3-checkbox checked']")).click();
  		SoftAssert a =new SoftAssert();
  		a.assertFalse(driver.findElement(By.cssSelector("label[class='bp3-control bp3-checkbox checked']")).isSelected());  		
  		driver.findElement(By.cssSelector("span[data-test-id='apply']")).click();
  	    a.assertAll();

  	}

}
