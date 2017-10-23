package com.single.enumDemo;

public class MyObject {
	
	private MyObject() {}
	
	private static enum SingleObject{
		INSTANCE;
		
		private MyObject myObject;
		
		private SingleObject() {
			myObject = new MyObject();
		}
		
		public MyObject getInstance() {
			return myObject;
		}
	}
	
	public static MyObject getInstance() {
		return SingleObject.INSTANCE.getInstance();
	}

}
