package impl.tew.business.classes;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.infrastructure.Factories;
import com.tew.model.Agente;
import com.tew.persistence.AgenteDao;
import com.tew.persistence.exception.AlreadyPersistedException;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class AgenteCorrecto {

	public int agenteCorrecto(String us, String pass) throws Exception {
		AgenteDao dao = Factories.persistence.createAgenteDao();
		try {
			return dao.agenteCorrecto(us,pass);
		}
		catch (Exception ex) {
			throw new EntityAlreadyExistsException(ex);
		}
	}

}
