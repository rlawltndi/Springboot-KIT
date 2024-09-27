package com.example.demo.di4;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Component
@Getter
@RequiredArgsConstructor
public class Coding {
	
	//final 이나 NonNull붙히고
	private final Computer computer;

}
