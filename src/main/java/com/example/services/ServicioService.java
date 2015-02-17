package com.example.services;


import com.example.models.Servicio;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author estudiante
 */
@Path("/Servicio")
@Produces(MediaType.APPLICATION_JSON)
public class ServicioService 
{
    @POST
    @Path("/servicios")
    @Produces(MediaType.APPLICATION_JSON)
   public void darMensaje(@FormParam("men")String men) throws JSONException 
   {
    Servicio s = new Servicio(men);
  
   }
}
