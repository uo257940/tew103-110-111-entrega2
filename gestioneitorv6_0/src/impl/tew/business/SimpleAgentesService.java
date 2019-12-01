package impl.tew.business;

import impl.tew.business.classes.*;


import java.util.List;

import com.tew.business.AgentesService;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Agente;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class SimpleAgentesService implements AgentesService {

	@Override
	public List<Agente> Agentes() throws Exception{
		return new AgenteListado().Agentes();
	}

	@Override
	public void saveAgente(Agente Agente) throws EntityAlreadyExistsException {
		new AgenteAlta().save(Agente);
	}

	@Override
	public void updateAgente(Agente Agente) throws EntityNotFoundException {
		new AgenteUpdate().update(Agente);
	}

	@Override
	public void deleteAgente(int id) throws EntityNotFoundException {
		new AgenteBaja().delete(id);
	}

	@Override
	public Agente findById(int id) throws EntityNotFoundException {
		return new AgenteBuscar().find(id);
	}

	@Override
	public boolean AgenteCorrec(String us, String pass) throws Exception  {
		
		return true;
	}
}
