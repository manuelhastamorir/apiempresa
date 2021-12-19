package com.empresa.empresa.repository;

import java.util.*;

import com.empresa.empresa.model.Usuarios;
import com.empresa.empresa.repository.crud.UsuariosCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioRepositorio 
{
    @Autowired
    UsuariosCrudRepositorio usuariosCrudRepositorio;

    public List<Usuarios>getAll()
    {
        return (List<Usuarios>)usuariosCrudRepositorio.findAll();
    }

    public Usuarios save(Usuarios usuarios)
    {
        return usuariosCrudRepositorio.save(usuarios);
    }

    public void delete (Usuarios usuarios)
    {
        usuariosCrudRepositorio.deleteAll();
    }
    public Optional<Usuarios>getUsuario(int id)
    {
        return usuariosCrudRepositorio.findById(id);
    }

    public Optional<Usuarios> getEmail(String email)
    {
        return usuariosCrudRepositorio.findByEmail(email);
    }

    public Optional<Usuarios>getEmailPassword(String email,String password)
    {
        return usuariosCrudRepositorio.findByEmailAndPassword(email, password);
    }
    public List<Usuarios> getMesCumpleaños(String mesCumple)
    {
        return usuariosCrudRepositorio.findByMonthBirthtDay(mesCumple);
    }

}
