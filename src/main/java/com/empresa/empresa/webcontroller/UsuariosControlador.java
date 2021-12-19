package com.empresa.empresa.webcontroller;

import java.util.*;

import com.empresa.empresa.model.Usuarios;
import com.empresa.empresa.model.reportes.EmailPassword;
import com.empresa.empresa.service.UsuariosServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UsuariosControlador 
{
    @Autowired
    private UsuariosServicio usuariosServicio;
    
    @GetMapping("/all")
    public List<Usuarios>getUsuarios()
    {
        return usuariosServicio.getAll();
    }
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios save(@RequestBody Usuarios usuario)
    {
        return usuariosServicio.save(usuario);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuarios update(@RequestBody Usuarios usuario)
    {
        return usuariosServicio.update(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuarios(@PathVariable ("id") int id)
    {
        usuariosServicio.deleteUsuario(id);
    }

    @GetMapping("/emailexist/{email}")
    public boolean getEmail(@PathVariable ("email") String email)
    {
        return usuariosServicio.getEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public EmailPassword getEmailPassword(@PathVariable ("email") String email,@PathVariable ("password") String password)
    {
        return usuariosServicio.getEmailPassword(email, password);
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> name(@PathVariable ("id") int id)
    {
        return usuariosServicio.getUsuario(id);
    }
}
