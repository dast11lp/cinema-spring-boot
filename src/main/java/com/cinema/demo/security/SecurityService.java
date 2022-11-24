package com.cinema.demo.security;

import java.util.ArrayList;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.cinema.demo.entities.MyUser;
import com.cinema.demo.services.MyUserService;

@Service("securityService")
public class SecurityService {

    @Autowired
    private MyUserService myUserService;
    
    Authentication authentication;

        public boolean hasUser(Long idUser) throws Exception{
        	
        System.out.println("hola " + idUser);

        MyUser user = this.myUserService.findById(idUser);
        
        Collection<GrantedAuthority>  authoritiesUser = new ArrayList<GrantedAuthority>();
        
        for (com.cinema.demo.entities.Role role: user.getRoles()) {
			authoritiesUser.add(new SimpleGrantedAuthority(role.getAuthority()));
		}
		
		Collection<GrantedAuthority> authoritiesContext = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		for(GrantedAuthority authority: authoritiesUser) {
			if(authoritiesContext.contains(authority)) {
				return true;
			}
			break;
		}
        

        return false;  
    }
}
