package com.empresa.empresa.repository.crud;

import java.util.*;

import com.empresa.empresa.model.Ordenes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdenesCrudRepositorio extends MongoRepository<Ordenes,Integer>
{
    public List<Ordenes>findBySalesManZone(String zona);
    public List<Ordenes>findBySalesManId(int id);
    public List<Ordenes>findByStatusAndSalesManId(String status,int id);
    public List<Ordenes>findByRegisterDayAndSalesManId(Date diaRegistro, int id);
}
