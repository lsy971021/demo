package com.lsy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("1111");
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			while (interfaces.hasMoreElements()) {
				NetworkInterface networkInterface = interfaces.nextElement();
				Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress address = addresses.nextElement();
					if (!address.isLoopbackAddress() && address instanceof Inet4Address) {
						System.out.println("服务器 IP 地址: " + address.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			System.err.println("无法获取服务器 IP 地址");
			e.printStackTrace();
		}
		SpringApplication.run(DemoApplication.class, args);
	}

}
