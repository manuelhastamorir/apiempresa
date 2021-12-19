package com.empresa.empresa.repository.crud;

import java.util.*;

import com.empresa.empresa.model.Usuarios;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuariosCrudRepositorio extends MongoRepository<Usuarios,Integer>
{
    //Consultar si existe email
    public Optional<Usuarios> findByEmail(String email);
    public Optional<Usuarios> findByEmailAndPassword(String email,String password);
    public List<Usuarios> findByMonthBirthtDay(String mesCumple);
}
