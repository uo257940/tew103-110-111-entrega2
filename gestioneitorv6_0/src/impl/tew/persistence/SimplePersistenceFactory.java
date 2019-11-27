package impl.tew.persistence;


import com.tew.persistence.AgenteDao;
import com.tew.persistence.PersistenceFactory;
import com.tew.persistence.PisosDao;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class SimplePersistenceFactory implements PersistenceFactory {

	@Override
	public PisosDao createPisosDao() {
		return new PisosJdbcDao();
	}
	@Override
	public AgenteDao createAgenteDao() {
		return new AgenteJdbcDao();
	}


}
