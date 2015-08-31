package umg.paginasweb.recetas.vista;

import umg.paginasweb.recetas.modelo.Usuario;

public class UserBean extends AbstractBean<Usuario>{
	
	private String nombreUsuario;
	private String clave;
	private String correo;
	private String nombre;
	private String apellido;
	private String rol;

	public UserBean(Usuario bo) {
		super();
		this.id = bo.getId();
		this.nombreUsuario = bo.getNombreUsuario();
		this.clave = bo.getClave();
		this.correo = bo.getCorreo();
		this.nombre = bo.getNombre();
		this.apellido = bo.getApellido();
		this.rol = bo.getRol();
	}

	public void loadBean(Usuario bo) {
		this.id = bo.getId();
		this.nombreUsuario = bo.getNombreUsuario();
		this.clave = bo.getClave();
		this.correo = bo.getCorreo();
		this.nombre = bo.getNombre();
		this.apellido = bo.getApellido();
		this.rol = bo.getRol();
	}

	public UserBean() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

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
