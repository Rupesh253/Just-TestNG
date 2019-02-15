package crossBrowserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCodeClass {

	WebDriver driver;

	public void testCodeMethod(WebDriver driver) {
		driver.navigate().to("http://executeautomation.com/demosite/Login.html");
		driver.findElement(By.name("UserName")).sendKeys("rupesh");
		driver.findElement(By.name("Password")).sendKeys("rupesh");
		driver.findElement(By.name("Login")).submit();
		driver.findElement(By.name("Initial")).sendKeys("S");
		driver.findElement(By.name("FirstName")).sendKeys("rupesh");
		driver.findElement(By.name("MiddleName")).sendKeys("kumar");
		driver.findElement(By.name("Save")).click();
	}

}
