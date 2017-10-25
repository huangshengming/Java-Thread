package com.concurrent.forkjoin;

import java.util.concurrent.RecursiveTask;

@SuppressWarnings("serial")
public class CountTask extends RecursiveTask<Integer> {
	
	private static final int THRESHOLD = 2;
	private int start;
	private int end;
	
	public CountTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		int sum = 0;
		//如果任务够小 就计算任务
		boolean canCompute = (end - start) <= THRESHOLD;
		if(canCompute) {
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		}else {
			//如果任务大于阀值 分裂任务
			int middle = (start + end) / 2;
			CountTask leftTask = new CountTask(start, middle);
			CountTask rightTask = new CountTask(middle + 1, end);
			//分裂任务
			leftTask.fork();
			rightTask.fork();
			//合并任务
			int leftResult = leftTask.join();
			int rightResult = rightTask.join();
			sum = leftResult + rightResult;
		}
		return sum;
	}
}
