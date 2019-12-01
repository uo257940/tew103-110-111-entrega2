package impl.tew.business.resteasy;

import java.util.List;

import com.tew.business.exception.EntityAlreadyExistsException;
import com.tew.business.exception.EntityNotFoundException;
import com.tew.business.resteasy.AgentesServicesRs;
import com.tew.model.Agente;

import impl.tew.business.classes.AgenteAlta;
import impl.tew.business.classes.AgenteBaja;
import impl.tew.business.classes.AgenteBuscar;
import impl.tew.business.classes.AgenteListado;
import impl.tew.business.classes.AgenteUpdate;
import impl.tew.business.classes.AgenteCorrecto;

public class AgentesServicesRsImpl implements AgentesServicesRs {


	
	@Override
	public boolean AgenteCorrec(String us, String pass) throws Exception {
		try {
			
		return new AgenteCorrecto().agenteCorrecto(us,pass);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	}
	
	
	

	@Override
	public List<Agente> Agentes() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agente findById(int id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAgente(Agente agente) throws EntityAlreadyExistsException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAgente(Agente agente) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAgente(int id) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		
	}

	
}