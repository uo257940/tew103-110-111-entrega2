package impl.tew.business.classes;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.infrastructure.Factories;
import com.tew.model.Pisos;
import com.tew.persistence.PisosDao;
import com.tew.persistence.exception.AlreadyPersistedException;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class PisosAlta {

	public void save(Pisos Pisos) throws EntityAlreadyExistsException {
		PisosDao dao = Factories.persistence.createPisosDao();
		try {
			dao.save(Pisos);
		}
		catch (AlreadyPersistedException ex) {
			throw new EntityAlreadyExistsException("Pisos ya existe " + Pisos, ex);
		}
	}

}
