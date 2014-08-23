package com.test.temp;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Mr.Zheng
 * @date 2014年7月10日09:36:10
 */
public class HTTPServer
{
	public static void main(String[] args)
	{
		int port;
		ServerSocket serverSocket;
		try
		{
//			port = Integer.parseInt(args[0]);
			port = 8080;
		} catch (Exception e)
		{
			System.out.println("port = 8080（默认）");
			// 默认端口8080
			port = 8080;
			e.printStackTrace();
		}

		try
		{
			serverSocket = new ServerSocket(port);
			System.out.println("服务器正在监听端口：" + serverSocket.getLocalPort());
			// 服务器在一个无限循环中不断接收来自客户端的TCP连接请求
			while (true)
			{
				try
				{
					// 等待客户端的TCP连接请求
					final Socket socket = serverSocket.accept();
					System.out.println("建立了与客户端的一个新的TCP连接，该客户端地址为：" + socket.getInetAddress() + ": " + socket.getPort());
					service(socket);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 响应客户端请求
	 * 
	 * @param socket
	 */
	private static void service(Socket socket) throws Exception
	{
		/* 读取http请求信息 */
		InputStream socketIs = socket.getInputStream();
		Thread.sleep(500);
		int size = socketIs.available();
		byte[] buffer = new byte[size];
		socketIs.read(buffer);
		String request = new String(buffer);
		System.out.println(request);

		/* 解析HTTP请求 */
		// 获得HTTP请求的第一行
		String firstLineOfRequest = request.substring(0, request.indexOf("\r\n"));
		// 解析HTTp请求的第一行
		String[] parts = firstLineOfRequest.split(" ");
		// 获得HTTP请求的uri
		String uri = parts[1];

		/* 决定HTTP响应正文的类型，此处做了简化处理 */
		String contentType;
		if (-1 != uri.indexOf("html") || -1 != uri.indexOf("htm"))
		{
			contentType = "text/html";
		} else if (-1 != uri.indexOf("jpg") || -1 != uri.indexOf("jpge"))
		{
			contentType = "image/jpge";
		} else if (-1 != uri.indexOf("gif"))
		{
			contentType = "image/gif";
		} else
		{
			contentType = "application/octet-stream";
		}

		/* 创建HTTP响应结果 */
		// 响应的第一行
		String responseFirstLine = "HTTP/1.1 200 OK\r\n";
		// 响应头
		String responseHeader = "Content-Type:" + contentType + "\r\n\r\n";
		// 获得读取响应正文数据的输入流
		InputStream is = new FileInputStream("root/hello.htm");	//命令行能访问，root文件夹放在此bin文件所在目录
						//HTTPServer.class.getResourceAsStream("root/" + uri); //浏览器能访问，root文件夹放在此class文件所在目录

		/* 发送HTTP响应结果 */
		//获得输出流
		OutputStream socketOs = socket.getOutputStream();
		//发送HTTP响应的第一行
		socketOs.write(responseFirstLine.getBytes());
		//发送响应头
		socketOs.write(responseHeader.getBytes());
		//发送HTTP响应的正文
		int len = 0;
		buffer = new byte[128];
		while(-1 != (len = is.read(buffer)))
		{
			socketOs.write(buffer, 0, len);
		}
		
		//睡眠一秒，等待客户端接收HTTP响应结果
		Thread.sleep(1000);
		socket.close();
	}
}
