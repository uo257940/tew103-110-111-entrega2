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

public class AgenteAlta {

	public void save(Agente Agente) throws EntityAlreadyExistsException {
		AgenteDao dao = Factories.persistence.createAgenteDao();
		try {
			dao.save(Agente);
		}
		catch (AlreadyPersistedException ex) {
			throw new EntityAlreadyExistsException("Agente ya existe " + Agente, ex);
		}
	}

}
