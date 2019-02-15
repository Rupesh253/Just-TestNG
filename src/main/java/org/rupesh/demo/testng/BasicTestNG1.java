package org.rupesh.demo.testng;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BasicTestNG1 {
	@Test(groups = { "Regression Test", "Sanity Test" })
	public void f() {
		System.out.println("test:BasicTestNG1");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod:BasicTestNG1");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod:BasicTestNG1");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass:BasicTestNG1");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass:BasicTestNG1");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest:BasicTestNG1");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest:BasicTestNG1");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite:BasicTestNG1");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite:BasicTestNG1");
	}

}
