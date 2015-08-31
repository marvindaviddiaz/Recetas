package umg.paginasweb.recetas.modelo;

/**
 * <font color="#000000">Clase que dar� mantenimiento a las distintas marcas que
 * puede pertenecer un proveedor.</font>
 * @author marvin
 * @version 1.0
 * @created 26-oct-2012 06:59:29 a.m.
 */
public class Marca  extends AbstractBo{

	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}