package com.test.temp;

public class B {
	static {
		System.out.println("静态方法快");
	}
	private A a = new A();

	public B() {
		System.out.println("B的构造器");
	}

	public static void method() {
		System.out.println("B的静态方法");
	}
}
