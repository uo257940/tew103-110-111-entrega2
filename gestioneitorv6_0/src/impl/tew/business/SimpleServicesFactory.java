package impl.tew.business;


import com.tew.business.AgentesService;
import com.tew.business.PisosService;
import com.tew.business.ServicesFactory;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class SimpleServicesFactory implements ServicesFactory {

	
	@Override
	public PisosService createPisosService() {
		return new SimplePisosService();
	}

	@Override
	public AgentesService createAgentesService() {
		
		return new SimpleAgentesService();
	}

	
}
