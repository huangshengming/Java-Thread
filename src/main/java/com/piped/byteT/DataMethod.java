package com.piped.byteT;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class DataMethod {

	public void writeMethod(PipedOutputStream out) {
		try {
			System.out.println("write:");
			for (int i = 0; i < 100; i++) {
				String outData = "" + i;
				out.write(outData.getBytes());
				System.out.print(outData);
			}
			System.out.println();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
	
	public void readMethod(PipedInputStream in) {
		try {
			System.out.println("read:");
			byte[] byteArr = new byte[20];
			int length = in.read(byteArr);
			while(length != -1) {
				String newData = new String(byteArr, 0, length);
				System.out.println(newData);
				length = in.read(byteArr);
			}
			System.out.println();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}
}
