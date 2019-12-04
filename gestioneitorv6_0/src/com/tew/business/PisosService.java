package com.tew.business;

import java.util.List;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Pisos;
import com.tew.persistence.exception.NotPersistedException;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public interface PisosService {

	List<Pisos> Pisos() throws Exception;
	Pisos findById(int id) throws EntityNotFoundException;
	void savePisos(Pisos piso) throws EntityAlreadyExistsException;
	void updatePisos(Pisos piso) throws EntityNotFoundException;
	void deletePisos(int id) throws EntityNotFoundException;
	String reinicia() throws EntityNotFoundException, NotPersistedException ;
}