package projOne;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test_proj {

	WebDriver driver =new ChromeDriver(); 
	
	
 @BeforeTest 
	 public void myBeforeTest() {
	 driver.get("https://www.saucedemo.com/");
	 
 }
 
 
 
 
 @Test()
 public void myTest() throws InterruptedException {
	 driver.findElement(By.id("user-name")).sendKeys("standard_user");
	 driver.findElement(By.id("password")).sendKeys("secret_sauce");
	 driver.findElement(By.cssSelector("[data-test='login-button']")).click();
	 
	List<WebElement> addToCartButton=driver.findElements(By.className("btn_primary"));
			for(int i=0;i< addToCartButton.size();i++ ) {
				addToCartButton.get(i).click();
				
			}
//			Thread.sleep(3000);
			driver.findElement(By.className("shopping_cart_badge")).click();
			driver.findElement(By.id("checkout")).click();
			driver.findElement(By.id("first-name")).sendKeys("heba");
			driver.findElement(By.id("last-name")).sendKeys("maloalain");
			driver.findElement(By.id("postal-code")).sendKeys("1234");
//			Thread.sleep(2000);
			driver.findElement(By.id("continue")).click();
//			driver.findElement(By.id("finish")).click();
//			String thanksMsg =driver.findElement(By.className("complete-header")).getText();
////			System.out.println(thanksMsg);
//			 SoftAssert Assert=new SoftAssert();
//	 Assert.assertEquals("Thank you for your order!", thanksMsg);
//	 
//	 Boolean toCheckThankYou=thanksMsg.contains("Thank you");
//
//	 Assert.assertEquals(toCheckThankYou, true);
//	 Assert.assertAll();
//	 Thread.sleep(2000);
//	 driver.findElement(By.id("back-to-products")).click();
		String total =	driver.findElement(By.className("summary_total_label")).getText();
	 
//	 System.out.println(total.substring(8));
		 String [] myNewString =total.split("\\$");
		 System.out.println(myNewString[1]);
			String actualUrl=driver.getCurrentUrl();
			String expectedUrl="https://www.saucedemo.com/checkout-step-two.html";
//*************************** soft assert***********************************
			
	SoftAssert Assert=new SoftAssert();
	Assert.assertEquals(myNewString[1], "140.34");
	Assert.assertEquals(actualUrl, expectedUrl);
	Assert.assertAll();
//*********************hard assert********************
		 Assert.assertEquals(myNewString[1],"140.34");
 }
 
 
 @AfterTest
 public void myAfterTest() {}
	
	
	
}
