package impl.tew.business.resteasy;

import java.util.List;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.business.resteasy.PisosServicesRs;
import com.tew.model.Pisos;

import impl.tew.business.classes.PisosAlta;
import impl.tew.business.classes.PisosBaja;
import impl.tew.business.classes.PisosBuscar;
import impl.tew.business.classes.PisosListado;
import impl.tew.business.classes.PisosUpdate;

public class PisosServicesRsImpl implements PisosServicesRs {

	@Override
	public List<Pisos> getPisos() {
		try {
			return new PisosListado().Pisos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
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
	public Pisos findById(Long id) throws EntityNotFoundException {
		return new PisosBuscar().find(id);
	}
}
