
package org.rupesh.demo.testng;

import java.io.FileNotFoundException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class BasicTestNG2 implements IRetryAnalyzer {

	@BeforeGroups({ "Regression Test" })
	public void beforeGroupOfRegressionTest() {
		System.out.println("BeforeGroups Of Regression Test");
	}

	@AfterGroups("Regression Test")
	public void afterGroupOfRegressionTest() {
		System.out.println("AfterGroups Of Regression Test");
	}

	@BeforeGroups({ "Sanity Test" })
	public void beforeGroupOfSanityTest() {
		System.out.println("BeforeGroups Of Sanity Test");
	}

	@AfterGroups("Sanity Test")
	public void afterGroupOfSanityTest() {
		System.out.println("AfterGroups Of Sanity Test");
	}

	@Test(priority = 1, description = "Method A will perform", groups = { "Regression Test",
			"Onshore or OffShore" }, enabled = true, alwaysRun = true, expectedExceptions = {
					Exception.class }, invocationCount = 1, successPercentage = 100, threadPoolSize = 5, retryAnalyzer = BasicTestNG2.class)
	public void a() throws Exception {
		System.out.println("test:a:BasicTestNG2_" + Thread.currentThread() + "_" + Thread.currentThread().getName());
		throw new Exception();
	}

	@Test(priority = 2, description = "Method B will perform", groups = { "Regression Test", "Sanity Test",
			"OffShore" }, enabled = true, alwaysRun = true, expectedExceptions = {
					ArithmeticException.class }, retryAnalyzer = BasicTestNG2.class)
	public void b() throws Exception {
		System.out.println("test:b:BasicTestNG2");
		throw new FileNotFoundException();
	}

	@Test(priority = 3, description = "Method C will perform", groups = { "Sanity Test", "Regression Test",
			"Onshore" }, enabled = true, alwaysRun = true, expectedExceptions = { Exception.class })
	public void c() throws Exception {
		System.out.println("test:c:BasicTestNG2");
		throw new Exception();
	}

	@Test(priority = 3, description = "Method D will perform", groups = { "Repetitive Test",
			"Onshore and OffShore" }, enabled = true, alwaysRun = true, expectedExceptions = { Exception.class })
	public void d() throws Exception {
		System.out.println("test:d:BasicTestNG2");
		throw new Exception();
	}

	@Test(description = "Method E will perform", dependsOnMethods = { "a", "b" }, expectedExceptions = {
			Exception.class })
	public void e() throws Exception {
		System.out.println("test:e depends on test:a and test:b i.e., E=A+B");
		throw new Exception();
	}

	@Test(description = "Method F will perform", dependsOnMethods = { "a",
			"b" }, alwaysRun = true, expectedExceptions = { Exception.class })
	public void f() throws Exception {
		System.out.println("test:f doesn't depends on test:a and test:b i.e., E!=A+B");
		throw new Exception();
	}

	@Test(description = "Method G will perform", dependsOnGroups = { "Sanity Test" }, expectedExceptions = {
			Exception.class })
	public void g() throws Exception {
		System.out.println("test:g depends on groups \"Sanity Test\"");
		throw new Exception();
	}

	@Test(description = "Method H will perform", dependsOnGroups = {
			"Sanity Test" }, alwaysRun = true, expectedExceptions = { Exception.class })
	public void h() throws Exception {
		System.out.println("test:h doesn't depends on groups \"Sanity Test\"");
		throw new Exception();

	}

	private int retryCount = 0;
	private static final int maxRetryCount = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
