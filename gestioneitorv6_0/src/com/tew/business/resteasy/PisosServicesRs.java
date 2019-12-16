package com.tew.business.resteasy;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.tew.business.PisosService;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Pisos;
import com.tew.persistence.exception.NotPersistedException;

// URL en la que el web service responderá
@Path("/PisosServicesRs")
public interface PisosServicesRs extends PisosService{

   // responde a peticiones GET
   @GET
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public List<Pisos> Pisos();
   
	
   // responde a peticiones DELETE
   @DELETE
   @Path("{id}")
   void deletePisos(@PathParam("id") int id) throws EntityNotFoundException;

   // responde a peticiones PUT
   @PUT
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   void savePisos(Pisos Pisos) throws EntityAlreadyExistsException;
	
   // responde a peticiones POST
   @POST
   // formato en que los datos se reciben en el método
   @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   void updatePisos(Pisos Pisos) throws EntityNotFoundException;

   // responde a peticiones GET
   @DELETE
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public String reinicia() throws EntityNotFoundException, NotPersistedException;
   
   @GET
   @Path("{id}")
   @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
   public List<Pisos>  PisosDeAgente(@PathParam("id") int id);
  
   
}	
