package com.simple.one;

public class C {

	private String lock;
	
	public C(String lock) {
		this.lock = lock;
	}
	
	public void getValue() {
		try {
			synchronized (lock) {
				if(ValueObject.value == "") {
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
