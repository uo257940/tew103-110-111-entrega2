package impl.tew.business.classes;

import java.util.List;

import com.tew.infrastructure.Factories;
import com.tew.model.Pisos;
import com.tew.persistence.PisosDao;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class PisosListado {

	public List<Pisos> Pisos() throws Exception {
		PisosDao dao = Factories.persistence.createPisosDao();
		return  dao.Pisos();
	}
}
