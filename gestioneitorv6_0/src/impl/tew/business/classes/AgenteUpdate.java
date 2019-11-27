package impl.tew.business.classes;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.infrastructure.Factories;
import com.tew.model.Agente;
import com.tew.persistence.AgenteDao;
import com.tew.persistence.exception.NotPersistedException;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class AgenteUpdate {

	public void update(Agente Agente) throws EntityNotFoundException {
		AgenteDao dao = Factories.persistence.createAgenteDao();
		try {
			dao.update(Agente);
		}
		catch (NotPersistedException ex) {
			throw new EntityNotFoundException("Agente no eliminado " + Agente, ex);
		}
	}

}
