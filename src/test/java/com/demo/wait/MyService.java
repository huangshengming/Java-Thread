package com.demo.wait;

import java.util.ArrayList;
import java.util.List;

public class MyService {

	private static List<String> l = new ArrayList<>();
	
	public synchronized void setV() {
		try {
			if(l.size() == 1) {
				this.wait();
			}
			String v = System.currentTimeMillis() + "";
			System.out.println("set v = " + v);
			l.add(v);
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void getV() {
		try {
			if(l.size() == 0) {
				this.wait();
			}
			System.out.println("get v = " + l.get(0));
			l.remove(0);
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
