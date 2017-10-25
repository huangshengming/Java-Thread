package com;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class HashT {
	
	public static void main(String[] args) {
		Hashtable<String, String> table = new Hashtable<>();
		table.get("");
		table.put("", "");
		
		Map<String, String> map = new HashMap<>();
		map.put("", "");
		map.get("");
		
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		concurrentHashMap.put("", "");
		concurrentHashMap.get("");
		
		
		LinkedBlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
		blockingQueue.add(0);
		blockingQueue.remove(2);
	}

}
