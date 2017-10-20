package com.piped.byteT;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Run {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		DataMethod dataMethod = new DataMethod();
		
		PipedInputStream in = new PipedInputStream();
		PipedOutputStream out = new PipedOutputStream();
		
		out.connect(in);
		
		ThreadRead read = new ThreadRead(dataMethod, in);
		ThreadWrite write = new ThreadWrite(dataMethod, out);
		
		read.start();
		
		Thread.sleep(2000);
		write.start();
	}
}
