package com.korea.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.korea.user.dto.UserDTO;
import com.korea.user.model.UserEntity;
import com.korea.user.persistence.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository repository;

	// 사용자 생성
	// 컨트롤러로부터 이름과 이메일이 담겨있는 Entity를 넘겨받는다
	// db에 추가를 한 후 추가가 잘 됐는지 조회를 한 데이터를 컨트롤러로 넘겨야한다.
	public List<UserDTO> create(UserEntity entity) {
		repository.save(entity); // 데이터베이스에 저장
		// List<UserEntity> -> List<UserDTO>로 변환
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}

	// 모든 사용자 조회
	public List<UserDTO> getAllUsers() {
		return repository.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
	}

	// 이메일을 통한 사용자 검색
	public UserDTO getUserByEmail(String email) {
		UserEntity entity = repository.findByEamil(email);
		return new UserDTO(entity);
	}

	// ID를 통한 이름과 이메일 수정하기
	public List<UserDTO> updateUser(UserEntity entity) {
		// id를 통해서 db에 저장되어있는 객체를 찾는다.
		Optional<UserEntity> original = repository.findById(entity.getId());
		original.ifPresent(userEntity -> {
			// 이름과 이메일을 객체에 setting한다.
			userEntity.setName(entity.getName());
			userEntity.setEmail(entity.getEmail());

			// 업데이트된 사용자 정보 저장
			repository.save(userEntity);
		});
		return getAllUsers();

	}

	// ID를 가지고 유저를 삭제하는 API만들기
	public boolean delteUser(int id) {
		// id를 통해 유저가 존재하는지 확인
		Optional<UserEntity> exisit = repository.findById(id);

		if (exisit.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
