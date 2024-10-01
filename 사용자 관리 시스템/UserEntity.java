package com.korea.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")

public class UserEntity {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	//GenerationType.AUTO
	//id에 들어갈 값을 자동으로 생성해주는 어노테이션
	//H2와 같은 내장 데이터베이스를 사용하는 경우 기본적으로 숫자 값이 증가하는 방식으로 id가 설정
	private int id;
	private String name;
	private String email;

}
