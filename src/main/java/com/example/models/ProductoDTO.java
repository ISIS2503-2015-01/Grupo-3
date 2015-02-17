/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.Calendar;

/**
 *
 * @author estudiante
 */
public class ProductoDTO {
    
    private String name;
    
    private String marca;
    
    private Calendar fechaCompra;
    
       
    
    public ProductoDTO(){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Calendar getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Calendar fecha) {
        this.fechaCompra = fecha;
    }

    
    
    
}
