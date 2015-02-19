/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.services;

import com.example.models.Clinica;
import com.example.models.Episodio;
import com.example.models.Paciente;
import java.util.ArrayList;
import java.util.List;
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

    static private Clinica clinica = Clinica.darInstancia();

    public PacienteService() {

    }

    @POST
    @Path("/agregarPaciente")
    public List<Paciente> agregarPacientes(List<Paciente> pac) {
        for (Paciente pacient : pac) {
            clinica.setPacientes(pacient);
        }
        return pac;
    }

    @POST
    @Path("/agregarEpisodio")
    public List<Episodio> agregarEpisodio(List<Episodio> pEpisodios) {
        for (Episodio nEpisodio : pEpisodios) {
            Paciente p = clinica.buscarPaciente(nEpisodio.getCedula());
            if (p != null) {
                p.agregarEpisodio(nEpisodio);
            } else {
                System.out.println("fail");
            }
        }
        return pEpisodios;
    }

    @POST
    @Path("/pruebaPost")
    public String pruebaPost(String cadena1) {//, String cadena2, int num2) {
        JSONParser jp = new JSONParser();
        try {
            Object ob = jp.parse(cadena1);
            JSONArray o = (JSONArray) ob;
            return ((JSONObject) o.get(1)).get("num1") + "";
        } catch (Exception e) {
            return "fail\n" + e.getMessage();
        }
    }

    @POST
    @Path("/editarEpisodio")
    public void editarEpisodio(List<Episodio> pEpisodios) {
        for (Episodio nEpisodio : pEpisodios) {
            Paciente p = clinica.buscarPaciente(nEpisodio.getCedula());
            if (p != null) {
                p.editarEpisodio(nEpisodio);
            }
        }
    }

    @GET
    @Path("/obtenerEpisodioFecha/{cedula}/{fechaInicial}/{fechaFinal}")
    public ArrayList<Episodio> verEpisodioFecha(@PathParam("cedula") String cedula, @PathParam("fechaInicial") String fechaInicial, @PathParam("fechaFinal") String fechaFinal) {//int ced, String fechainicial, String fechafinal) 
        try {
            Paciente pacient = clinica.buscarPaciente(Integer.parseInt(cedula));
            System.out.println(cedula);
            if (pacient == null) {
                System.out.println("paciente nulo");
            }
            return pacient.getEpisodiosFechas(fechaInicial, fechaFinal);
        } catch (Exception e) {
            
            return new ArrayList<Episodio>();
        }
    }

    @GET
    @Path("/obtenerEpisodio/{cedula}/{fecha}")
    public Episodio verEpisodioFecha(@PathParam("cedula") String cedula, @PathParam("fecha") String fecha) {
        try {
            Paciente pacient = clinica.buscarPaciente(Integer.parseInt(cedula));
            if (pacient == null) {
                System.out.println("paciente nulo");
            }
            return pacient.getEpisodio(fecha);
        } catch (Exception e) {
            return new Episodio();
        }
    }

}
