package crossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import crossBrowserTesting.BrowserFactory.ChromeSettings;

public class TestInChromeBrowser {

	TestCodeClass testCodeClass = new TestCodeClass();
	BrowserFactory browserFactory = new BrowserFactory();

	@Parameters({ "chrome_browser" })
	@Test
	public void f(String chrome_browser) {
		try {
			testCodeClass.testCodeMethod(browserFactory.browserSelection(chrome_browser));
			browserFactory.browserKilling(chrome_browser);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
		} finally {
		
		}
	}

}
