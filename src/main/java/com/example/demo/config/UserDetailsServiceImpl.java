package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.model.UserInfo;
import com.example.demo.service.CustomerSharedService;

/**
 * UserDetailsService�̎����N���X
 * Spring Security�ł̃��[�U�[�F�؂Ɏg�p����
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
