package com.tim.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Factory {
	public static <K, V> HashMap<K, V> newInstance(){
		return new HashMap<K, V>();
	}
	
	public static void main(String[] args) {
		Map<String, List<DBDemo>> map = Factory.newInstance();
		Map<Integer, String> map3 = Factory.newInstance();
	}
}
