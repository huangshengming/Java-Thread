package com.piped.charT;

import java.io.PipedWriter;

public class ThreadWrite extends Thread {

	private DataMethod dataMethod;
	private  PipedWriter out;
	
	public ThreadWrite(DataMethod dataMethod, PipedWriter out) {
		super();
		this.dataMethod = dataMethod;
		this.out = out;
	}

	@Override
	public void run() {
		dataMethod.writeMethod(out);
	}
}
