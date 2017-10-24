package com.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
	
	//线程池最大数量
	private static final int MAX_WORKER_NUMBER = 10;
	//线程池默认数量
	private static final int DEFAULT_WORKER_NUMBER = 5;
	//线程池最小数量
	private static final int MIN_WORKER_NUMBER = 1;
	//工作列表
	private final LinkedList<Job> jobs = new LinkedList<>();
	//工作者列表
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
	//工作者线程数量
	private  int workerNum = DEFAULT_WORKER_NUMBER;
	//线程编号生成
	private AtomicLong threadNum = new AtomicLong();
	
	public DefaultThreadPool() {
		initializeWorkers(DEFAULT_WORKER_NUMBER);
	}
	
	public DefaultThreadPool(int num) {
		workerNum = num > MAX_WORKER_NUMBER ? MAX_WORKER_NUMBER : num < MIN_WORKER_NUMBER ? MIN_WORKER_NUMBER : num;
		initializeWorkers(workerNum);
	}
	
	private void initializeWorkers(int num) {
		for (int i = 0; i < num; i++) {
			Worker worker = new Worker();
			workers.add(worker);
			Thread thread = new Thread(worker, "threadPool-worker-" + threadNum.incrementAndGet());
			thread.start();
		}
	}

	@Override
	public void execute(Job job) {
		if(job != null) {
			synchronized (jobs) {
				jobs.addLast(job);
				jobs.notify();
			}
		}
	}

	@Override
	public void shuntdown() {
		for (Worker worker : workers) {
			worker.shundown();
		}
	}

	@Override
	public void addWorkers(int num) {
		synchronized (jobs) {
			if(num + this.workerNum > MAX_WORKER_NUMBER) {
				num = MAX_WORKER_NUMBER - this.workerNum;
			}
			initializeWorkers(num);
			this.workerNum += num;
		}
	}

	@Override
	public void removeWorkers(int num) {
		synchronized (jobs) {
			if(num >= this.workerNum) {
				throw new IllegalArgumentException("beyond worknum");
			}
			int count = 0;
			while(count < num) {
				Worker worker = workers.get(count);
				if(workers.remove(worker)) {
					worker.shundown();
					count++;
				}
			}
			this.workerNum -= count;
		}
	}

	@Override
	public int getJobSize() {
		return jobs.size();
	}
	
	class Worker implements Runnable {
		
		private volatile boolean running = true;

		@Override
		public void run() {
			while(running) {
				Job job = null;
				synchronized (jobs) {
					while(jobs.isEmpty()) {
						try {
							jobs.wait();
						} catch (Exception e) {
							Thread.currentThread().interrupt();
							return;
						}
					}
					job = jobs.removeFirst();
				}
				if(job != null) {
					try {
						job.run();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}

		public void shundown() {
			running = false;
		}
	}
}
