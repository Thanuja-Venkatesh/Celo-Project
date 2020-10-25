package Newpackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class CeloAuto {

	WebDriver driver = null;

	//Initiating the setup
	@BeforeTest
	public void setUp() {
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/driver/chromedriver.exe");
		driver = new ChromeDriver(); 
		
	}

	//Login to the application with the credentials
	@Test (priority=1)
	public void loginApplication() {
		
		driver.get("https://stagingapp.celohealth.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		WebElement login = driver.findElement(By.xpath("//button[@id='login']"));
		login.click();
		WebElement userid = driver.findElement(By.xpath("//input[@id='Username']"));
		userid.sendKeys("qa.candidate+01@celohealth.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		password.sendKeys("3tQp+,/Q");
		WebElement loginbutton = driver.findElement(By.name("button"));
		loginbutton.click();
		
	}

	//setup the pin
	@Test (priority=2)
	public void setupPin() {
		
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		WebElement pinnum = driver.findElement(By.xpath("//input[@id='pin_code']"));
		pinnum.sendKeys("9876");
		WebElement repinnum = driver.findElement(By.xpath("//input[@name='passcodeConfirm']"));
		repinnum.sendKeys("9876");
		WebElement nextbutton = driver.findElement(By.xpath("//span[contains(text(),'NEXT')]"));
		nextbutton.click();
		
	}

	//Sending a text message to the existing conversation
	@Test (priority=3)
	public void sendMessage_ExistingConversation() {
		
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		WebElement adminqa = driver.findElement(By.xpath("//div[contains(text(),'Admin QA')]"));
		adminqa.click();
		WebElement sendmessage = driver.findElement(By.xpath("//textarea[@id='celo-send-message-textarea']"));
		sendmessage.sendKeys("Thank you for considering my profile");
		WebElement smileymsg = driver.findElement(By.xpath("//button[@id='emoji-button']"));
		smileymsg.click();
		WebElement smileybutton = driver.findElement(By.xpath("(//div[@data-name='Smileys & People']/following-sibling::ngx-emoji/button)[2]"));
		smileybutton.click();
		WebElement send = driver.findElement(By.xpath("//mat-icon[contains(text(),'send')]"));
		send.click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		
	}

	//Logout the application
	@Test (priority=4)
	public void Logout() {	

		WebElement logout = driver.findElement(By.xpath("//div[contains(text(),'QA Candidate One')]"));
		logout.click();
		WebElement clicklogout = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
		clicklogout.click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);

	}

	//Close the browser
	@AfterTest
	public void Teardown() {

		System.out.println("success");
		driver.close();

	}
}	



