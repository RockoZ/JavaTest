package com.test.temp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * @author Mr.Zheng
 * @date 2014年7月10日10:16:23
 */
public class HTTPClient
{
	public static void main(String[] args)
	{
		//确定HTTP请求的uri
		String uri = "index.htm";
		if(0 != args.length)
		{
			uri = args[0];
		}
		
		//按照GET请求方式访问HTTPServer
		doGet("localhost", 8080, uri);
	}

	private static void doGet(String host, int port, String uri)
	{
		Socket socket = null;
		
		try
		{
			socket = new Socket(host, port);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		try
		{
			/*创建HTTP请求*/
			//HTTP请求的第一行
			StringBuffer sb = new StringBuffer("GET " + uri + " HTTP/1.1\r\n");
			//HTTP请求头
			sb.append("Accept: */*\r\n");
			sb.append("Accept-Language: zh-cn\r\n");
			sb.append("Accept-Encoding: gzip, deflate\r\n");
			sb.append("User-Agent: HTTPClient\r\n");
			sb.append("Host: localhost:8080\r\n");
			sb.append("Connection: Keep-Alive\r\n\r\n");
			
			/*发送HTTP请求*/
			OutputStream os = socket.getOutputStream();
			os.write(sb.toString().getBytes());
			//睡眠2秒，等待响应结果
			Thread.sleep(2000);
			
			/*接收响应结果*/
			InputStream is = socket.getInputStream();
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			System.out.println(new String(buffer));
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				socket.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
