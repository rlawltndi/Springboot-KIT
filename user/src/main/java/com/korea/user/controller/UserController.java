package com.korea.user.controller;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.korea.user.dto.UserDTO;
import com.korea.user.model.UserEntity;
import com.korea.user.service.UserService;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;

	// 유저 생성
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserDTO dto) {
		// 서비스로 보내기위해서 DTO -> Entity로 변경
		UserEntity entity = UserDTO.toEntity(dto);
		List<UserDTO> users = service.create(entity);
		return ResponseEntity.ok().body(users);

	}

	// 모든 유저 조회하기
	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		List<UserDTO> users = service.getAllUsers();
		return ResponseEntity.ok().body(users);
	}

	// 이메일을 통한 사용자 검색
	@GetMapping("/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable String email) {
		UserDTO user = service.getUserByEmail(email);
		return ResponseEntity.ok(user);
	}

	// Id를 통한 이름과 이메일 수정
	@PutMapping
	public ResponseEntity<?> updateUser(@RequestBody UserDTO dto) {
		UserEntity entity = UserDTO.toEntity(dto);
		List<UserDTO> updateUser = service.updateUser(entity);
		return ResponseEntity.ok(updateUser);

	}

	// ID를 가지고 유저를 삭제하는 API만들기
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		boolean isDeleted = service.delteUser(id);
		if (isDeleted) {
			return ResponseEntity.ok("User deleted successfully");
		}
		return ResponseEntity.status(404).body("User not found with id" + id);
	}

}
