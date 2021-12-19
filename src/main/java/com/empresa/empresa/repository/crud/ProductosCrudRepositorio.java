package com.empresa.empresa.repository.crud;

import java.util.List;

import com.empresa.empresa.model.Productos;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductosCrudRepositorio extends MongoRepository<Productos,Integer>
{
    public List<Productos>findByPriceLessThanEqual(double precio);
    public List<Productos>findByDescriptionContaining(String des);
}
