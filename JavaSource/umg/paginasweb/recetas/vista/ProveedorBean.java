package umg.paginasweb.recetas.vista;

import umg.paginasweb.recetas.modelo.Proveedor;

public class ProveedorBean extends AbstractBean<Proveedor> {

	private String nombre;
	private String sitio;

	public ProveedorBean(Proveedor bo) {
		super();
		this.id = bo.getId();
		this.nombre = bo.getNombre();
		this.sitio = bo.getSitio();
	}

	public void loadBean(Proveedor bo) {
		this.id = bo.getId();
		this.nombre = bo.getNombre();
		this.sitio = bo.getSitio();
	}

	public ProveedorBean() {
		super();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSitio() {
		return sitio;
	}

	public void setSitio(String sitio) {
		this.sitio = sitio;
	}
	
	

}
