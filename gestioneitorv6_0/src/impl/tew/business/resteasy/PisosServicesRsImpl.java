package impl.tew.business.resteasy;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.business.resteasy.PisosServicesRs;
import com.tew.model.Pisos;
import com.tew.persistence.exception.NotPersistedException;

import impl.tew.business.classes.PisosAlta;
import impl.tew.business.classes.PisosBaja;
import impl.tew.business.classes.PisosBuscar;
import impl.tew.business.classes.PisosListado;
import impl.tew.business.classes.PisosReinicia;
import impl.tew.business.classes.PisosUpdate;

public class PisosServicesRsImpl implements PisosServicesRs {

	@Override
	public List<Pisos> Pisos() {
		try {

			return new  PisosListado().Pisos();
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
	public Pisos findById(int id) throws EntityNotFoundException {
		return new PisosBuscar().find(id);
	}

	@Override
	public String reinicia() throws EntityNotFoundException, NotPersistedException {
		return new PisosReinicia().reinicia();
	}
	
}

