package com.simple.one;

public class MainT {

	public static void main(String[] args) {
		
		String lock = new String("");
		P p = new P(lock);
		C c = new C(lock);
		
		ThreadC tc = new ThreadC(c);
		tc.start();
		
		ThreadP tp = new ThreadP(p);
		tp.start();
	}
}
