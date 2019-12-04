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

public class PisosReinicia {

	public String reinicia( ) throws EntityNotFoundException, NotPersistedException {
		PisosDao dao = Factories.persistence.createPisosDao();
		return dao.reinicia();
	}

}
