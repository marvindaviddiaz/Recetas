package umg.paginasweb.recetas.modelo;

/**
 * <font color="#000000">Clase que dara mantenimiento a los tipos de receta que se
 * podran configurar en el sistema. Ej.</font>
 * <font color="#000000">
 * </font><font color="#000000">
 * </font><font color="#000000">Platillo Tipico</font>
 * <font color="#000000">Sopa</font>
 * <font color="#000000">Ensalada</font>
 * @author marvin
 * @version 1.0
 * @created 26-oct-2012 06:59:29 a.m.
 */
public class TipoReceta extends AbstractBo {

	private String nombre;
	private String descripcion;

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