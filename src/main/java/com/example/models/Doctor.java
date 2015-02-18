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
 * @author Mauricio
 */
@Entity
public class Doctor implements Serializable {

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
    private ArrayList<Paciente> pacientes;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor de la clase (sin argumentos)
     */
    public Doctor() {

    }

    /**
     * Constructor de la clase (con argumentos)
     *
     * @param nombre
     */
    public Doctor(String nombre, String apellido, int cedula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        pacientes = new ArrayList<Paciente>();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------
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

    public ArrayList<Episodio> consultarEpisodiosPaciente(int cedula) {
        ArrayList episodios = new ArrayList<Episodio>();
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCedula() == cedula) {

                episodios = pacientes.get(i).getEpisodios();
            }

        }
        return episodios;
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

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public ArrayList<Episodio> consultarEpisodiosPacienteFecha(int cedula, String fechainicial, String fechafinal) {
        ArrayList episodios = new ArrayList<Episodio>();
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCedula() == cedula) {

                episodios = pacientes.get(i).getEpisodiosFechas(fechainicial, fechafinal);
            }
        }
        return episodios;

    }

    public ArrayList<String> verEpisodio(int cedula, Date fecha) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getCedula() == cedula) {
                //pacientes.get(i).ge
            }
        }
        return null;
    }

}
