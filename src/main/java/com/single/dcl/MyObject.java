package com.single.dcl;

/**
 * 采用 DCl 双锁机制
 * @author xingwuzhao
 *
 */
public class MyObject {
	
	private volatile static MyObject myObject;
	
	private MyObject() {
		
	}
	
	public static MyObject getobj() {
		try {
			if(myObject != null) {
				
			}else {
				//模拟 创建实例前 进行一系列准备工作
				Thread.sleep(2000);
				synchronized (MyObject.class) {
					if(myObject == null) {
						myObject = new MyObject();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return myObject;
	}

}
