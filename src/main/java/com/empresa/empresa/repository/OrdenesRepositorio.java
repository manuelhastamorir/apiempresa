package com.empresa.empresa.repository;

import java.util.*;
import java.util.Optional;

import com.empresa.empresa.model.Ordenes;
import com.empresa.empresa.repository.crud.OrdenesCrudRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrdenesRepositorio 
{
    @Autowired
    OrdenesCrudRepositorio ordenesCrudRepositorio;

    public List<Ordenes>getAll()
    {
        return (List<Ordenes>)ordenesCrudRepositorio.findAll();
    }

    public Ordenes save(Ordenes orden)
    {
        return ordenesCrudRepositorio.save(orden);
    }

    public Optional <Ordenes> getOrden(int id)
    {
        return ordenesCrudRepositorio.findById(id);
    }

    public List<Ordenes> getproductoszona(String zona)
    {
        return ordenesCrudRepositorio.findBySalesManZone(zona);
    }

    public List<Ordenes> getProductosId(int id)
    {
        return ordenesCrudRepositorio.findBySalesManId(id);
    }
    public List<Ordenes> getStatusAsesor(String status,int id)
    {
        return ordenesCrudRepositorio.findByStatusAndSalesManId(status, id);
    }
    public List<Ordenes> getDiaRegistroAsesor(Date diaRegistro,int id)
    {
        return ordenesCrudRepositorio.findByRegisterDayAndSalesManId(diaRegistro, id);
    }
}
