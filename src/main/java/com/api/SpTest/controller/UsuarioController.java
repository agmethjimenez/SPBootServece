package com.api.SpTest.controller;

import com.api.SpTest.entity.Usuario;
import com.api.SpTest.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Optional<Usuario>getUsuarioporId(@PathVariable("id")Long id){
        return usuarioService.getUsuario(id);

    }
    @GetMapping(path = "/buscar-nombre")

    public List<Usuario> BuscarUsuarioEmail(@RequestParam(value = "nm",required = false) String nombre, @RequestParam(value = "mail", required = false) String email){
        String nombreBusqueda = (nombre != null) ? nombre : "";
        String emailBusqueda = (email != null) ? email : "";

        return usuarioService.buscarUsuariosPorNombre(nombreBusqueda, emailBusqueda);
    }

    @PostMapping
    public void postUsuario(@RequestBody Usuario usuario){
        usuarioService.guardarOactualizar(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable("id")Long id){
        usuarioService.borrarUsuario(id);
    }
}
