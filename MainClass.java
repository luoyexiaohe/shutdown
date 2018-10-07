package com.hfy.util;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class MainClass {
	public static void main(String[] args) throws Exception {
		ServerSocket server = new ServerSocket(9091); //������9091�˿�
		Socket sock = null;
		InputStream in = null;
		outterLoop: while(true) {
		    sock = server.accept(); //����һ����ͻ�����socket
		    in = sock.getInputStream();
		    int len = 0;
		    byte buffer[] = new byte[1024]; //������
		    while((len=in.read(buffer))>-1){ //���绺����������
		    	String code = null;
		        System.out.println(code = new String(buffer).trim());
		        if("-1".equals(code)) {//�ر��Զ��ػ�����
		        	break outterLoop;
		        }
		        if("0".equals(code)) {//���̹رյ�ǰ����
		        	Runtime.getRuntime().exec("Shutdown -s -t 0");
		        }
		        if("+0".equals(code)) {//ȡ���ػ�
		        	Runtime.getRuntime().exec("Shutdown -a");
		        }
		        if("-0".equals(code)) {//��������
		        	Runtime.getRuntime().exec("Shutdown -r -t 0");
		        }
		        if("1800".equals(code)) {//��ʱ�ػ�
		        	Runtime.getRuntime().exec("Shutdown -s -t 1800");
		        }
		    }
		}

	    in.close();
	    sock.close();
	    server.close();
	}
}
