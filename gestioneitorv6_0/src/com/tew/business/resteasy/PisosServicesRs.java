package com.tew.business.resteasy;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tew.business.PisosService;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Pisos;

// URL en la que el web service responder�
@Path("/PisossServicesRs")
public interface PisosServicesRs extends PisosService{

   // responde a peticiones GET
   @GET
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public List<Pisos> getPisos();
	
   
   @GET
   // paramentro indicado en la URL, utilizado el m�todo con @PathParam
   @Path("{id}")
   // formato en el que los datos se retornan en el m�todo
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   Pisos findById(@PathParam("id") Long id) throws EntityNotFoundException;
	
   // responde a peticiones DELETE
   @DELETE
   // paramentro indicado en la URL
   @Path("{id}")
   void deletePisos(@PathParam("id") Long id) throws EntityNotFoundException;

   // responde a peticiones PUT
   @PUT
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   void savePisos(Pisos Pisos) throws EntityAlreadyExistsException;
	
   // responde a peticiones POST
   @POST
   // formato en que los datos se reciben en el m�todo
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   void updatePisos(Pisos Pisos) throws EntityNotFoundException;
}	
