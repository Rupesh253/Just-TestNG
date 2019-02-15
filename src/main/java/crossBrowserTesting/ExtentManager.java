package crossBrowserTesting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

import org.openqa.selenium.*;

public class ExtentManager {
	private static ExtentReports extentReports;
	private static Platform platform;
	private static String reportFileName = "ExtentReports-Version3-Test-Automaton-Report.html";
	private static String macPath = System.getProperty("user.dir") + "/TestReporter";
	private static String windowsPath = System.getProperty("user.dir") + "\\TestReporter";
	private static String macReportFileLoc = macPath + "/" + reportFileName;
	private static String winReportFileLoc = windowsPath + "\\" + reportFileName;

	public static ExtentReports getInstance() {
		if (extentReports == null) {
			extentReports = createInstance();
		}
		return extentReports;
	}

	public static ExtentReports createInstance() {
		platform = getCurrentPlatform();
		String fileName = getReportFileLocation(platform);
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Cross Browser Testing");
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName("CBT");

		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);

		return extentReports;
	}

	private static String getReportFileLocation(Platform platform) {
		String reportFileLocation = null;
		switch (platform) {
		case MAC:
			reportFileLocation = macReportFileLoc;
			createReportPath(macPath);
			System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
			break;
		case WINDOWS:
			reportFileLocation = winReportFileLoc;
			createReportPath(windowsPath);
			System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
			break;
		default:
			System.out.println("ExtentReport path has not been set! There is a problem!\n");
			break;
		}
		return reportFileLocation;
	}

	private static void createReportPath(String path) {
		File testDirectory = new File(path);
		if (!testDirectory.exists()) {
			if (testDirectory.mkdir()) {
				System.out.println("Directory: " + path + " is created!");
			} else {
				System.out.println("Failed to create directory: " + path);
			}
		} else {
			System.out.println("Directory already exists: " + path);
		}
	}

	private static Platform getCurrentPlatform() {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("win")) {
			platform = Platform.WINDOWS;
		} else if (osName.contains("nix") || osName.contains("nux") || osName.contains("aix")) {
			platform = Platform.LINUX;
		} else if (osName.contains("mac")) {
			platform = Platform.MAC;
		}

		return platform;

	}

}
