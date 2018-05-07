package com.compare;

import java.util.ArrayList;
import java.util.List;

public class ComparePerson {

	public static void main(String[] args) {
		
		Person p1 = new Person("Santosh","Kumar",30);
		Person p2 = new Person("Santhi","Kiran",29);
		Person p3 = new Person("Appa","Rao", 59);
		List<Person> personList = new ArrayList<>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		Comparator<Person> c = Comparator.comparing(p -> p.getAge());
		Comparator<Person> comparator = Comparator.comparing(Person::getAge)
												.thenCompare(p -> p.getLastName())
												.thenCompare(p -> p.getFirstName());
		//personList.sort(comparator);
		Person[] personArray = personList.toArray(new Person[personList.size()]);
		System.out.println(personArray.length);
		System.out.println(personArray[0].getLastName());

	}

}

