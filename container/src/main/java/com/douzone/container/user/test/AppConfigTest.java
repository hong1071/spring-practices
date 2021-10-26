package com.douzone.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.config.user.AppConfig01;
import com.douzone.container.user.User;

public class AppConfigTest {

	public static void main(String[] args) {
		
		testAppConfig01();
		testAppConfig02();
	}
	
	// Java Config 01
	// 직접 자바클라스(config class)를 전달
	// 설정 클래스에 @Configueation가 반드시 필요하지 않음(있어도 무관)
	private static void testAppConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);
		
		User user = ac.getBean(User.class);
		System.out.println(user);
	}
	
	// Java Config 02
	// 자바 설정 클래스가 있는 베이스 패키지를 전달
	// 설정 클래스에 @Configuration가 반드시 필요
	private static void testAppConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.douzone.container.config.User");
		
		User user = ac.getBean(User.class);
		System.out.println(user);
	}


}
