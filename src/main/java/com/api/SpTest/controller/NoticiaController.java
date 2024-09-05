package com.api.SpTest.controller;

import com.api.SpTest.entity.Noticia;
import com.api.SpTest.services.NoticiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/noticia")
public class NoticiaController
{
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping
    public List<Noticia> getNoticia(){
        return noticiaService.obtenerTodasLasNoticias();
    }

    @PostMapping
    public Noticia crearNoticia(@RequestBody Noticia noticia) {
        return noticiaService.crearNoticia(noticia);
    }

    @GetMapping("/{id}")
    public Noticia obtenerNoticiaPorId(@PathVariable String id) {
        return noticiaService.obtenerNoticiaPorId(id);
    }

    // Endpoint para eliminar una noticia por ID
    @DeleteMapping("/{id}")
    public void eliminarNoticia(@PathVariable String id) {
        noticiaService.eliminarNoticia(id);
    }
}
