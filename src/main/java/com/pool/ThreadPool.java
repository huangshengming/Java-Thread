package com.pool;

public interface ThreadPool<Job extends Runnable> {

	public void execute(Job job);
	
	public void shuntdown();
	
	//增加工作线程
	public void addWorkers(int num);
	
	//减少工作线程
	public void removeWorkers(int num);

	// 得到正在运行的线程数量
	public int getJobSize();
}
