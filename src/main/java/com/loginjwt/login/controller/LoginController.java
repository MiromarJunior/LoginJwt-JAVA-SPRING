package com.loginjwt.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginjwt.login.model.LoginDTO;
import com.loginjwt.login.model.LoginDTOCreate;
import com.loginjwt.login.model.LoginResponseDTO;
import com.loginjwt.login.model.LoginUsuario;
import com.loginjwt.login.repository.LoginRepository;
import com.loginjwt.login.service.TokenService;

@RestController
@RequestMapping("login")
public class LoginController {
 

    @Autowired
    AuthenticationManager manager;

    @Autowired
    TokenService service;

    @PostMapping("")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO dto){
        var userNamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = this.manager.authenticate(userNamePassword);

        var token = service.generateToken((LoginUsuario)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));


    }
/* 
    @PostMapping("criar")
    public ResponseEntity<LoginUsuario> savEntity(@RequestBody LoginDTOCreate dto){
        String senhaEncrypt = new BCryptPasswordEncoder().encode(dto.password());

        
        LoginUsuario user = new LoginUsuario(dto.login(), senhaEncrypt,dto.role());
        repository.save(user);
        return ResponseEntity.ok().body(user);
    }

*/
    
}
