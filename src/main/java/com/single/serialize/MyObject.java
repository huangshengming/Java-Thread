package com.single.serialize;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MyObject implements Serializable {

	private static class MyObjectHandler{
		private static MyObject myObject = new MyObject();
	}
	
	private MyObject() {}
	
	public static MyObject getInstance() {
		return MyObjectHandler.myObject;
	}
	
	protected Object readObject() {
		System.out.println("调用了 resolve 方法");
		return MyObjectHandler.myObject;
	}
}
