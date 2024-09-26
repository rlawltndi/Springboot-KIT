package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//http 응답으로 사용할 DTO

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
	//TodoDtO 뿐만 아니라 이후 다른 모델의 DTO도 ResponseDTO 
	//사용해 반환할 수 있도록 제네릭 이용
	private String error;
	private List<T> data;
}
