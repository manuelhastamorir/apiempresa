package com.empresa.empresa.model;

import java.util.Date;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class Ordenes 
{
    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private Usuarios salesMan;
    private Map<Integer, Productos> products;
    private Map<Integer, Integer> quantities;
}
