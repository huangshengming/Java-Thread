package com.producerConsumer.demo3;

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
