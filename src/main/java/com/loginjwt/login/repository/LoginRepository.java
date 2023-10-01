package com.loginjwt.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.loginjwt.login.model.LoginUsuario;

public interface LoginRepository extends JpaRepository<LoginUsuario, Long>{
    
    UserDetails findByLogin(String login);
    
}
