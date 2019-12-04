package com.tew.persistence;

import java.util.List;

import com.tew.model.Pisos;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public interface PisosDao {

	List<Pisos> Pisos();
	void save(Pisos a) throws AlreadyPersistedException;
	void update(Pisos a) throws NotPersistedException;
	void delete(int id) throws NotPersistedException;
	Pisos findById(int id);
	String reinicia();
}