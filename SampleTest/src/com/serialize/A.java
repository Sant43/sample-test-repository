package com.serialize;

import java.io.Serializable;

public class A {

	int a = 11;
	int b = 11;
	final String str = "Santosh";
	
	public int add() {
		return a+b;
	}
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.add());
	}

}

class B extends A implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2581978087033104294L;
	int a = 14;
	
	public B(int a) {
		this.a = a;
	}
	
	public void print() {
		System.out.println(a);
	}
}
