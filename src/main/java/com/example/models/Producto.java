/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import com.sun.istack.NotNull;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author estudiante
 */
@Entity
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
 @NotNull
    @Column(name = "create_at", updatable = false)
    @Temporal(TemporalType.DATE)
    private Calendar createdAt;
 
    @NotNull
    @Column(name = "updated_at")
    @Temporal(TemporalType.DATE)
    private Calendar updatedAt;
 
    private String name;
 
    private String marca;
    
    private Competitor competitor;
    
    @Temporal(TemporalType.DATE)
    private Calendar fechaCompra;
      public Producto() {
 
    }
 
     public Producto(String nameN, String marcaN, Calendar fechaN) {
        name = nameN;
        marca = marcaN;
        fechaCompra = fechaN;
    
}
     
      @PreUpdate
    private void updateTimestamp() {
        this.updatedAt = Calendar.getInstance();
    }
 
    @PrePersist
    private void creationTimestamp() {
        this.createdAt = this.updatedAt = Calendar.getInstance();
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
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
      @OneToOne(optional=false, mappedBy="competitor")
    public Competitor getCompetitor() { return competitor; }
}