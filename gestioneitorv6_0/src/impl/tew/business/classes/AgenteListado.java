package impl.tew.business.classes;

import java.util.List;

import com.tew.infrastructure.Factories;
import com.tew.model.Agente;
import com.tew.persistence.AgenteDao;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class AgenteListado {

	public List<Agente> Agentes() throws Exception {
		AgenteDao dao = Factories.persistence.createAgenteDao();
		return  dao.Agentes();
	}
}
