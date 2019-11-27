package impl.tew.business.classes;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.infrastructure.Factories;
import com.tew.model.Pisos;
import com.tew.persistence.PisosDao;
import com.tew.persistence.exception.NotPersistedException;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class PisosUpdate {

	public void update(Pisos Pisos) throws EntityNotFoundException {
		PisosDao dao = Factories.persistence.createPisosDao();
		try {
			dao.update(Pisos);
		}
		catch (NotPersistedException ex) {
			throw new EntityNotFoundException("Pisos no eliminado " + Pisos, ex);
		}
	}

}
