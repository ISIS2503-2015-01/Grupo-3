/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import com.sun.istack.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.PrimaryKey;

/**
 * Clase Paciente
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
    @Column(name="id")
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

    /**
     * Nombre del paciente
     */
    private String nombre;

    /**
     * Apellido del paciente
     */
    private String apellido;

    /**
     * Cédula del paciente
     */
    private int cedula;
    
    /**
     * Lista de episodios
     */
    @OneToMany
    private List<Episodio> episodios;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor de la clase Paciente (sin argumentos)
     */
    public Paciente() {
        episodios = new ArrayList<Episodio>();
    }

    /**
     * Constructor de la clase Paciente (con argumentos)
     *
     * @param pNombre El nombre del paciente
     * @param pApellido El apellido del paciente
     * @param pCedula La cédula del paciente
     */
    public Paciente(String pNombre, String pApellido, int pCedula) {
        this.nombre = pNombre;
        this.apellido = pApellido;
        this.cedula = pCedula;
        episodios = new ArrayList<Episodio>();
    }

    //------------------------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------------------------
    // GETTERS ----------------------------------
    /**
     * Retorna el nombre del paciente
     *
     * @return Nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el apellido del paciente
     *
     * @return Apellido del paciente
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Retorna la cédula del paciente
     *
     * @return La cédula del paciente
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Retorna la lista de episodios
     *
     * @return La lista de episodios
     */
    public List<Episodio> getEpisodios() {
        if (episodios == null) {
            episodios = new ArrayList<Episodio>();
        }
        return episodios;
    }

    /**
     * Retorna un episodio dado su Id
     *
     * @param pId El Id del episodio solicitado
     * @return El episodio con el Id especificado. Si no lo encuentra retorna
     * null.
     */
    public Episodio getEpisodio(long pId) {
        for (Episodio episodio : episodios) {
            if (episodio.getId() == (pId)) {
                return episodio;
            }
        }
        return null;
    }

    /**
     * Retorna un arreglo con los episodios cuya fecha está eentre los elementos
     * pasados por parametros
     *
     * @param fechainicial La fecha inicial buscada
     * @param fechafinal La fecha final buscada
     * @return Lista con los epiodios cuya fecha coincide con los parámetros.
     */
    public List<Episodio> getEpisodiosFechas(String fechainicial, String fechafinal) {
        List<Episodio> episodiosFecha = new ArrayList<Episodio>();
        for (Episodio epis : episodios) {
            if (epis.getFecha().compareTo(fechainicial) >= 0 || epis.getFecha().compareTo(fechafinal) <= 0) {
                episodiosFecha.add(epis);
            }
        }
        return episodiosFecha;
    }

    // SETTERS ----------------------------------
    /**
     * Modifica el nombre del paciente
     *
     * @param pNombre Nombre del paciente
     */
    public void setNombre(String pNombre) {
        nombre = pNombre;

    }

    /**
     * Modifica el apellido del paciente
     *
     * @param pApellido El apellido del paciente
     */
    public void setApellido(String pApellido) {
        apellido = pApellido;
    }

    /**
     * Madifica la cédula del paciente
     *
     * @param pCedula La cédula del paciente
     */
    public void setCedula(int pCedula) {
        cedula = pCedula;
    }

    /**
     * Modifica la lista de episodios
     *
     * @param pEpisodios La lista de episodios
     */
    public void setEpisodios(ArrayList<Episodio> pEpisodios) {
        episodios = pEpisodios;
    }

    // ADDER ----------------------------------
    /**
     * Método que agrega un episodio
     *
     * @param pEpisodio El episodio a agregar
     */
    public void addEpisodio(Episodio pEpisodio) {
        episodios.add(pEpisodio);
    }
}
