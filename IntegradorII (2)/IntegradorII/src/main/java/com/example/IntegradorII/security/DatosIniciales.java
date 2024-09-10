package com.example.IntegradorII.security;

import com.example.IntegradorII.entity.Usuario;
import com.example.IntegradorII.entity.UsuarioRol;
import com.example.IntegradorII.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passCifrado = bCryptPasswordEncoder.encode("admin");
        Usuario usuario = new Usuario("Joel","JoelUsuario",passCifrado,"joelhuenupi@gmail.com", UsuarioRol.ROLE_USER);
        usuarioRepository.save(usuario);
    }
}