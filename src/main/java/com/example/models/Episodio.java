/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

/**
 *
 * @author estudiante
 */
@NoSql(dataFormat=DataFormatType.MAPPED)
@Entity
@XmlRootElement
public class Episodio implements Serializable{
    	@Id
 	@GeneratedValue
 	@Field(name="_id")
 	private String id;
    //------------------------------------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------------------------------------
    
    /**
     * Fecha de ocurrencia del Episodio
     */
    private String fecha;
    
    /**
     * Nivel de dolor del episodio
     */
    private double nivelDolor;
    
    /**
     * Localización del dolor
     */
    private String localizacion;
    
    /**
     * Intensidad de la dolencia
     */
    private double intensidad;
    
    /**
     * Nivel de alivio obtenido por los medicamentos
     */
    private double nivelAlivio;
    
    /**
     * Lista de medicamentos tomados para el episodio
     */
    private ArrayList<String> medicamentos;
    
    /**
     * Alimentos consumidos antes del episodio
     */
    private ArrayList<String> alimentos;
    
    /**
     * Bebidas consumidas antes del episodio
     */
    private ArrayList<String> bebidas;
    
    /**
     * Cédula del paciente que registra el evento
     */
    private int cedula;
    
    /**
     * Identificador único del episodio
     */
    private int ID;

    //------------------------------------------------------------------------------------------------------
    // Constructores
    //------------------------------------------------------------------------------------------------------
    
    /**
     * Constructor de la clase
     */
    public Episodio() {

    }

    /**
     * Constructor de la clase
     * @param pCedula La cédula del paciente que registra el episodio
     * @param dia Dia de ocurrencia del episodio.
     * @param mes Mes de ocurrencia del episodio.
     * @param anhio Año de ocurrencia del episodio.
     * @param hora Hora de ocurrencia del episodio.
     * @param minuto Minuto de ocurrencia del episodio.
     * @param pNivelDolor Nivel del dolor rgistrado para el episodio. pNivelDolor >= 0.
     * @param pLocalizacion Localización del dolor. pLocalizacion != null && pLocalizacion != "".
     * @param pIntensidad Intensidad del dolor del episodio. pIntensidad >= 0.
     * @param pNivelAlivio Nivel de dolor del episodio. pNivelAlivio >= 0.
     * @param pMedicamentos Medicamentos tomados para el dolor.
     * @param pAlimentos Alimentos consumidos antes del episodio.
     * @param pBebidas Bebidas consumidas antes del episodio.
     */
    public Episodio( int pCedula, String dia, String mes, String anhio, String hora, String minuto, double pNivelDolor, String pLocalizacion, double pIntensidad, double pNivelAlivio, ArrayList<String> pMedicamentos, ArrayList<String> pAlimentos, ArrayList<String> pBebidas) {
        
        cedula = pCedula;
        fecha = anhio + mes + dia + hora + minuto;
        nivelDolor = pNivelDolor;
        localizacion = pLocalizacion;
        intensidad = pIntensidad;
        nivelAlivio = pNivelAlivio;
        medicamentos = pMedicamentos;
        alimentos = pAlimentos;
        bebidas = pBebidas;
        
    }

    //------------------------------------------------------------------------------------------------------
    // Métodos
    //------------------------------------------------------------------------------------------------------
    
    // GETTERS ----------------------------------
    
    /**
     * 
     * @return 
     */
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

    public ArrayList<String> getMedicamentos() {
        if (medicamentos == null) {
            medicamentos = new ArrayList<String>();
        }
        return medicamentos;
    }

    public ArrayList<String> getAlimentos() {
        if (alimentos == null) {
            alimentos = new ArrayList<String>();
        }
        return alimentos;
    }

    public ArrayList<String> getBebidas() {
        if (bebidas == null) {
            bebidas = new ArrayList<String>();
        }
        return bebidas;
    }
    
    public int getCedula(){
        return cedula;
    }
    
    // SETERS -----------------------------------
    // SETERS -----------------------------------
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

    // REFACTOR -----------------------------------
    public void refactor(){
        // TODO aa
    }
}
