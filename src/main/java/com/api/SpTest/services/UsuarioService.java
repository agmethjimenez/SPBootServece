package com.api.SpTest.services;

import com.api.SpTest.entity.Usuario;
import com.api.SpTest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UsuarioService {
    @Autowired
    UsuarioRepository UserRepository;

    public List<Usuario> getUsuarios(){
        return UserRepository.findAll();
    }

    public Optional<Usuario> getUsuario(Long id){
        return UserRepository.findById(id);
    }

    public void guardarOactualizar(Usuario usuario){
        UserRepository.save(usuario);
    }

    public void borrarUsuario(Long id){
        UserRepository.deleteById(id);
    }
}
