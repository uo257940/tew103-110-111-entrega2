package impl.tew.business.classes;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.infrastructure.Factories;
import com.tew.model.Agente;
import com.tew.persistence.AgenteDao;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class AgenteBuscar {

	public Agente find(int id) throws EntityNotFoundException {
		AgenteDao dao = Factories.persistence.createAgenteDao();
		Agente a = dao.findById(id);
		if ( a == null) {
			throw new EntityNotFoundException("No se ha encontrado el Agente");
		}
		
		return a;
	}

}
