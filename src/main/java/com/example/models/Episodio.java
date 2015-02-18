/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author estudiante
 */
public class Episodio 
{
    private Date fecha;
    private double nivelDolor;
    private String localizacion;
    private double intensidad;
    private double nivelAlivio;
    private ArrayList<String> medicamentos;
    private ArrayList<String> alimentos;
    private ArrayList<String> bebidas;
    
    public Episodio (Date f, double d, String local, double inten, double alivio, ArrayList<String> medic, ArrayList<String> ali, ArrayList<String> beb)
    {
        
        fecha = f;
        nivelDolor = d;
        localizacion = local;
        intensidad = inten;
        nivelAlivio = alivio;
        medicamentos = medic;
        alimentos = ali;
        bebidas = beb;
    }
    
    public Date darFecha ()
    {
        return fecha;
    }
    public double darNivelDolor()
    {
        return nivelDolor;
    }
    public String darLocalizacion()
    {
        return localizacion;
    }
    public double darIntensidad ()
    {
        return intensidad;
    }
    public double darAlivio()
    {
        return nivelAlivio;
    }
    public String darMedicamento()
    {
        String s = new String();
        for(int i =0;i < medicamentos.size(); i++)
        {
            String m = medicamentos.get(i);
            s += m + " ";
        }
        return s;
    }
    public String darAlimentos()
    {
        String s = new String();
        for(int i =0;i < alimentos.size(); i++)
        {
            String m = alimentos.get(i);
            s += m + " ";
        }
        return s;
    }
    public String darBebidas()
    {
        String s = new String();
        for(int i =0;i < bebidas.size(); i++)
        {
            String m =  bebidas.get(i);
            s += m + " ";
        }
        return s;
    }
     public void setFecha (Date f)
    {
        fecha = f;
    }
    public void setNivelDolor(double dol)
    {
       nivelDolor= dol;
    }
    public void setLocalizacion(String local)
    {
        localizacion= local;
    }
    public void darIntensidad (double in)
    {
        intensidad = in;
    }
    public void darAlivio(double al)
    {
        nivelAlivio = al;
    }
    public void setMEdicamento(ArrayList<String> s)
    {
        medicamentos = s;
    }
    public void setAlimentos (ArrayList<String> s)
    {
        alimentos = s;
    }
    public void setBebidas (ArrayList<String> s)
    {
        bebidas = s;
    }
}
