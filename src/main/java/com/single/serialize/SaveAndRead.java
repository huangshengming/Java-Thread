package com.single.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveAndRead {

	public static void main(String[] args) {
		try {
			MyObject myObject = MyObject.getInstance();
			FileOutputStream fosRef = new FileOutputStream(new File("/Users/xingwuzhao/MyObject.txt"));
			ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
			oosRef.writeObject(myObject);
			oosRef.close();
			fosRef.close();
			System.out.println(myObject.hashCode());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			FileInputStream fisRef = new FileInputStream(new File("/Users/xingwuzhao/MyObject.txt"));
			ObjectInputStream iosRef = new ObjectInputStream(fisRef);
			//此处使用 readResolve 用于 反序列化实体类
			MyObject obj = (MyObject) MyObject.getInstance().readObject();
			iosRef.close();
			fisRef.close();
			System.out.println(obj.hashCode());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
