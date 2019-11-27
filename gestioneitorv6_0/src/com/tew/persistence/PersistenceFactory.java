package com.tew.persistence;


/**
 * @author Alejandro Mu�iz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public interface PersistenceFactory {
	PisosDao createPisosDao();
	AgenteDao createAgenteDao();
}

