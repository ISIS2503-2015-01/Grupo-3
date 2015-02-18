/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Clinica;
import com.example.models.Doctor;
import com.example.models.Episodio;
import com.example.models.Paciente;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author estudiante
 */
@Path("/Doctor")
public class DoctorService 
{
    private Clinica c;
    public DoctorService()
    {
        Clinica c = new Clinica();
    }
    @POST
    @Path("/crearDoctor")
    public void crearDoctor(@FormParam("nom")String nom, @FormParam("apellido")String apellido,@FormParam("ced") int ced)
    {
        if(c.buscarDoctor(ced)==null)
        {
        Doctor d = new Doctor(nom, apellido, ced);
        
        }
    }
    @GET
    @Path("/consultarEpisodiosPaciente")
    public ArrayList<Episodio> conslutarEpisodiosPaciente(int cedulaP, int cedulaD)
    {
                if(c.buscarDoctor(cedulaP)!=null)
                {
                    return  c.buscarDoctor(cedulaD).consultarEpisodiosPaciente(cedulaP);
                }
                return null;
    }
    
    @GET
    @Path("/consultarEpisodiosFechas")
    public ArrayList<Episodio> consultarEpisodiosFechas (int cedula,  String fechaInic, String fechaFin)
    {
        if(c.buscarDoctor(cedula)!=null&& fechaFin!=null && fechaInic!=null)
        {
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
            try {
                Date fin = format.parse(fechaFin);
                Date inic = format.parse(fechaInic);
                return c.buscarDoctor(cedula).consultarEpisodiosPacienteFecha(cedula, inic, fin);

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
        if(c.buscarDoctor(cedulaD)!=null)
            
            try {
                Date f = format.parse(fecha);
                return c.buscarDoctor(cedulaD).verEpisodio(cedulaP, f);
                

            } catch (ParseException ex) {
                Logger.getLogger(DoctorService.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    }
    
}
