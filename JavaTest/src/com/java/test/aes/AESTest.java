package com.java.test.aes;

import java.io.UnsupportedEncodingException;

public class AESTest
{
	public static void main(String[] args) throws UnsupportedEncodingException
	{
		String source = "zxp";
		byte[] byteE = AESUtils.encryptData(source.getBytes("UTF-8"), "1111111111111111");
		System.out.println("加密后： " + AESUtils.byte2hex(byteE));
		byte[] byteD = AESUtils.decryptData(byteE, "1111111111111111");
		System.out.println("解密后： " + new String(byteD));
	}
}
