package com.single.dcl;

public class MyThread extends Thread {

	@Override
	public void run() {
		System.out.println(MyObject.getobj().hashCode());
	}
}
