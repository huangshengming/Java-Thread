package com.simple.one.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

	private List<String> stack_l = new ArrayList<>();
	
	synchronized public void push() {
		try {
			if(stack_l.size() == 1) {
				this.wait();
			}
			Thread.sleep(2000);
			String v = System.currentTimeMillis() + "";
			System.out.println("生产数值:" + v);
			stack_l.add(v);
			this.notify();
			System.out.println("size=" + stack_l.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	synchronized public void pop() {
		try {
			if(stack_l.size() == 0) {
				this.wait();
			}
			String v = stack_l.get(0);
			System.out.println("消费数值:" + v);
			stack_l.remove(0);
			this.notify();
			System.out.println("size=" + stack_l.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
