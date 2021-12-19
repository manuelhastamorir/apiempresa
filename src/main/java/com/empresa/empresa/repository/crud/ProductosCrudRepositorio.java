package com.empresa.empresa.repository.crud;

import com.empresa.empresa.model.Productos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductosCrudRepositorio extends MongoRepository<Productos,Integer>
{
    
}
