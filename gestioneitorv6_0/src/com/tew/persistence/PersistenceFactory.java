package com.tew.persistence;


/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public interface PersistenceFactory {
	PisosDao createPisosDao();
	AgenteDao createAgenteDao();
}

