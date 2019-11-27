package impl.tew.business;

import impl.tew.business.classes.*;


import java.util.List;

import com.tew.business.PisosService;
import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.model.Pisos;
import com.tew.persistence.exception.NotPersistedException;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

public class SimplePisosService implements PisosService {

	@Override
	public List<Pisos> Pisos() throws Exception{
		return new PisosListado().Pisos();
	}

	@Override
	public void savePisos(Pisos Pisos) throws EntityAlreadyExistsException {
		new PisosAlta().save(Pisos);
	}

	@Override
	public void updatePisos(Pisos Pisos) throws EntityNotFoundException {
		new PisosUpdate().update(Pisos);
	}

	@Override
	public void deletePisos(int id) throws EntityNotFoundException {
		new PisosBaja().delete(id);
	}

	@Override
	public Pisos findById(int id) throws EntityNotFoundException {
		return new PisosBuscar().find(id);
	}
}
