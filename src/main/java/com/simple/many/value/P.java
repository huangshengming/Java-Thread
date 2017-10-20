package com.simple.many.value;

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
				while(ValueObject.value != "") {
					lock.wait();
				}
				Thread.sleep(3000);
				String v = System.currentTimeMillis() + "";
				System.out.println("生产数值:" + v);
				ValueObject.value = v;
				lock.notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
