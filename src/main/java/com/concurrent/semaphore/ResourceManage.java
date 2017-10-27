package com.concurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ResourceManage {
	
	int resources = 5;
	//定义厕所状态
	private boolean resourceArray[];
	//定义厕所
	private Semaphore semaphore;
	private ReentrantLock lock;
	
	public ResourceManage() {
		resourceArray = new boolean[resources];
		semaphore = new Semaphore(resources, true);
		lock = new ReentrantLock(true);
		//定义厕所状态为可用
		for (int i = 0; i < resources; i++) {
			resourceArray[i] = true;
		}
	}
	
	public void useResource(int userid) {
		try {
			semaphore.acquire();
			int id = this.getResourceId();
			System.out.println("用户：" + userid + ",正在使用：" + id + "号厕所");
			//模拟占用资源
			Thread.sleep(1000);
			//使用完成
			resourceArray[id] = true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			semaphore.release();
			System.out.println("用户：" + userid + "使用资源完毕");
		}
	}
	
	private int getResourceId() {
		int id = -1;
		lock.lock();
		try {
			for (int i = 0; i < resources; i++) {
				if(resourceArray[i]) {
					resourceArray[i] = false;
					id = i;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
		return id;
	}
}
