package com.cathaybk.practice.CollectionsAndMap;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapPractice {

	public static void main(String[] args) {
		// 排序根據 key值排
		// 1.原始型態
		TreeMap<String, String> tMap = new TreeMap<>();
		tMap.put("a", "res");
		tMap.put("b", "sfd");
		tMap.put("v", "ad");
		tMap.put("c", "as");
		for (String k : tMap.keySet()) {
			System.out.println("key: " + k + "\n" + "value: " + tMap.get(k));
		}
		// 2.物件型態
		Map<Person, Integer> map = new TreeMap<>(new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.name.compareTo(p2.name);
			}
		});
		map.put(new Person("Tom"), 1);
		map.put(new Person("Bob"), 2);
		map.put(new Person("Lily"), 3);
		for (Person key : map.keySet()) {
			System.out.println(key);
		}

	}

}

class Person {
	public String name;

	Person(String name) {
		this.name = name;
	}

	public String toString() {
		return "{Person: " + name + "}";
	}
}
