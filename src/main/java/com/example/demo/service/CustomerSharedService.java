package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserInfo;
@Service
public class CustomerSharedService {

	public UserInfo findOne(String username) {
		return new UserInfo("abc", "123123");
	}

}
