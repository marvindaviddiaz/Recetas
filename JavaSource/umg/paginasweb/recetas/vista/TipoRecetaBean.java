package umg.paginasweb.recetas.vista;

import umg.paginasweb.recetas.modelo.TipoReceta;

public class TipoRecetaBean extends AbstractBean<TipoReceta> {

	private String nombre;
	private String descripcion;

	public TipoRecetaBean(TipoReceta bo) {
		super();
		this.id = bo.getId();
		this.nombre = bo.getNombre();
		this.descripcion = bo.getDescripcion();
	}

	public void loadBean(TipoReceta bo) {
		this.id = bo.getId();
		this.nombre = bo.getNombre();
		this.descripcion = bo.getDescripcion();
	}

	public TipoRecetaBean() {
		super();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
