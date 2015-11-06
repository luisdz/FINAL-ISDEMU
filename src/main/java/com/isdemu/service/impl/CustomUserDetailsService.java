/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isdemu.service.impl;

import com.isdemu.model.TbsRol;
import com.isdemu.model.TbsUsuario;
import com.isdemu.service.TBS_Rol_Service;
import com.isdemu.service.TBS_Usuario_Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jose Eduardo
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired 
    private TBS_Usuario_Service userService;
    
    @Autowired 
    private TBS_Rol_Service rolService;
    
    @Transactional(readOnly=true)
    @SuppressWarnings("empty-statement")
    public UserDetails loadUserByUsername(String username) 
		
		throws UsernameNotFoundException {
		TbsUsuario user = new TbsUsuario();
                  
                
                try {
                    
                    user = (TbsUsuario)(userService.findByNick(username).get(0));
                }
                catch(Exception e) 
                {
                   System.out.println("Usuario no encontrado");
                };
                  //TbsUsuario user = new TbsUsuario();
		System.out.println("User : "+user);
		if(username==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(user.getNombreUsuario(), user.getClave(), 
				 true, true, true, true, getGrantedAuthorities(user));
	}
    
    private List<GrantedAuthority> getGrantedAuthorities(TbsUsuario user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
			authorities.add(new SimpleGrantedAuthority("ADMIN"));
		
		System.out.print("authorities :"+authorities);
		return authorities;
    }
    
    
}
