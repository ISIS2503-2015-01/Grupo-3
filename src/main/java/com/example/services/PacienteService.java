/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.PersistenceManager;
import com.example.models.Clinica;
import com.example.models.Episodio;
import com.example.models.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author estudiante
 */
@Path("/Paciente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacienteService {

    @PersistenceContext(unitName = "mongoPU")
    EntityManager entityManager;

    static private Clinica clinica = Clinica.darInstancia();

    @PostConstruct
    public void init() {
        try {
            entityManager = PersistenceManager.getInstance().getEntityManagerFactory().createEntityManager();
        } catch (Exception e) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            e.printStackTrace();
        }
    }

    @POST
    @Path("/agregarPaciente")
    public List<Paciente> agregarPacientes(List<Paciente> pac) {
        for (Paciente pacient : pac) {
            clinica.addPaciente(pacient);
            System.out.println(clinica.getPacientes().size());
        }
        return pac;
    }

    @POST
    @Path("/agregarEpisodio")
    public List<Episodio> agregarEpisodio(List<Episodio> pEpisodios) {
        for (Episodio nEpisodio : pEpisodios) {
            Paciente p = clinica.buscarPaciente(nEpisodio.getCedula());
            if (p != null) {
                p.addEpisodio(nEpisodio);
            } else {
                System.out.println("fail");
            }
        }
        return pEpisodios;
    }

    @GET
    @Path("/obtenerEpisodios/{cedula}/{fechaInicial}/{fechaFinal}")
    public ArrayList<Episodio> verEpisodioFecha(@PathParam("cedula") String cedula, @PathParam("fechaInicial") String fechaInicial, @PathParam("fechaFinal") String fechaFinal) {//int ced, String fechainicial, String fechafinal) 
        try {
            Paciente pacient = clinica.buscarPaciente(Integer.parseInt(cedula));
            if (pacient != null) {
                return pacient.getEpisodiosFechas(fechaInicial, fechaFinal);
            } else {
                System.out.println("paciente nulo");
                return new ArrayList<Episodio>();
            }

        } catch (Exception e) {
            return new ArrayList<Episodio>();
        }
    }

    @GET
    @Path("/obtenerEpisodios/{cedula}/{id}")
    public Episodio verEpisodioFecha(@PathParam("cedula") String cedula, @PathParam("id") String id) {
        try {
            Paciente pacient = clinica.buscarPaciente(Integer.parseInt(cedula));
            if (null == pacient) {
                System.out.println("paciente nulo");
                return new Episodio();
            } else {
                return pacient.getEpisodio(id);
            }

        } catch (Exception e) {
            return new Episodio();
        }
    }

    @GET
    @Path("/obtenerEpisodios/{cedula}")
    public ArrayList<Episodio> verEpisodioFecha(@PathParam("cedula") String cedula) {
        try {
            Paciente pacient = clinica.buscarPaciente(Integer.parseInt(cedula));
            if (null == pacient) {
                System.out.println("paciente nulo");
                return new ArrayList<Episodio>();
            } else {
                return pacient.getEpisodios();
            }

        } catch (Exception e) {
            return new ArrayList<Episodio>();
        }
    }
}
