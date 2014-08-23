package com.java.test_1;

import java.math.BigDecimal;

/**
 * 浮点数计算问题
 * 
 * @author Mr.Zheng
 * @date 2014年6月30日23:56:50
 */
public class FloatingNumCalTest
{
	public static void main(String[] args)
	{
		FloatingNumCalTest test = new FloatingNumCalTest();
		test.general();
		test.decimalFormat();
		test.bigDecimal();
	}

	/**
	 * 普通方法
	 */
	private void general()
	{
		System.out.println("----------general--------------------");
		System.out.println(0.05 + 0.01);
		System.out.println(1.0 - 0.42);
		System.out.println(4.015 * 100);
		System.out.println(123.3 / 100);
		double i = 0.2, j = 0.3;
		System.out.println(i + j);
		j = 0.3f;
		System.out.println(i + j);
	}

	/**
	 * 使用使用java.text.DecimalFormat格式化浮点数 <br>
	 * 这是因为DecimalFormat是使用half-even
	 * 舍入（ROUND_HALF_EVEN），简单的说就是向当四舍五入的5的时候向最近的偶数靠
	 * 。所以使用DecimalForamt也无法得到可靠的浮点数。
	 */
	private void decimalFormat()
	{
		System.out.println("----------decimalFormat--------------------");
		System.out.println(new java.text.DecimalFormat("0.00").format(3.125));
		System.out.println(new java.text.DecimalFormat("0.00").format(3.135));
	}

	/**
	 * 使用BigDecimal <br>
	 * 我们最终需要使用String来创建对象，这样得到的结果才是最精确的
	 */
	private void bigDecimal()
	{
		System.out.println("----------bigDecimal--------------------");
		BigDecimal bd1 = new BigDecimal(0.05);
		System.out.println(bd1.toString());
		BigDecimal bd2 = new BigDecimal("0.05");
		bd2 = bd2.add(new BigDecimal("0.01"));
		System.out.println(bd2.toString());
	}
}
