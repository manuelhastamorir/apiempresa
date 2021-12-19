package com.empresa.empresa.service;

import java.util.*;

import com.empresa.empresa.model.Productos;
import com.empresa.empresa.repository.ProductosRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosServicio {
    @Autowired
    ProductosRepositorio productosRepositorio;

    public List<Productos>getAll()
    {
        return productosRepositorio.getAll();
    }

    public Productos save(Productos producto)
    {
        //Verificar si el id es nulo, si es nulo se guarda
        if(producto.getId()== null)
        {
            return productosRepositorio.save(producto);
        }
        else
        {
            Optional<Productos> consulta = productosRepositorio.getProducto(producto.getId());
            if(consulta.isEmpty())
            {
                return productosRepositorio.save(producto);
            }
            else
            {
                return producto;
            }
        }
    }

    public Productos update (Productos producto)
    {
        if(producto.getId()!=null)
        {
            Optional<Productos> consulta = productosRepositorio.getProducto(producto.getId());
            if(!consulta.isEmpty())
            {
                if(!consulta.isEmpty())
                {
                    if(producto.getBrand()!=null)
                    {
                        consulta.get().setBrand(producto.getBrand());
                    }
                    if(producto.getCategory()!=null)
                    {
                        consulta.get().setCategory(producto.getCategory());
                    }
                    if(producto.getPresentation()!=null)
                    {
                        consulta.get().setPresentation(producto.getPresentation());
                    }
                    if(producto.getDescription()!=null)
                    {
                        consulta.get().setDescription(producto.getDescription());
                    }
                    if(producto.getPhotography()!=null)
                    {
                        consulta.get().setPhotography(producto.getPhotography());
                    }
                }
                return productosRepositorio.save(producto);
            }
        }
        return producto;
    }
    public void deleteProducto(int id)
    {
        Optional<Productos>consulta = productosRepositorio.getProducto(id);
        if(!consulta.isEmpty())
        {
            productosRepositorio.delete(consulta.get());
        }
    }
    
    public Optional<Productos> getProducto(int id)
    {
        return productosRepositorio.getProducto(id);    
    }

    
}
