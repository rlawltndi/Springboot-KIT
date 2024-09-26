package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // http 관련 코드 및 요청,응답 메핑을 스프링이 알아서 해준다.
//@RequestMapping("test")// test=리소스 부분  localhost:9090/test로 접속을 시도하면 이 컨트롤러로 요청이 들어온다.
public class TestController {

	@GetMapping("/testGetMapping") // get요청으로 들어오면 아래의 메서드를 실행
	public String testController() {
		return "Hello World";
	}

	@PostMapping // POST요청이 들어왔을 때 실행
	public String testController2() {
		return "Hello World";
	}

	@PutMapping
	public String testController3() {
		return "Hello World";
	}

	@DeleteMapping
	public String testController4() {
		return "Hello World";
	}
}
