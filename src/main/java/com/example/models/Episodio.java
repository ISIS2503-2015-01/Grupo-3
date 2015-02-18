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
public class Episodio {

    private String fecha;
    private double nivelDolor;
    private String localizacion;
    private double intensidad;
    private double nivelAlivio;
    private ArrayList<String> medicamentos;
    private ArrayList<String> alimentos;
    private ArrayList<String> bebidas;
    private int cedula;

    public Episodio() {

    }

    public Episodio(int pCedula, String dia, String mes, String anhio, String hora, String minuto, double d, String local, double inten, double alivio, ArrayList<String> medic, ArrayList<String> ali, ArrayList<String> beb) {
        cedula = pCedula;
        fecha = anhio + mes + dia + hora + minuto;
        nivelDolor = d;
        localizacion = local;
        intensidad = inten;
        nivelAlivio = alivio;
        medicamentos = medic;
        alimentos = ali;
        bebidas = beb;
    }

    public String getFecha() {
        return fecha;
    }

    public double getNivelDolor() {
        return nivelDolor;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public double getIntensidad() {
        return intensidad;
    }

    public double getAlivio() {
        return nivelAlivio;
    }

    public String getMedicamentos() {
        String s = new String();
        for (int i = 0; i < medicamentos.size(); i++) {
            String m = medicamentos.get(i);
            s += m + " ";
        }
        return s;
    }

    public String getAlimentos() {
        String s = new String();
        for (int i = 0; i < alimentos.size(); i++) {
            String m = alimentos.get(i);
            s += m + " ";
        }
        return s;
    }

    public String getBebidas() {
        String s = new String();
        for (int i = 0; i < bebidas.size(); i++) {
            String m = bebidas.get(i);
            s += m + " ";
        }
        return s;
    }

    public int getCedula() {
        return cedula;
    }

    public void setFecha(String nFecha) {
        fecha = nFecha;
    }

    public void setNivelDolor(double dol) {
        nivelDolor = dol;
    }

    public void setLocalizacion(String local) {
        localizacion = local;
    }

    public void setIntensidad(double in) {
        intensidad = in;
    }

    public void setNivelAlivio(double al) {
        nivelAlivio = al;
    }

    public void setMedicamentos(ArrayList<String> s) {
        medicamentos = s;
    }

    public void setAlimentos(ArrayList<String> s) {
        alimentos = s;
    }

    public void setBebidas(ArrayList<String> s) {
        bebidas = s;
    }

    public void setCedula(int pCedula) {
        cedula = pCedula;
    }
}
