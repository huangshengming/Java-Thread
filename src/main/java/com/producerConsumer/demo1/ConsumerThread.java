package com.producerConsumer.demo1;

public class ConsumerThread implements Runnable {
	
	private Resource resource;
	
	public ConsumerThread(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			resource.pop();
		}
	}
}
