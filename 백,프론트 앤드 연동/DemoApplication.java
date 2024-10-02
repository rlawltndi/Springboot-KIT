package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@Comfiguration : 해당클래스가 설정파일임을 알려주는 어노테이션
//@ComponentScan : 저동으로 컴포넌트 어노테이션이 붙은 클래스를 검색하여 bean(스프링 객체)을 등록한다.
//@EnableAutoConfiguration : 스프링의 다양한 설정이 자동으로 구성되고 완료된다.
public class DemoApplication {

	public static void main(String[] args) {//메인이 서버를 작동시킴
		SpringApplication.run(DemoApplication.class, args);
	}

}
