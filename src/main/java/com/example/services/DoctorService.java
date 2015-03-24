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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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

    @PersistenceContext(unitName = "arquiPU")
    EntityManager entityManager;
    
    private Clinica clinica;

    public DoctorService() {
        clinica = Clinica.darInstancia();
    }

    @POST
    @Path("/agregarDoctor")
    public List<Doctor> crearDoctor(List<Doctor> doctores) {
        for (Doctor doctor : doctores) {
            clinica.addDoctor(doctor);
            try {
                entityManager.getTransaction().begin();
                entityManager.persist(doctor);
                entityManager.getTransaction().commit();
                entityManager.refresh(doctor);
            } catch (Throwable t) {
                t.printStackTrace();
                if (entityManager.getTransaction().isActive()) {
                    entityManager.getTransaction().rollback();
                }
            } finally {
                entityManager.clear();
                entityManager.close();
            }
        }
        return doctores;
    }

    @GET
    @Path("/consultarEpisodiosPaciente/{cedulaPaciente}/{cedulaDoctor}")
    public List<Episodio> conslutarEpisodiosDoctor(@PathParam("cedulaPaciente") int cedulaPaciente, @PathParam("cedulaDoctor") int cedulaDoctor) {
        
        TypedQuery<Episodio> query = (TypedQuery<Episodio>) entityManager.createQuery("SELECT e.alimentos, e.bebidas,e.cedula FROM EPISODIO e, DOCTOR d, PACIENTE p WHERE d.cedula = :cedulaDoctor AND p.cedula = :cedulaDoctor ");
		query.setParameter("cedulaPaciente",cedulaPaciente);
                query.setParameter("cedulaDoctor",cedulaDoctor);
        List<Episodio> episodios =query.getResultList();
          return episodios;
               
    }

    @GET
    @Path("/consultarEpisodiosPaciente/{cedulaPaciente}/{cedulaDoctor}/{fechaInicial}/{fechaFinal}")
    public List<Episodio> conslutarEpisodiosDoctor(@PathParam("cedulaPaciente") int cedulaPaciente, @PathParam("cedulaDoctor") int cedulaDoctor, @PathParam("fechaInicial") String fechaInicial, @PathParam("fechaFinal") String fechaFinal) {
       TypedQuery<Episodio> query = (TypedQuery<Episodio>) entityManager.createQuery("SELECT e.alimentos, e.bebidas,e.cedula FROM EPISODIO e, DOCTOR d, PACIENTE p WHERE e.fecha BETWEEN :fechaInicial AND :fechaFinal AND d.cedula = :cedulaDoctor AND p.cedula = :cedulaDoctor ");
		query.setParameter("cedulaPaciente",cedulaPaciente);
                query.setParameter("fechaInicial",fechaInicial);
                query.setParameter("cedulaDoctor",cedulaDoctor);
                 query.setParameter("fechaFinal",fechaFinal);
        List<Episodio> episodios =query.getResultList();
          return episodios;
    }

    @GET
    @Path("/consultarEpisodiosPaciente/{cedulaPaciente}/{cedulaDoctor}/{id}")
    public Episodio consultarEpisodio(@PathParam("cedulaPaciente") int cedulaPaciente, @PathParam("cedulaDoctor") int cedulaDoctor, @PathParam("id") long id) {
        TypedQuery<Episodio> query = (TypedQuery<Episodio>) entityManager.createQuery("SELECT e.alimentos, e.bebidas,e.cedula FROM EPISODIO e, DOCTOR d, PACIENTE p WHERE e.id = :id AND d.cedula = :cedulaDoctor AND p.cedula = :cedulaDoctor ");
		query.setParameter("cedulaPaciente",cedulaPaciente);
                query.setParameter("cedulaDoctor",cedulaDoctor);
                query.setParameter("id",id);
        Episodio episodios = (Episodio) query.getResultList();
          return episodios;
    }
    
}
        