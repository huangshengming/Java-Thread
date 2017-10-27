package com.concurrent.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * cyclicBarrier是所有线程都进行等待，直到所有线程都准备好进入await()方法之后，所有线程同时开始执行
 * @author xingwuzhao
 *
 */
public class CyclicBarrireTest {
	
	private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.execute(new Runner(cyclicBarrier, "张三"));
		executorService.execute(new Runner(cyclicBarrier, "李四"));
		executorService.execute(new Runner(cyclicBarrier, "王五"));
		executorService.shutdown();
	}

}
