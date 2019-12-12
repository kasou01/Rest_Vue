package com.example.demo.config;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.demo.model.UserInfo;

/**
 * 
 *�F�؏��ȊO��user�����ێ�����CustomUserDetails�N���X���쐬����B
 */
public class CustomUserDetails extends User {
	// �F�؏�񂨂��user��������DomainObject�N���X��ێ�����B
	private final UserInfo userInfo;

	// �F�����Aorg.springframework.security.core.authority.SimpleGrantedAuthority�̃R���X�g���N�^�ō쐬����B�����ł́hROLE_USER�h�Ƃ���������^����B
	//�{�����͊ȈՎ����ł���A�{���͔F����DB��̕ʂ̃e�[�u������擾���ׂ��ł���B
	private static final List<? extends GrantedAuthority> DEFAULT_AUTHORITIES = Collections
			.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	
	//�X�[�p�[�N���X�̃R���X�g���N�^�ɁADomainObject�������[�UID�A�p�X���[�h��ݒ肷��B
	public CustomUserDetails(UserInfo userInfo) {
		
        super(userInfo.getUsername(),
        		userInfo.getPassword(), true, true, true, true, DEFAULT_AUTHORITIES); 
        
        this.userInfo = userInfo;
    }
	
	public UserInfo getUserInfo() { // (5)
        return userInfo;
    }


}
