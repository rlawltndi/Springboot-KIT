package com.korea.user.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.korea.user.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByEamil(String email);

}
