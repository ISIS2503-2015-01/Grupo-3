package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio
 */
@Entity
public class Doctor implements Serializable {

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
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Nombre del doctor
     */
    private String nombre;
    /**
     * Apellido del doctor
     */
    private String apellido;
    /**
     * Cédula del doctor
     */
    private int cedula;
    /**
     * Nombre del doctor
     */
    @OneToMany
    private List<Paciente> pacientes;
    
    private String password;

    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------
    /**
     * Constructor de la clase Doctor (sin argumentos)
     */
    public Doctor() {

    }

    /**
     * Constructor de la clase Doctor (con argumentos)
     *
     * @param pNombre El nombre del doctor
     * @param pApellido El apellido del doctor
     * @param pCedula La cédula del doctor
     */
    public Doctor(String pNombre, String pApellido, int pCedula, String pass) {
        nombre = pNombre;
        apellido = pApellido;
        cedula = pCedula;
        pacientes = new ArrayList<Paciente>();
        password = pass;
    }

    //------------------------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------------------------
    // GETTERS ----------------------------------
    /**
     * Retorna el nombre del doctor
     *
     * @return El nombre del doctor
     */
    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }
    /**
     * Retorna el apellido del doctor
     *
     * @return El apellido del doctor
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Retorna la cédula del doctor
     *
     * @return La cédula del doctor
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * Retorna la lista de cedulas de los pacientes asociados al doctor
     *
     * @return La lista de cédulas de pacientes del doctor
     */
    public List<Paciente> getCedulaPacientes() {
        return pacientes;
    }

    /**
     * Retorna el Id del doctor
     *
     * @return El Id del doctor
     */
    public long getId() {
        return id;
    }

    // SETTERS ----------------------------------
    /**
     * Modifica el nombre del doctor
     *
     * @param pNombre Nuevo nombre del doctor
     */
    public void setNombre(String pNombre) {
        nombre = pNombre;
    }

    /**
     * Modifica el apellido del doctor
     *
     * @param pApellido Nuevo apellido del doctor
     */
    public void setApellido(String pApellido) {
        apellido = pApellido;
    }
    
     public void setPassword(String pApellido) {
        password = pApellido;
    }
    
    /**
     * Modifica a cédula del doctor
     *
     * @param pCedula Nuevo cédula del doctor
     */
    public void setCedula(int pCedula) {
        cedula = pCedula;
    }

    /**
     * Modifica a id del doctor
     *
     * @param pId Nuevo id del doctor
     */
    public void setId(long pId) {
        id = pId;
    }

    /**
     * Modifica las cédulas asociadas al doctor
     *
     * @param pCedulaPacientes Lista de pacientes a agregar
     */
    public void setCedulaPacientes(List<Paciente> pCedulaPacientes) {
        pacientes = pCedulaPacientes;
    }

    // ADDER ----------------------------------
    /**
     * Método que agrega un paciente
     *
     * @param cedulaPaciente La cédula del paciente a agregar
     */
    public void addPaciente(Paciente cedulaPaciente) {
        pacientes.add(cedulaPaciente);
    }

    // ASKER ----------------------------------
    
    /**
     * Método que responde si el paciente pasado por parámetro pertenece al doctor
     * @param pCedula La cédula del paciente solicitado
     * @return True si el paciente es atendido por el doctor. False de los contrario.
     */
    public boolean contienePaciente(Paciente paciente) {
        for (int i =0; i<pacientes.size();i++)
        {
            if(paciente == pacientes.get(i))
            {
                return true;
            }
        }
        return false;
    }

}
