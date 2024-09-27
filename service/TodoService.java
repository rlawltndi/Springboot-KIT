package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.presistence.TodoRepository;

import lombok.RequiredArgsConstructor;

//@Component 어노테이션으 붙은 클래스는 Bean(스프링 객체)으로 만들어준다.
//@Service 컴포넌트는 @Component의 자식 컴포넌트
//스프링이 @Service도 찾아서 Bean으로 만들어준다.

//@Component의 자식 컴포넌트 종류
//@Service
//@Repository
//@Controller
//@RestController
//컴포넌트를 구분함으로써 클래스의 용도를 좀 더 구체적으로 구분
@Service // 이 클래스가 서비스컴포넌트임을 명시
@RequiredArgsConstructor
public class TodoService {

	// TodoRepository 생성자 주입하기
	private final TodoRepository repository;

	// 메서드형태로 비즈니스 로직을 구현
	public String testService() {
		// TodoEntity 생성하기
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		//TodoEntity 저장
		//save() : insert
		repository.save(entity);
		//todoentity 검색
		//findById(entity.getId()) 기본키를 이용해 db에 저장된 TodoEntity찾기
		TodoEntity saveedEntity = repository.findById(entity.getId()).get();
		return saveedEntity.getTitle();
	}











}
