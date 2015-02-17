/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author estudiante
 */
@Entity
public class Paciente implements Serializable{
    
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
     private static final long serialVersionUID = 1L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nombre del doctor
     */
    private String nombre;
     /**
     * Nombre del doctor
     */
    private String apellido;
     /**
     * Nombre del doctor
     */
    private int cedula;
    /**
     * Nombre del doctor
     */
     private ArrayList<Episodio> episodios ;
      /**
     * Nombre del doctor
     */
     private ArrayList<String> medicamentos ;
          /**
     * Nombre del doctor
     */
     private ArrayList<String> bebidas ;
          /**
     * Nombre del doctor
     */
     private ArrayList<String> alimentos ;
     
     
      //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor de la clase (sin argumentos)
     */
    public Paciente()
    {

    }

    /**
     * Constructor de la clase (con argumentos)
     * @param nombre
     */
    public Paciente(String nombre, String apellido, int cedula)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        episodios=new ArrayList<Episodio>();
        medicamentos=new ArrayList<String>();
        bebidas=new ArrayList<String>();
        alimentos=new ArrayList<String>();
    }

     /**
     * Devuelve el nombre de la ciudad
     * @return nombre Nombre de la ciudad
     */
    public String getNombre()
    {
        return nombre;
    }
    public String getApellido()
    {
        return apellido;
    }
    public int getCedula()
    {
        return cedula;
    }
        /**
     * Modifica el nombre de la ciudad
     * @param nombre Nuevo nombre de la ciudad
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
        
    }
     public void setApellido(String apellido)
    {
        this.nombre = nombre;
    }
      public void setCedula(int cedula)
    {
        this.cedula = cedula;
    }
      public void agregarBebida(String bebida)
      {
      bebidas.add(bebida);
      }
      public void agregarAlimento(String alimento)
      {
      alimentos.add(alimento);
      }
        public void agregarEpisodio(Date fecha, double nivelDeDolor,String localizacion, double intensidad, double alivio, ArrayList <String> medicamento,ArrayList <String> alimentos, ArrayList <String> bebidas )
      {
        Episodio epis = new Episodio(fecha,nivelDeDolor,localizacion,intensidad,alivio,medicamento);
        episodios.add(epis);
      }
         public void editarEpisodio(Date fecha, double nivelDeDolor,String localizacion, double intensidad, double alivio, ArrayList <String> medicamento )
      {
        Episodio epis = new Episodio(fecha,nivelDeDolor,localizacion,intensidad,alivio,medicamento);
        episodios.add(epis);
      }
      
     public ArrayList<Episodio> getEpisodios()
    {
        return episodios;
    }
      public ArrayList<String> getMedicamentos()
    {
        return medicamentos;
    }
           public ArrayList<String> getBebidas()
    {
        return bebidas;
    }
                public ArrayList<String> getAlimentos()
    {
        return alimentos;
    }
                
        public ArrayList<Episodio> getEpisodiosFechas(Date fechainicial, Date fechafinal)
    {
        ArrayList<Episodio> episodiosFecha= new ArrayList <Episodio>();
        for(int i=0; i<episodios.size(); i++)
        {
            Episodio epis=episodios.get(i);
            if(epis.getFecha()> fechainicial||epis.getFecha()< fechafinal){
                episodiosFecha.add(epis);
            }
       
        }
         return episodiosFecha;
    }
    
    public Episodio getEpisodio(Date fecha)
    {
        for (int i = 0; i < episodios.size(); i++) {
            Object arr = arr[i];
            
        }
    }

}
