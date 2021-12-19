package com.empresa.empresa.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Productos 
{
    @Id    
    private Integer id;
    private String brand;
    private String category;
    private String presentation;
    private String description;
    private double price;
    private boolean availability;
    private int quantity;
    private String photography;
}
