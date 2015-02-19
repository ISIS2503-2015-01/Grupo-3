/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Clinica;
import com.example.models.Doctor;
import com.example.models.Episodio;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiante
 */
@Path("/Doctor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorService 
{
    private Clinica clinica;
    
    public DoctorService()
            
    {
        clinica = Clinica.darInstancia();
    }
    
    @POST
    @Path("/crearDoctor")
    public List<Doctor> crearDoctor(List<Doctor> doctores)
    {
        for (Doctor doctor : doctores) {
            clinica.setDoctor(doctor);
        }
        return doctores;
    }
    
    @GET
    @Path("/consultarEpisodiosPaciente")
    public ArrayList<Episodio> conslutarEpisodiosPaciente(int cedulaP, int cedulaD)
    {
                if(clinica.buscarDoctor(cedulaP)!=null)
                {
                    return  clinica.buscarDoctor(cedulaD).consultarEpisodiosPaciente(cedulaP);
                }
                return null;
    }
    
    @GET
    @Path("/consultarEpisodiosFechas")
    public ArrayList<Episodio> consultarEpisodiosFechas (int cedula,  String fechaInic, String fechaFin)
    {
        if(clinica.buscarDoctor(cedula)!=null&& fechaFin!=null && fechaInic!=null)
        {
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
            try {
                Date fin = format.parse(fechaFin);
                Date inic = format.parse(fechaInic);
                return clinica.buscarDoctor(cedula).consultarEpisodiosPacienteFecha(cedula, fechaInic, fechaFin);

            } catch (ParseException ex) {
                Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    @GET
    @Path("/consultarEpisodio")
    public ArrayList<String> consultarEpisodio(int cedulaD, int cedulaP, String fecha)
    {
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
        if(clinica.buscarDoctor(cedulaD)!=null)
            
            try {
                Date f = format.parse(fecha);
                return clinica.buscarDoctor(cedulaD).verEpisodio(cedulaP, f);
                

            } catch (ParseException ex) {
                Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
    
}
