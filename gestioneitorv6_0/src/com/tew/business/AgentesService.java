package com.tew.business;

import java.util.List;

import javax.ws.rs.PathParam;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Agente;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public interface AgentesService {

	List<Agente> Agentes() throws Exception;
	Agente findById(int id) throws EntityNotFoundException;
	void saveAgente(Agente agente) throws EntityAlreadyExistsException;
	void updateAgente(Agente agente) throws EntityNotFoundException;
	void deleteAgente(int id) throws EntityNotFoundException;
	int AgenteCorrec(String us, String pass ) throws EntityNotFoundException, Exception;

}