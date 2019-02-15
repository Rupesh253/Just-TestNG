package crossBrowserTesting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	String browserName;
	WebDriver driver;

	public BrowserFactory(String browserName) {
		this.browserName = browserName;
		this.driver = null;
	}

	public BrowserFactory() {
		this.browserName = browserName;
		this.driver = null;
	}

	public WebDriver browserSelection(String browserName) {
		try {
			switch (browserName.toUpperCase()) {
			case "CHROME":
				driver = ChromeSettings.kickOffChrome();
				break;

			case "FIREFOX":
				driver = FireFoxSettings.kickOffFireFox();
				break;

			case "IE":
				driver = IESettings.kickStartIE();
				break;
			default:
				break;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
		}
		return driver;
	}

	public void browserKilling(String browserName) {
		try {
			switch (browserName.toUpperCase()) {
			case "CHROME":
				ChromeSettings.signOffChrome();
				break;

			case "FIREFOX":
				FireFoxSettings.signOffFireFox();
				break;

			case "IE":
				IESettings.signOffIE();
				break;
			default:
				break;
			}

		} catch (Exception e) {
			System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
		}
	}

	public static class ChromeSettings {
		static WebDriver driver;

		public static WebDriver kickOffChrome() {
			try {
				String chromeEXEPath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + "chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromeEXEPath);
				driver = new ChromeDriver();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
			}
			return driver;
		}

		public static void signOffChrome() throws IOException {
			try {
				Runtime run = Runtime.getRuntime();
				Process p = run.exec("taskkill /im chrome.exe /f"); //chromedriver.exe
				String line = null;
				StringBuilder sb = new StringBuilder();
				BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = bf.readLine()) != null) {
					sb.append(line+"\n");
				}
				String toPrint = sb.toString();
				System.out.println(toPrint);
			} catch (Exception e) {
				System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
			}
		}

	}

	public static class FireFoxSettings {
		static WebDriver driver;

		public static WebDriver kickOffFireFox() {
			try {
				String geckoEXEPath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + "geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", geckoEXEPath);
				driver = new FirefoxDriver();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
			}
			return driver;
		}

		public static void signOffFireFox() throws IOException {
			try {
				Runtime run = Runtime.getRuntime();
				Process p = run.exec("taskkill /im firefox.exe /f"); //geckodriver.exe
				String line = null;
				StringBuilder sb = new StringBuilder();
				BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = bf.readLine()) != null) {
					sb.append(line+"\n");
				}
				String toPrint = sb.toString();
				System.out.println(toPrint);
			} catch (Exception e) {
				System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
			}
		}
	}

	public static class IESettings {
		static WebDriver driver;

		public static WebDriver kickStartIE() {
			try {
				String ieEXEPath = System.getProperty("user.dir") + "\\src\\test\\resources\\" + "IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", ieEXEPath);
				driver = new InternetExplorerDriver();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
			}
			return driver;
		}

		public static void signOffIE() throws IOException {
			try {
				Runtime run = Runtime.getRuntime();
				Process p = run.exec("taskkill /im iexplore.exe /f"); //IEDriverServer.exe
				String line = null;
				StringBuilder sb = new StringBuilder();
				BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = bf.readLine()) != null) {
					sb.append(line+"\n");
				}
				String toPrint = sb.toString();
				System.out.println(toPrint);
			} catch (Exception e) {
				System.out.println(e.getMessage() + "/\\/\\/\\" + e.getStackTrace());
			}
		}
	}

}
