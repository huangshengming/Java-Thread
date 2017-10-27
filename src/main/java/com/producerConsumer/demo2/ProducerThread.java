package com.producerConsumer.demo2;

public class ProducerThread implements Runnable {
	
	private Resource resource;
	
	public ProducerThread(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			resource.push();
		}
	}
}
