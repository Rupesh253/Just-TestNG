package org.rupesh.demo.testng;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

@SuppressWarnings("unused")
public class App {
	public static void main(String[] args) throws IOException {
		try {
			System.out.println("Hello Rupesh!");
			Thread t_Chrome = new Thread(new Chrome());
			Thread t_FireFox = new Thread(new FireFox());
			Thread t_IE = new Thread(new IE());

			t_Chrome.setName("Chrome");
			t_FireFox.setName("Firefox");
			t_IE.setName("IE");

			t_Chrome.setPriority(5);
			t_FireFox.setPriority(5);
			t_IE.setPriority(5);

			System.out.println("After CREATION, states of threads are");
			System.out.println("\t\t\t\t\t" + t_Chrome + " : " + t_Chrome.getState());
			System.out.println("\t\t\t\t\t" + t_FireFox + " : " + t_FireFox.getState());
			System.out.println("\t\t\t\t\t" + t_IE + " : " + t_IE.getState() + "\n");
			t_Chrome.start();
			System.out.print("||****[Chrome Thread Started]****||");
			t_FireFox.start();
			System.out.print("||****[Firefox Thread Started]****||");
			t_IE.start();
			System.out.println("||****[IE Thread Started]****||");
			System.out.println("After STARTED, states of threads are");
			System.out.println("\t\t\t\t\t" + t_Chrome + " : " + t_Chrome.getState());
			System.out.println("\t\t\t\t\t" + t_FireFox + " : " + t_FireFox.getState());
			System.out.println("\t\t\t\t\t" + t_IE + " : " + t_IE.getState() + "\n");
		} catch (Exception e) {

		} finally {

		}
	}

}

class Chrome implements Runnable {

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
			driver.get("http://executeautomation.com/demosite/Login.html");
			driver.findElement(By.name("UserName")).sendKeys("rupesh");
			driver.findElement(By.name("Password")).sendKeys("rupesh");
			driver.findElement(By.name("Login")).submit();
			ToHaveClass thc = new ToHaveClass();
			thc.toDoMethod(className);
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
					sb.append(line);
				}
				bf.close();
				System.out.println(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}

class FireFox implements Runnable {

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
			driver.get("http://executeautomation.com/demosite/Login.html");
			driver.findElement(By.name("UserName")).sendKeys("rupesh");
			driver.findElement(By.name("Password")).sendKeys("rupesh");
			driver.findElement(By.name("Login")).submit();
			ToHaveClass thc = new ToHaveClass();
			thc.toDoMethod(className);
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
					sb.append(line);
				}
				bf.close();
				System.out.println(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}

class IE implements Runnable {

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
			driver.get("http://executeautomation.com/demosite/Login.html");
			driver.findElement(By.name("UserName")).sendKeys("rupesh");
			driver.findElement(By.name("Password")).sendKeys("rupesh");
			driver.findElement(By.name("Login")).submit();

			ToHaveClass thc = new ToHaveClass();
			thc.toDoMethod(className);
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
					sb.append(line);
				}
				bf.close();
				System.out.println(sb.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}

class ToHaveClass {
	public void toDoMethod(String name) {
		for (int i = 1; i <= 10; i++)
			System.out.println(name + i);
	}
}
