package com.java.test.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * 
 * @author Mr.Zheng
 * 
 */
public class MatcherTest
{

	public static void main(String[] args)
	{
		// String str = "Hello Matcher 001";
		// Pattern pattern = Pattern.compile("\\d+");
		// Matcher matcher = pattern.matcher(str);
		// while(matcher.find())
		// {
		// System.out.println(matcher.group() + "-" + matcher.start() + "-" +
		// matcher.end());
		// }

		String[] mails = new String[]
		{ "zhengxiaopeng@ifeng.cn", "657839332@qq.com", "adadaw@sd.xx", "242997sdda@163.com" };
		String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|gov|cn)";// "\\w+@\\w+\\.(com|org|gov|cn)";
		Matcher matcher = null;
		Pattern pattern = Pattern.compile(mailRegEx);
		for (String mail : mails)
		{
			if (matcher == null)
			{
				matcher = pattern.matcher(mail);
			} else
			{
				matcher.reset(mail);
			}

			if (matcher.matches())
			{
				System.out.println(mail + " -->是一个有效的邮件地址");
			} else
			{
				System.out.println(mail + " -->不是一个有效的邮件地址");
			}
		}
	}

}
