package org.rupesh.demo.testng;

import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.google.common.collect.Lists;

public class RunTestNGProgramatically {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testNG = new TestNG();
		testNG.addListener(tla);
		List<String> suites = Lists.newArrayList();
		suites.add(".//testng.xml");
		suites.add(".//testng1.xml");
		testNG.setTestSuites(suites);
		testNG.run();
	}

}
