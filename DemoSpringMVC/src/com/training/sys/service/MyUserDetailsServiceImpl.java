package com.training.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.training.model.MyUserDetails;

@Service("MyUserDetailsServiceImpl")
public class MyUserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(!"admin".equalsIgnoreCase(email)) throw new UsernameNotFoundException("User name not found");  
        String password = "$2y$12$aoAmKFESBXg23t.pcs4eSOmhp2TOlhM4A6BJDRfCIT6m0bI5Wc71m"; // admin  
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        authorities.add(authority);
        UserDetails userDetail = new MyUserDetails(email, password, authorities); 
        System.out.println( "pass:" + password);
        return userDetail;
	}
}
