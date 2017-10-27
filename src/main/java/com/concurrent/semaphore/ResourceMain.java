package com.concurrent.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ResourceMain {

	public static void main(String[] args) {
		ResourceManage resourceManage = new ResourceManage();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new ResourceUser(resourceManage, i));
		}
		executorService.shutdown();
	}

}
