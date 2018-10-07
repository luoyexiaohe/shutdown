package com.hfy.util;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class MainClass {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9091); //监听在9091端口
		Socket sock = null;
		InputStream in = null;
		outterLoop: while(true) {
		    sock = server.accept(); //建立一个与客户机的socket
		    in = sock.getInputStream();
		    int len = 0;
		    byte buffer[] = new byte[1024]; //缓冲区
		    while((len=in.read(buffer))>-1){ //假如缓冲区有数据
		    	String code = null;
		        System.out.println(code = new String(buffer).trim());
		        if("-1".equals(code)) {//关闭自动关机程序
		        	break outterLoop;
		        }
		        if("0".equals(code)) {//立刻关闭当前程序
		        	Runtime.getRuntime().exec("Shutdown -s -t 0");
		        }
		        if("+0".equals(code)) {//取消关机
		        	Runtime.getRuntime().exec("Shutdown -a");
		        }
		        if("-0".equals(code)) {//重启电脑
		        	Runtime.getRuntime().exec("Shutdown -r -t 0");
		        }
		        if("1800".equals(code)) {//延时关机
		        	Runtime.getRuntime().exec("Shutdown -s -t 1800");
		        }
		    }
		}

	    in.close();
	    sock.close();
	    server.close();
	}
}
