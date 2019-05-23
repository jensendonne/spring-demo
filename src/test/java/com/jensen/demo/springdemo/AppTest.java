package com.jensen.demo.springdemo;

import junit.framework.Test;
//import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest/* extends TestCase*/ {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
//	public AppTest(String testName) {
//		super(testName);
//	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
//	public void testApp() {
//		assertTrue(true);
//	}
	
	@org.junit.Test
	public void threadTest() {
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("Hello.");
			}
		};
		t.start();
		t.interrupt();
//		t.stop();
//		t.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("isAlive: " + t.isAlive());
		System.out.println("isDaemon: " + t.isDaemon());
	}
}
