package umg.paginasweb.recetas.vista;

import umg.paginasweb.recetas.modelo.Marca;

public class MarcaBean extends AbstractBean<Marca> {

	private String nombre;

	public MarcaBean(Marca bo) {
		super();
		this.id = bo.getId();
		this.nombre = bo.getNombre();
	}

	public void loadBean(Marca bo) {
		this.id = bo.getId();
		this.nombre = bo.getNombre();
	}

	public MarcaBean() {
		super();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
