package com.empresa.empresa.webcontroller;

import java.util.*;

import com.empresa.empresa.model.Ordenes;
import com.empresa.empresa.service.OrdenesServicio;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrdenesControlador 
{
    @Autowired  
    private OrdenesServicio ordenesServicio;

    @GetMapping("/all")
    public List<Ordenes>getOrdenes()
    {
        return ordenesServicio.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Ordenes save (@RequestBody Ordenes orden)
    {
        return ordenesServicio.save(orden);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ordenes update(@RequestBody Ordenes orden)
    {
        return ordenesServicio.update(orden);
    }
    @GetMapping("{id}")
    public Optional<Ordenes>getOrden(@PathVariable ("id") int id)
    {
        return ordenesServicio.getOrden(id);
    }
    @GetMapping("/zona/{zonap}")
    public List<Ordenes> getProductosZona(@PathVariable ("zonap") String zona)
    {
        return ordenesServicio.getProductosZona(zona); 
    }
    @GetMapping("/salesman/{id}")
    public List<Ordenes> getProductosId(@PathVariable ("id") int id)
    {
        return ordenesServicio.getProductosId(id);
    }
    @GetMapping("/state/{status}/{id}")
    public List<Ordenes> getStatusId(@PathVariable ("status") String status, @PathVariable ("id") int id)
    {
        return ordenesServicio.getStatusAsesor(status, id);
    }
    @GetMapping("/date/{diaRegistro}/{id}")
    public List<Ordenes> getDiaRegistroAsesor(@PathVariable ("diaRegistro") String diaRegistro,@PathVariable ("id") int id)
    {
        return ordenesServicio.getDiaRegistroAsesor(diaRegistro, id);
    }
}
