package com.spring.first;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		// 인터페이스 
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"classpath:META-INF/spring.xml");
		
		/*
			(xml에 적은 id, 리턴타입) 리턴타입을 형변환 형식으로 적을 수 있다
		 */
		MiTv tv1 = ctx.getBean("mitv", MiTv.class);
		tv1.volumeUp();
	}
}
