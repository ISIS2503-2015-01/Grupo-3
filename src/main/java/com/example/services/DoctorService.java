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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author estudiante
 */
@Path("/Doctor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorService {

    private Clinica clinica;

    public DoctorService() {
        clinica = Clinica.darInstancia();
    }

    @POST
    @Path("/agregarDoctor")
    public List<Doctor> crearDoctor(List<Doctor> doctores) {
        for (Doctor doctor : doctores) {
            clinica.addDoctor(doctor);
        }
        return doctores;
    }

    @GET
    @Path("/consultarEpisodiosPaciente/{cedulaPaciente}/{cedulaDoctor}")
    public ArrayList<Episodio> conslutarEpisodiosDoctor(@PathParam("cedulaPaciente") int cedulaPaciente, @PathParam("cedulaDoctor") int cedulaDoctor) {
        return clinica.conslutarEpisodiosDoctor(cedulaPaciente, cedulaDoctor);
    }

    @GET
    @Path("/consultarEpisodiosPaciente/{cedulaPaciente}/{cedulaDoctor}/{fechaInicial}/{fechaFinal}")
    public ArrayList<Episodio> conslutarEpisodiosDoctor(@PathParam("cedulaPaciente") int cedulaPaciente, @PathParam("cedulaDoctor") int cedulaDoctor, @PathParam("fechaInicial") String fechaInicial, @PathParam("fechaFinal") String fechaFinal) {
        return clinica.conslutarEpisodiosDoctor(cedulaPaciente, cedulaDoctor, fechaInicial, fechaFinal);
    }

    @GET
    @Path("/consultarEpisodiosPaciente/{cedulaPaciente}/{cedulaDoctor}/{id}")
    public Episodio consultarEpisodio(@PathParam("cedulaPaciente") int cedulaPaciente, @PathParam("cedulaDoctor") int cedulaDoctor, @PathParam("id") String id) {
        return clinica.conslutarEpisodioDoctor(id, cedulaPaciente, cedulaDoctor);
    }

}
