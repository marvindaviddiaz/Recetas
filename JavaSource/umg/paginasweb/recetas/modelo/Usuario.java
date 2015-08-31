package umg.paginasweb.recetas.modelo;

import org.hibernate.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/** 
* @author Brwayam
* @version 1.0
* @created 11-nov-2012 06:59:29 p.m.
*/

public class Usuario extends AbstractBo {
	
	private String nombreUsuario;
	private String clave;
	private String correo;
	private String nombre;
	private String apellido;
	private String rol;

	public Usuario() {}
	public Usuario(String nombreUsuario, String clave, String rol){
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.rol = rol;
	};
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	

	
}