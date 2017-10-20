package com.piped.charT;

import java.io.PipedReader;
import java.io.PipedWriter;

public class DataMethod {

	public void writeMethod(PipedWriter out) {
		try {
			System.out.println("write:");
			for (int i = 0; i < 100; i++) {
				String outData = "" + i;
				out.write(outData);
				System.out.print(outData);
			}
			System.out.println();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readMethod(PipedReader in) {
		try {
			System.out.println("read:");
			char[] byteArr = new char[20];
			int length = in.read(byteArr);
			while(length != -1) {
				String newData = new String(byteArr, 0, length);
				System.out.println(newData);
				length = in.read(byteArr);
			}
			System.out.println();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
