package com.api.SpTest.services;

import com.api.SpTest.entity.Noticia;
import com.api.SpTest.entity.Usuario;
import com.api.SpTest.repository.NoticiaRepository;
import com.api.SpTest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;
    private UsuarioRepository usuarioRepository;

    public Noticia crearNoticia(Noticia noticia) {

        return noticiaRepository.save(noticia);
    }

    public List<Noticia> obtenerTodasLasNoticias() {
        return noticiaRepository.findAll();
    }

    // Buscar una noticia por ID
    public Noticia obtenerNoticiaPorId(String id) {
        return noticiaRepository.findById(id).orElse(null); // O lanzar una excepción
    }

    // Eliminar una noticia por ID
    public void eliminarNoticia(String id) {
        noticiaRepository.deleteById(id);
    }
}

