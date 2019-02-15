package org.rupesh.demo.testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

@Listeners(org.rupesh.demo.testng.AbsoluteListeners.class)
public class AbsoluteListeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " test case started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase passed is :" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :" + result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase skipped is :" + result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("is on start");
		XmlSuite suite = context.getCurrentXmlTest().getSuite();
		System.out.println(suite);
		System.out.println(suite.getName());
		System.out.println(suite.getAllParameters());
		System.out.println(suite.getParameter("some"));
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("is on finish");

	}
}
