/**
 * 
 */
package com.jensen.demo.springdemo;

import org.junit.Test;

/**
 * @author Rocketman
 *
 */
public class ThreadTest {
	/**
	 * 重复start，报异常 IllegalThreadStateException
	 */
	@Test
	public void startThreadAfterInterrupt() {
		MyThread1 t = new MyThread1();
		// Thread t = new Thread() {
		// @Override
		// public void run() {
		// System.out.println("Hello.");
		// }
		// };
		System.out.println("isAlive: " + t.isAlive());
		System.out.println("isDaemon: " + t.isDaemon());
		t.start();
		t.interrupt();
		// t.stop();
		// t.start();
		System.out.println("isAlive: " + t.isAlive());
		System.out.println("isDaemon: " + t.isDaemon());
	}

	/**
	 * 执行完run方法之后，线程死亡
	 */
	@Test
	public void afterEndingRunning() {
		MyThread1 t = new MyThread1();
		System.out.println("isAlive: " + t.isAlive());
		t.start();
		System.out.println("isAlive: " + t.isAlive());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("isAlive: " + t.isAlive());
	}

	/**
	 * 线程由JVM调用run和手动run的差异。手动调用run方法，和调用一般对象的public方法无甚区别。
	 */
	@Test
	public void runThread() {
		Thread t = new MyThread1();
//		t.start();
		t.run();
		System.out.println(Thread.currentThread());
	}

	public class MyThread1 extends Thread {
		@Override
		public void run() {
			System.out.println("Hello. I'm " + Thread.currentThread());
		}
	}
}
