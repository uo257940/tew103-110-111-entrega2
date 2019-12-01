package com.tew.business.resteasy;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tew.business.AgentesService;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;


// URL en la que el web service responderá
@Path("/AgentesServicesRs")
public interface AgentesServicesRs extends AgentesService{

  
   
   @GET
   // paramentro indicado en la URL, utilizado el método con @PathParam
   @Path("{us}/{pass}")
   // formato en el que los datos se retornan en el método
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   int AgenteCorrec(@PathParam("us") String us, @PathParam("pass") String pass ) throws EntityNotFoundException, Exception;

   
   
}	
