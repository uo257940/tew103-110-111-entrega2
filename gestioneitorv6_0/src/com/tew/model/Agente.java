package com.tew.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

@XmlRootElement(name="agente")
public class Agente {
	private int ID;
	private String login;
	private String passwd;
	
	public Agente (int id, String login, String passwd) {
		  this.ID = id; this.login = login; this.passwd = passwd;
	}
	
	public Agente() {
		
	}
	
	@XmlElement
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	@XmlElement
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@XmlElement
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}