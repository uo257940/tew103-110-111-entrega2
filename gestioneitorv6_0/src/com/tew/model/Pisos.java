package com.tew.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Alejandro Muñiz Berdasco
 * @author Pedro Palacio Estrada
 * @author Alvaro Fernandez Arias
 */

@XmlRootElement(name="pisos")
public class Pisos {
	private int IDAgente;
	private int ID;
	private double precio;
	private String direccion;
	private String ciudad;
	private int anio;
	private int estado;
	private String imagen;
		
	public Pisos (int id,int IDAgente, double precio, String direccion, String ciudad, int anio,int estado) {
		  this.ID = id; this.IDAgente = IDAgente; this.precio = precio;
		  this.direccion = direccion; this.ciudad= ciudad; this.anio=anio; this.estado=estado; 
	}
	
	public Pisos() {
		
	}
	
	@XmlElement
	public int getIDAgente() {
		return IDAgente;
	}
	public void setIDAgente(int iDAgente) {
		IDAgente = iDAgente;
	}
	
	@XmlElement
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	@XmlElement
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@XmlElement
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@XmlElement
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@XmlElement
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	@XmlElement
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	@XmlElement
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	
	

}