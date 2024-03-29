package com.tew.business.resteasy;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import impl.tew.business.resteasy.AgentesServicesRsImpl;
import impl.tew.business.resteasy.PisosServicesRsImpl;
@SuppressWarnings("unchecked")
public class Application extends javax.ws.rs.core.Application {

	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public Application() {
		classes.add(PisosServicesRsImpl.class);
		classes.add(AgentesServicesRsImpl.class);
	}
 	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
	@Override
	public Set<Object> getSingletons() {
		return Collections.EMPTY_SET;
	}
}
