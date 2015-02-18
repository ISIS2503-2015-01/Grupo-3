/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Episodio;
import com.example.models.Paciente;
import java.util.ArrayList;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author estudiante
 */
@Path("/Paciente")
public class PacienteService 
{
    private ArrayList<Paciente> pacientes;
    public PacienteService()
    {
        pacientes = new ArrayList();
    }
    @POST
    @Path("/agregarPaciente")
    public void agregarPacientes(String nom, String apellido, int ced)
    {
        for(int i=0;i<pacientes.size();i++)
        {
            if(pacientes.get(i).getCedula()!=ced)
            {
                pacientes.add(new Paciente(nom,apellido, ced));
            }
        }
    }
    @POST
    @Path("/agregarEpisodio")
    public void agregarEpisodio(int ced,Date fecha, double nivelDeDolor,String localizacion, double intensidad, double alivio, ArrayList <String> medicamento,ArrayList <String> alimentos, ArrayList <String> bebidas)
    {
        for(int i=0;i<pacientes.size();i++)
        {
            if(pacientes.get(i).getCedula()==ced)
            {
                pacientes.get(i).agregarEpisodio(fecha, nivelDeDolor, localizacion, intensidad, alivio, medicamento, alimentos, bebidas);
            }
        }
    }
    @POST
    @Path("/editarEpisodio")
    public void editarEpisodio(int ced,Date fecha, double nivelDeDolor,String localizacion, double intensidad, double alivio, ArrayList <String> medicamento,ArrayList <String> alimentos, ArrayList <String> bebidas)
    {
        for(int i=0;i<pacientes.size();i++)
        {
            if(pacientes.get(i).getCedula()==ced)
            {
                pacientes.get(i).editarEpisodio(fecha, nivelDeDolor, localizacion, intensidad, alivio, medicamento, alimentos, bebidas);
            }
        }
    }
    @GET
    @Path("/obtenerEpisodioFecha")
    public ArrayList<Episodio> verEpisodioFecha (int ced, Date fechainicial, Date fechafinal)
    {
        
        for(int i=0;i<pacientes.size();i++)
        {
            if(pacientes.get(i).getCedula()==ced)
            {
                return pacientes.get(i).getEpisodiosFechas(fechainicial, fechafinal);
            }
        }
        return null;
    }
    @GET
    @Path("/obtenerEpisodio")
    public Episodio verEpisodioFecha( int ced, Date fecha)
    {
        for(int i=0;i<pacientes.size();i++)
        {
            if(pacientes.get(i).getCedula()==ced)
            {
                return pacientes.get(i).getEpisodio(fecha);
            }
        }
        return null;
    }
}
