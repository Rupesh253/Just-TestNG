package org.rupesh.demo.testng;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

@SuppressWarnings("unused")
public class MimicTestNG {
	public static void main(String[] args) throws IOException {
		try {
			System.out.println("Hello Rupesh!");
			Thread t_Chrome = new Thread(new ChromeClass());
			Thread t_FireFox = new Thread(new FireFoxClass());
			Thread t_IE = new Thread(new IEClass());
			// Thread t_HtmlUnit = new Thread(new HtmlUnitClass());

			t_Chrome.setName("Chrome");
			t_FireFox.setName("Firefox");
			t_IE.setName("IE");
			// t_HtmlUnit.setName("HtmlUnit");

			t_Chrome.setPriority(5);
			t_FireFox.setPriority(5);
			t_IE.setPriority(5);
			// t_HtmlUnit.setPriority(1);

			System.out.println("After CREATION, states of threads are");
			System.out.println("\t\t\t\t\t" + t_Chrome + " : " + t_Chrome.getState());
			System.out.println("\t\t\t\t\t" + t_FireFox + " : " + t_FireFox.getState());
			// System.out.println("\t\t\t\t\t" + t_HtmlUnit + " : " +
			// t_HtmlUnit.getState());
			System.out.println("\t\t\t\t\t" + t_IE + " : " + t_IE.getState() + "\n");
			t_Chrome.start();
			System.out.print("||****[Chrome Thread Started]****||");
			t_FireFox.start();
			System.out.print("||****[Firefox Thread Started]****||");
			t_IE.start();
			System.out.println("||****[IE Thread Started]****||");
			// t_HtmlUnit.start();
			// System.out.println("||****[HtmlUnit Thread Started]****||");

			System.out.println("After STARTED, states of threads are");
			System.out.println("\t\t\t\t\t" + t_Chrome + " : " + t_Chrome.getState());
			System.out.println("\t\t\t\t\t" + t_FireFox + " : " + t_FireFox.getState());
			// System.out.println("\t\t\t\t\t" + t_HtmlUnit + " : " +
			// t_HtmlUnit.getState());
			System.out.println("\t\t\t\t\t" + t_IE + " : " + t_IE.getState() + "\n");
		} catch (Exception e) {

		} finally {

		}
	}

}

class ChromeClass implements Runnable {

	public void run() {
		Class<?> c;
		WebDriver driver = null;
		try {
			c = new Object() {
			}.getClass().getEnclosingClass();
			String packageName = c.getPackage().getName().toString();
			String className = c.getSimpleName().toString();
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			System.out.println("\t \t" + packageName + "." + className + "." + methodName + "() started");
			String chromeEXEPath = "C:\\Users\\sp369w\\Downloads\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeEXEPath);
			driver = new ChromeDriver();
			ToHave th = new ToHave();
			th.toDoMethod(className, driver);
			System.out.println("\t \t" + packageName + "." + className + "." + methodName + "() stopped");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			driver.quit();
			Runtime run = Runtime.getRuntime();
			String line = null;
			StringBuilder sb = new StringBuilder();
			Process p;
			try {
				p = run.exec("taskkill /im chromedriver.exe /f");
				BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = bf.readLine()) != null) {
					sb.append(line + "\n");
				}
				bf.close();
				System.out.println(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}

class FireFoxClass implements Runnable {

	public void run() {
		Class<?> c;
		WebDriver driver = null;
		try {
			c = new Object() {
			}.getClass().getEnclosingClass();
			String packageName = c.getPackage().getName().toString();
			String className = c.getSimpleName().toString();
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			System.out.println("\t \t" + packageName + "." + className + "." + methodName + "() started");
			String geckoEXEPath = "C:\\Users\\sp369w\\Downloads\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", geckoEXEPath);
			driver = new FirefoxDriver();
			ToHave th = new ToHave();
			th.toDoMethod(className, driver);
			System.out.println("\t \t" + packageName + "." + className + "." + methodName + "() stopped");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			driver.quit();
			Runtime run = Runtime.getRuntime();
			String line = null;
			StringBuilder sb = new StringBuilder();
			Process p;
			try {
				p = run.exec("taskkill /im geckodriver.exe /f");
				BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = bf.readLine()) != null) {
					sb.append(line + "\n");
				}
				bf.close();
				System.out.println(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}

class IEClass implements Runnable {

	public void run() {
		Class<?> c;
		WebDriver driver = null;
		try {
			c = new Object() {
			}.getClass().getEnclosingClass();
			String packageName = c.getPackage().getName().toString();
			String className = c.getSimpleName().toString();
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			System.out.println("\t \t" + packageName + "." + className + "." + methodName + "() started");
			String ieEXEPath = "C:\\Users\\sp369w\\Downloads\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", ieEXEPath);
			driver = new InternetExplorerDriver();
			ToHave th = new ToHave();
			th.toDoMethod(className, driver);
			System.out.println("\t \t" + packageName + "." + className + "." + methodName + "() stopped");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
			Runtime run = Runtime.getRuntime();
			String line = null;
			StringBuilder sb = new StringBuilder();
			Process p;
			try {
				p = run.exec("taskkill /im IEDriverServer.exe /f");
				p = run.exec("taskkill /im iexplore.exe /f");
				BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((line = bf.readLine()) != null) {
					sb.append(line + "\n");
				}
				bf.close();
				System.out.println(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}

class HtmlUnitClass implements Runnable {

	public void run() {
		Class<?> c;
		WebDriver driver = null;
		try {
			c = new Object() {
			}.getClass().getEnclosingClass();
			String packageName = c.getPackage().getName().toString();
			String className = c.getSimpleName().toString();
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			System.out.println("\t \t" + packageName + "." + className + "." + methodName + "() started");
			driver = new HtmlUnitDriver();
			ToHave th = new ToHave();
			th.toDoMethod(className, driver);
			System.out.println("\t \t" + packageName + "." + className + "." + methodName + "() stopped");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}

class ToHave {
	public void toDoMethod(String name, WebDriver driver) throws InterruptedException {
		System.out.println(name.replaceAll("Class", "Driver") + " script EXECUTING");
		driver.get("http://executeautomation.com/demosite/Login.html");
		driver.findElement(By.name("UserName")).sendKeys("rupesh");
		driver.findElement(By.name("Password")).sendKeys("rupesh");
		driver.findElement(By.name("Login")).submit();
		if (name == "IEClass") {

		}
		Select select = new Select(driver.findElement(By.name("TitleId")));
		select.selectByVisibleText("Mr.");
		driver.findElement(By.name("Initial")).sendKeys("somala");
		driver.findElement(By.name("FirstName")).sendKeys("rupesh");
		driver.findElement(By.name("MiddleName")).sendKeys("kumar");
		driver.findElement(By.name("Save")).click();
		System.out.println(name.replaceAll("Class", "Driver") + " script EXECUTED");

	}
}
