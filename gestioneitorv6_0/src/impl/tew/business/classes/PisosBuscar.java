package impl.tew.business.classes;

import com.tew.business.exception.EntityNotFoundException;
import com.tew.infrastructure.Factories;
import com.tew.model.Pisos;
import com.tew.persistence.PisosDao;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class PisosBuscar {

	public Pisos find(int id) throws EntityNotFoundException {
		PisosDao dao = Factories.persistence.createPisosDao();
		Pisos a = dao.findById(id);
		if ( a == null) {
			throw new EntityNotFoundException("No se ha encontrado el Pisos");
		}
		
		return a;
	}

}
