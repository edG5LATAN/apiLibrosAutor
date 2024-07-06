package com.example.num1.infra.security;

import com.example.num1.domain.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FilterConfiguration extends OncePerRequestFilter {

    @Autowired
    private TokenServices tokenServices;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var autToken=request.getHeader("Authorization");
        if(autToken!=null){
            var token=autToken.replace("Bearer ","");
            var subject=tokenServices.getSubject(token);
            if(subject!=null){
               var usuario= usuarioRepository.findByLogin(subject);
               var autenticar= new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(autenticar);
            }
        }
        filterChain.doFilter(request,response);
    }
}
