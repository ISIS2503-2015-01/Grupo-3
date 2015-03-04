 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open bbbb  the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@NoSql(dataFormat = DataFormatType.MAPPED)
@Entity
@XmlRootElement
/**
 * Clase Clínica
 *
 * @author estudiante
 */
public class Clinica implements Serializable {

    //-----------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------
    /**
     * Constante de serialización
     */
    private static final long serialVersionUID = 1L;

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    /**
     * Identificador del doctor en la BD
     */
    @Id
    @GeneratedValue
    @Field(name = "_id")
    private String id;

    /**
     * Lista de doctores asociados a la clínica
     */
    private ArrayList<Doctor> doctores;

    /**
     * Lista de pacientes de la clínica
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Instancia de la clase
     */
    private static Clinica instancia;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor de la clase Doctor (sin argumentos)
     */
    private Clinica() {
        doctores = new ArrayList();
        pacientes = new ArrayList();
    }

    //------------------------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------------------------
    // GETTERS ----------------------------------
    /**
     * Retorna la lista de pacientes de la clínica
     *
     * @return La lista de pacientes
     */
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de doctores de la clínica
     *
     * @return La lista de doctores
     */
    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    /**
     * El id de la clínica
     *
     * @return El id de la clínica
     */
    public String getId() {
        return id;
    }

    // INSTANCE ----------------------------------
    public static Clinica darInstancia() {
        if (instancia == null) {
            instancia = new Clinica();
        }
        return instancia;
    }

    // SETTERS ----------------------------------
    /**
     * Modifica la lista de doctores
     *
     * @param nDoctores La lista de doctores
     */
    public void setDoctor(ArrayList<Doctor> nDoctores) {
        doctores = nDoctores;
    }

    /**
     * Mdifica la lista de pacientes
     *
     * @param nPacientes La lista de pacientes
     */
    public void setPacientes(ArrayList<Paciente> nPacientes) {
        pacientes = nPacientes;
    }

    /**
     * Modifica el id de la clínica
     *
     * @param pId Nuevo id de la clínica
     */
    public void setId(String pId) {
        id = pId;
    }

    // ADDER ----------------------------------
    /**
     * Método que agrega un episodio a un paciente
     * @param pEpisodio El episodio a agregar
     */
    public void agregarEpisodio(Episodio pEpisodio) {
        Paciente paciente = buscarPaciente(pEpisodio.getCedula());
        if (null != paciente) {
            paciente.addEpisodio(pEpisodio);
        }
    }

    /**
     * Método que agrega un doctor asociado a la clínica
     * @param pDoctor El doctor a agregar
     */
    public void agregarDoctor(Doctor pDoctor) {
        Doctor doctor = buscarDoctor(pDoctor.getCedula());
        if (doctor == null) {
            doctores.add(pDoctor);
        }
    }

    /**
     * Método que agrega un paciente a la clínica
     * @param pPaciente 
     */
    public void agregarPaciente(Paciente pPaciente) {
        Paciente paciente = buscarPaciente(pPaciente.getCedula());
        if (paciente == null) {
            pacientes.add(pPaciente);
        }
    }

    //SEARCH
    public Doctor buscarDoctor(int pCedula) {
        for (Doctor doctor : doctores) {
            if (doctor.getCedula() == pCedula) {
                return doctor;
            }
        }
        return null;
    }

    public Paciente buscarPaciente(int pCedula) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCedula() == pCedula) {
                return paciente;
            }
        }
        return null;
    }

    public ArrayList<Episodio> conslutarEpisodiosPaciente(int cedulaPaciente, int cedulaDoctor) {
        Doctor doctor = buscarDoctor(cedulaDoctor);
        if (doctor != null) {
            return doctor.consultarEpisodiosPaciente(cedulaPaciente);
        }
        return null;
    }

}
