package com.empresa.empresa.webcontroller;

import java.util.*;

import com.empresa.empresa.model.Productos;
import com.empresa.empresa.service.ProductosServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cleaningprod")
public class ProductosControlador 
{
    @Autowired
    private ProductosServicio productosServicio;

    @GetMapping("/all")
    public List<Productos>getProductos()
    {
        return productosServicio.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos save(@RequestBody Productos producto)
    {
        return productosServicio.save(producto);
    }

    @PutMapping ("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos update (@RequestBody Productos producto)
    {
        return productosServicio.update(producto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProducto(@PathVariable ("id") int id)
    {
        productosServicio.deleteProducto(id);
    }

    @GetMapping("/{id}")
    public Optional<Productos> getProducto(@PathVariable ("id") int id) 
    {
        return productosServicio.getProducto(id);
    }
}
