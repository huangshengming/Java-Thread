package com.simple.one;

/**
 * 生产者
 * @author xingwuzhao
 *
 */
public class P {

	private String lock;

	public P(String lock) {
		super();
		this.lock = lock;
	}
	
	public void setValue() {
		try {
			synchronized (lock) {
				if(ValueObject.value != "") {
					lock.wait();
				}
				System.out.println("生产数值...");
				ValueObject.value = System.currentTimeMillis() + "";
				lock.notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
