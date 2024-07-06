package com.example.num1.controller;

import com.example.num1.domain.model.usuario.DatosUsuario;
import com.example.num1.domain.model.usuario.Usuario;
import com.example.num1.infra.security.DataToken;
import com.example.num1.infra.security.TokenServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServices tokenServices;


    @PostMapping
    public ResponseEntity loguearse(@RequestBody @Valid DatosUsuario datosUsuario){
        Authentication autToken=new UsernamePasswordAuthenticationToken(datosUsuario.login(),datosUsuario.clave());
        var usuario=authenticationManager.authenticate(autToken);
        var token = tokenServices.getToken((Usuario) usuario.getPrincipal());
        return ResponseEntity.ok(new DataToken(token));
    }


}
