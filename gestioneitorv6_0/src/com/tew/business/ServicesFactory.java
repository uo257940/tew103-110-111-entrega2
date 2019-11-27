package com.tew.business;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public interface ServicesFactory {
	
	PisosService	createPisosService();
	AgentesService createAgentesService();

}
