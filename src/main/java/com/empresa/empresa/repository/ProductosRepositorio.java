package com.empresa.empresa.repository;

import java.util.*;

import com.empresa.empresa.model.Productos;
import com.empresa.empresa.repository.crud.ProductosCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductosRepositorio 
{
    @Autowired
    ProductosCrudRepositorio productosCrudRepositorio;
    
    public List<Productos>getAll()
    {
        return(List<Productos>)productosCrudRepositorio.findAll();
    }

    public Productos save(Productos productos)
    {
        return productosCrudRepositorio.save(productos);
    }

    public void delete (Productos productos)
    {
        productosCrudRepositorio.delete(productos);
    }

    public Optional <Productos>getProducto(int id)
    {
        return productosCrudRepositorio.findById(id);
    }

    public List<Productos> getPrecio(double precio)
    {
        return productosCrudRepositorio.findByPrice(precio);
    }

    public List<Productos> getDescripcion(String des)
    {
        return productosCrudRepositorio.findByDescriptionContaining(des);
    }
}
