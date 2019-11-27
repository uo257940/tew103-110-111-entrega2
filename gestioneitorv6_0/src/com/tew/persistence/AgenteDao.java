package com.tew.persistence;

import java.util.List;

import com.tew.model.Agente;
import com.tew.persistence.exception.AlreadyPersistedException;
import com.tew.persistence.exception.NotPersistedException;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public interface AgenteDao {

	List<Agente> Agentes();
	void save(Agente a) throws AlreadyPersistedException;
	void update(Agente a) throws NotPersistedException;
	void delete(int id) throws NotPersistedException;
	Agente findById(int id);

}