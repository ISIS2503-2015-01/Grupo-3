/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author estudiante
 */
@Entity
public class Paciente implements Serializable {

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
    private ArrayList<Episodio> episodios;
    /**
     * Nombre del doctor
     */
    private ArrayList<String> medicamentos;
    /**
     * Nombre del doctor
     */
    private ArrayList<String> bebidas;
    /**
     * Nombre del doctor
     */
    private ArrayList<String> alimentos;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor de la clase (sin argumentos)
     */
    public Paciente() {

    }

    /**
     * Constructor de la clase (con argumentos)
     *
     * @param nombre
     */
    public Paciente(String nombre, String apellido, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        episodios = new ArrayList<Episodio>();
        medicamentos = new ArrayList<String>();
        bebidas = new ArrayList<String>();
        alimentos = new ArrayList<String>();
    }

    /**
     * Devuelve el nombre de la ciudad
     *
     * @return nombre Nombre de la ciudad
     */
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getCedula() {
        return cedula;
    }

    /**
     * Modifica el nombre de la ciudad
     *
     * @param nombre Nuevo nombre de la ciudad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void agregarBebida(String bebida) {
        bebidas.add(bebida);
    }

    public void agregarAlimento(String alimento) {
        alimentos.add(alimento);
    }

    public void agregarEpisodio(Episodio nEpisodio) {
        if (episodios == null) {
            episodios = new ArrayList<Episodio>();
        }
        episodios.add(nEpisodio);
    }

    public void editarEpisodio(Episodio nEpisodio) {

        episodios.add(nEpisodio);

    }

    public ArrayList<Episodio> getEpisodios() {
        if (episodios == null) {
            episodios = new ArrayList<Episodio>();
        }
        return episodios;
    }

    public ArrayList<String> getMedicamentos() {
        if (medicamentos == null) {
            medicamentos = new ArrayList<String>();
        }
        return medicamentos;
    }

    public ArrayList<String> getBebidas() {
        if (bebidas == null) {
            bebidas = new ArrayList<String>();
        }
        return bebidas;
    }

    public ArrayList<String> getAlimentos() {
        if (alimentos == null) {
            alimentos = new ArrayList<String>();
        }
        return alimentos;
    }

    public ArrayList<Episodio> getEpisodiosFechas(String fechainicial, String fechafinal) {
        ArrayList<Episodio> episodiosFecha = new ArrayList<Episodio>();
        for (int i = 0; i < episodios.size(); i++) {
            Episodio epis = episodios.get(i);
            System.out.println("Comparacion fecha Inicial: " + epis.getFecha().compareTo(fechainicial));
            System.out.println("Comparacion fecha Final: " + epis.getFecha().compareTo(fechafinal));
            if (epis.getFecha().compareTo(fechainicial) >= 0 || epis.getFecha().compareTo(fechafinal) <= 0) {
                episodiosFecha.add(epis);
            }

        }
        System.out.println("entro getEpisodios");
        return episodiosFecha;
    }

    public Episodio getEpisodio(String fecha) {
        for (int i = 0; i < episodios.size(); i++) {
            if (episodios.get(i).getFecha().equals(fecha)) {
                return episodios.get(i);
            }

        }
        return null;
    }

}
