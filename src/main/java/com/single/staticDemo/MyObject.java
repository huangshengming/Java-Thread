package com.single.staticDemo;

public class MyObject {

	private static MyObject myObject = null;
	
	private MyObject() {}
	
	static {
		myObject = new MyObject();
	}
	
	public static MyObject getInstance() {
		return myObject;
	}
}
