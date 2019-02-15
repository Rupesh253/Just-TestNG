package crossBrowserTesting;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestInFireFoxBrowser {
	TestCodeClass testCodeClass = new TestCodeClass();
	BrowserFactory browserFactory = new BrowserFactory();

	@Parameters({ "firefox_browser" })
	@Test
	public void f(String firefox_browser) {
		try {			
			testCodeClass.testCodeMethod(browserFactory.browserSelection(firefox_browser));
			browserFactory.browserKilling(firefox_browser);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
		}
	}

}
