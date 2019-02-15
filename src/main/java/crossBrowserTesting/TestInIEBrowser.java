package crossBrowserTesting;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestInIEBrowser {
	TestCodeClass testCodeClass = new TestCodeClass();
	BrowserFactory browserFactory = new BrowserFactory();

	@Parameters({ "ie_browser" })
	@Test
	public void f(String ie_browser) {
		try {

			testCodeClass.testCodeMethod(browserFactory.browserSelection(ie_browser));
			browserFactory.browserKilling(ie_browser);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
		}
	}

}
