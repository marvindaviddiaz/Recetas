package umg.paginasweb.recetas.vista;

import umg.paginasweb.recetas.modelo.Ingrediente;

public class IngredienteBean extends AbstractBean<Ingrediente> {

	private String nombre;

	public IngredienteBean(Ingrediente bo) {
		super();
		this.id = bo.getId();
		this.nombre = bo.getNombre();
	}

	public void loadBean(Ingrediente bo) {
		this.id = bo.getId();
		this.nombre = bo.getNombre();
	}

	public IngredienteBean() {
		super();
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
