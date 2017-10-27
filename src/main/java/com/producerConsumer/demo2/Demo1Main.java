package com.producerConsumer.demo2;

public class Demo1Main {
	
	public static void main(String[] args) {
		
		Resource resource = new Resource();
		
		ConsumerThread consumerThread = new ConsumerThread(resource);
		Thread tc = new Thread(consumerThread);
		tc.start();
		
		ProducerThread producerThread = new ProducerThread(resource);
		Thread tp = new Thread(producerThread);
		tp.start();
	}

}
