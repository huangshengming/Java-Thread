package com.concurrent.semaphore;

public class ResourceUser implements Runnable {

	private ResourceManage resourceManage;
	private int userid;

	public ResourceUser(ResourceManage resourceManage, int userid) {
		super();
		this.resourceManage = resourceManage;
		this.userid = userid;
	}

	@Override
	public void run() {
		resourceManage.useResource(userid);
	}
}
