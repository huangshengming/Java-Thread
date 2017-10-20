package com.simple.many.value;

public class MainT {

	public static void main(String[] args) {
		
		String lock = new String("");
		P p = new P(lock);
		C c = new C(lock);
		
		ThreadC tc1 = new ThreadC(c);
		tc1.start();
		ThreadC tc2 = new ThreadC(c);
		tc2.start();
		ThreadC tc3 = new ThreadC(c);
		tc3.start();
		
		ThreadP tp1 = new ThreadP(p);
		tp1.start();
		ThreadP tp2 = new ThreadP(p);
		tp2.start();
		ThreadP tp3 = new ThreadP(p);
		tp3.start();
	}
}
