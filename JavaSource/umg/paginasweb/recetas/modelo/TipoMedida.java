package umg.paginasweb.recetas.modelo;

/**
 * Clase que manejara los tipos de medidas en que se mediran los ingredientes para
 * una receta. Ej.
 * 
 * Cucharada
 * Onza
 * Libra
 * @author marvin
 * @version 1.0
 * @created 26-oct-2012 06:59:29 a.m.
 */
public class TipoMedida {

	private Integer  id;
	private String nombre;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}