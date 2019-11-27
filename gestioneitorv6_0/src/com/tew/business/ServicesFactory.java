package com.tew.business;

/**
 * @author Alejandro Mu�iz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public interface ServicesFactory {
	
	PisosService	createPisosService();
	AgentesService createAgentesService();

}
