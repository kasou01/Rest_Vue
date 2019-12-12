package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.model.UserInfo;
import com.example.demo.service.CustomerSharedService;

/**
 * UserDetailsServiceの実装クラス
 * Spring Securityでのユーザー認証に使用する
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    CustomerSharedService customerSharedService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo userInfo = customerSharedService.findOne(username);
		if(userInfo == null)
			throw new UsernameNotFoundException("user not found");
		return new CustomUserDetails(userInfo);
	}

}
