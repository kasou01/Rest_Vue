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
 *認証情報以外にuser情報も保持するCustomUserDetailsクラスを作成する。
 */
public class CustomUserDetails extends User {
	// 認証情報およびuser情報をもつDomainObjectクラスを保持する。
	private final UserInfo userInfo;

	// 認可情報を、org.springframework.security.core.authority.SimpleGrantedAuthorityのコンストラクタで作成する。ここでは”ROLE_USER”という権限を与える。
	//本実装は簡易実装であり、本来は認可情報はDB上の別のテーブルから取得すべきである。
	private static final List<? extends GrantedAuthority> DEFAULT_AUTHORITIES = Collections
			.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	
	//スーパークラスのコンストラクタに、DomainObjectが持つユーザID、パスワードを設定する。
	public CustomUserDetails(UserInfo userInfo) {
		
        super(userInfo.getUsername(),
        		userInfo.getPassword(), true, true, true, true, DEFAULT_AUTHORITIES); 
        
        this.userInfo = userInfo;
    }
	
	public UserInfo getUserInfo() { // (5)
        return userInfo;
    }


}
