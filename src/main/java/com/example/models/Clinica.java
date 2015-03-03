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


@NoSql(dataFormat=DataFormatType.MAPPED)
@Entity
@XmlRootElement
/**
 *
 * @author estudiante
 */
public class Clinica implements Serializable {
    
    @Id
 	@GeneratedValue
 	@Field(name="_id")
 	private String id;

    private String nombre;
    private ArrayList<Doctor> doctor;
    private ArrayList<Paciente> pacientes;
    private static Clinica instancia;

    private Clinica() {
        nombre = "ClinicaAlpes";
        doctor = new ArrayList();
        pacientes = new ArrayList();
    }

    //GET
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }    
    
    //SET
    public void setDoctor(Doctor nDoctor) {
        if (doctor == null) {
            doctor = new ArrayList<Doctor>();
        }
        for (int i = 0; i < doctor.size(); i++) {
            if (doctor.get(i).getCedula() == nDoctor.getCedula()) {
                return;
            }
        }
        doctor.add(nDoctor);
    }
        
    public void setPacientes(Paciente nPaciente) {
        if (pacientes == null) {
            pacientes = new ArrayList<Paciente>();
        }
        pacientes.add(nPaciente);
    }
    
    //SEARCH
    public Doctor buscarDoctor(int ced) {
        for (int i = 0; i < doctor.size(); i++) {
            if (doctor.get(i).getCedula() == ced) {
                return doctor.get(i);
            }
        }
        return null;
    }    

    public Paciente buscarPaciente(int pCedula) {
        for (Iterator<Paciente> iterator = pacientes.iterator(); iterator.hasNext();) {
            Paciente next = iterator.next();
            if (next.getCedula() == pCedula) {
                return next;
            }
        }
        return null;
    }

    public ArrayList<Episodio> conslutarEpisodiosPaciente(int cedulaPaciente, int cedulaDoctor) {
        Doctor doctor = buscarDoctor(cedulaDoctor);
        if (doctor != null ) {
            return doctor.consultarEpisodiosPaciente(cedulaPaciente);
        }
        return null;
    }
    
    //INSTANCIA
    public static Clinica darInstancia() {
        if (instancia == null) {
            instancia = new Clinica();
        }
        return instancia;
    }
}
