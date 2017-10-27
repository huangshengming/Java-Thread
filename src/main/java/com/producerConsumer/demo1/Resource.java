package com.producerConsumer.demo1;

import java.util.ArrayList;
import java.util.List;

public class Resource {

	//相当于仓库
	private List<String> list = new ArrayList<>();
	
	public synchronized void push() {
		try {
			while(list.size() == 1) {
				this.wait();
			}
			Thread.sleep(200);
			String v = System.currentTimeMillis() + "";
			list.add(v);
			System.out.println(Thread.currentThread().getName() + ",放入 v=" + v);
			this.notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void pop() {
		try {
			while(list.size() == 0) {
				this.wait();
			}
			System.out.println(Thread.currentThread().getName() + ",取出 v=" + list.get(0));
			list.remove(0);
			this.notifyAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
