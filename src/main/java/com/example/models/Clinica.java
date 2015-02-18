 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open bbbb  the template in the editor.
 */
package com.example.models;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author estudiante
 */
public class Clinica {

    private String nombre;
    private ArrayList<Doctor> doctor;
    private ArrayList<Paciente> pacientes;
    private static Clinica instancia;

    private Clinica() {
        nombre = "ClinicaAlpes";
        doctor = new ArrayList();
        pacientes = new ArrayList();
    }

    public Doctor buscarDoctor(int ced) {
        for (int i = 0; i < doctor.size(); i++) {
            if (doctor.get(i).getCedula() == ced) {
                return doctor.get(i);
            }
        }
        return null;
    }

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

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente nPaciente) {
        if (pacientes == null) {
            pacientes = new ArrayList<Paciente>();
        }
        pacientes.add(nPaciente);
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

    public static Clinica darInstancia() {
        if (instancia == null) {
            instancia = new Clinica();
        }
        return instancia;
    }
}
