/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.ArrayList;

/**
 *
 * @author estudiante
 */
public class Clinica 
{
    private String nombre;
    private ArrayList<Doctor> doctor;
    public Clinica ()
    {
        nombre = "ClinicaAlpes";
        doctor = new ArrayList();
    }
    public Doctor buscarDoctor(int ced)
    {
        for (int i=0;i<doctor.size();i++)
        {
            if(doctor.get(i).getCedula() == ced)
            {
                return doctor.get(i);
            }
        }
        return null;
    }
    public void agregarDoctor(String nom, String ape,int ced)
    {
         for (int i=0;i<doctor.size();i++)
        {
            if(doctor.get(i).getCedula() == ced)
            {}}
    }
}
