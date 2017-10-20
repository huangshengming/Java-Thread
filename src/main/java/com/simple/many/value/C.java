package com.simple.many.value;

/**
 * 消费者
 * @author xingwuzhao
 *
 */
public class C {

	private String lock;
	
	public C(String lock) {
		this.lock = lock;
	}
	
	public void getValue() {
		try {
			synchronized (lock) {
				while(ValueObject.value == "") {
					lock.wait();
				}
				System.out.println("消费数值:" + ValueObject.value);
				ValueObject.value = "";
				lock.notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
