package com.example.demo.qualifier;

import org.springframework.stereotype.Component;

//노트북
@Component
public class Laptop implements Computer {

	@Override
	public int getScreenWidth() {
		// TODO Auto-generated method stub
		return 1920;
	}
}
