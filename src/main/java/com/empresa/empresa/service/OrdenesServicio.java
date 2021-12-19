package com.empresa.empresa.service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.empresa.empresa.model.Ordenes;
import com.empresa.empresa.repository.OrdenesRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenesServicio 
{
    @Autowired
    OrdenesRepositorio ordenesRepositorio;
    
    public List<Ordenes>getAll()
    {
        return ordenesRepositorio.getAll();
    }

    public Ordenes save(Ordenes orden)
    {
        //Verificar si el id es nulo, si es nulo se guarda
        if(orden.getId()==null)
        {
            return ordenesRepositorio.save(orden); 
        }
        else
        {
            Optional<Ordenes>consulta = ordenesRepositorio.getOrden(orden.getId());
            if(consulta.isEmpty())
            {
                return ordenesRepositorio.save(orden);
            }
            else
            {
                return orden;
            }
        }
    }

    public Ordenes update (Ordenes orden)
    {
        if(orden.getId()!=null)
        {
            Optional<Ordenes>consulta = ordenesRepositorio.getOrden(orden.getId());
            if(!consulta.isEmpty())
            {
                if (orden.getRegisterDay()!=null) 
                {
                    consulta.get().setRegisterDay(orden.getRegisterDay());
                }
                if (orden.getStatus()!=null) 
                {
                    consulta.get().setStatus(orden.getStatus());
                }
                if (orden.getSalesMan()!=null) 
                {
                    consulta.get().setSalesMan(orden.getSalesMan());
                }
                if (orden.getProducts()!=null) 
                {
                    consulta.get().setProducts(orden.getProducts());
                }
                if (orden.getQuantities()!=null) 
                {
                    consulta.get().setQuantities(orden.getQuantities());
                }
                return consulta.get();
            }
        }
        return orden;
    }


    public Optional<Ordenes> getOrden(int id)
    {
        return ordenesRepositorio.getOrden(id);
    }

    public List<Ordenes> getProductosZona(String zona)
    {
        return ordenesRepositorio.getproductoszona(zona);
    }

    public List<Ordenes> getProductosId(int id)
    {
        return ordenesRepositorio.getProductosId(id);
    }

    public List<Ordenes> getStatusAsesor(String status, int id)
    {
        return ordenesRepositorio.getStatusAsesor(status, id);
    }

    public List<Ordenes> getDiaRegistroAsesor(String fechaRegistro,int id)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
        Date diaRegistro = new Date();
        try {
            diaRegistro = formato.parse(fechaRegistro);    
        } catch (Exception e) {
            //TODO: handle exception
        }
        return ordenesRepositorio.getDiaRegistroAsesor(diaRegistro, id);
    }
    
}
