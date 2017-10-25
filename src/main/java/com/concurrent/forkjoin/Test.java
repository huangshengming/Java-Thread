package com.concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Test {
	
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		//计算 1到100 的和
		CountTask task = new CountTask(1, 100);
		ForkJoinTask<Integer> rv = forkJoinPool.submit(task);
		try {
			System.out.println(rv.get());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
