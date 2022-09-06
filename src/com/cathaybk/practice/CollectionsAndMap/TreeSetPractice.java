package com.cathaybk.practice.CollectionsAndMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetPractice {

	public static void main(String[] args) {
		// 自然排序 放入的元素一定要實作comparable方法
		// 1.基本型別 : String有實作comparable中的compareTo方法
		TreeSet<String> set = new TreeSet<>();
		set.add("a");
		set.add("d");
		set.add("e");
		set.add("b");
		set.add("c");
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// 2.自訂義型別 若沒複寫comparable會報錯
		Student joe = new Student("Joe", 2);
		Student susan = new Student("Susan", 2);
		Student albee = new Student("Albee", 2);
		Student joy = new Student("Joy", 3);
		Student joesu = new Student("Joesu", 4);
		TreeSet<Student> set1 = new TreeSet<>();
		set1.add(joe);
		set1.add(albee);
		set1.add(susan);
		set1.add(joesu);
		set1.add(joy);
		for (Student s : set1) {
			System.out.println("name: " + s.getName() + "\n" + "idNum: " + s.getStudentId());
			System.out.println("=====================");
		}

		// 自訂義比較器，直接在treeSet裡面定義比較器
		Set<Student> set2 = new TreeSet<>(new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				if (o1.studentId != o2.studentId) {
					return o1.studentId - o2.studentId;
				}
				return o1.getName().compareTo(o2.getName());
			}
		});
		set2.add(joe);
		set2.add(albee);
		set2.add(susan);
		set2.add(joesu);
		set2.add(joy);

		for (Student s : set2) {
			System.out.println("name: " + s.getName() + "\n" + "idNum: " + s.getStudentId());
			System.out.println("=====================");
		}

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> list0 = Arrays.asList(7, 8, 9, 10, 11, 12);
		List<Integer> list1 = new ArrayList<>();
		list1.addAll(list);
		System.out.println(list.toString());
		Map<String, String> map = new HashMap<>();

	}

}

class Student implements Comparable<Student> {
	String name;
	Integer studentId;

	public Student(String name, Integer studentId) {
		super();
		this.name = name;
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	// 先比id number再比名子String
	@Override
	public int compareTo(Student o) {
		if (this.studentId != o.studentId) {
			return this.studentId - o.studentId;
		}
		return this.getName().compareTo(o.getName());
	}
}
