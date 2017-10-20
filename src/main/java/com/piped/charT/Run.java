package com.piped.charT;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Run {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		DataMethod dataMethod = new DataMethod();
		
		PipedReader in = new PipedReader();
		PipedWriter out = new PipedWriter();
		
		out.connect(in);
		
		ThreadRead read = new ThreadRead(dataMethod, in);
		ThreadWrite write = new ThreadWrite(dataMethod, out);
		
		read.start();
		
		Thread.sleep(2000);
		write.start();
	}
}
