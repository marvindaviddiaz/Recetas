package umg.paginasweb.recetas.modelo;

import java.util.List;
import java.util.Set;

/**
 * <font color="#000000">Clase que dara mantenimiento a losproveedores que se
 * podran configurar en el sistema.</font>
 * @author marvin
 * @version 1.0
 * @created 26-oct-2012 06:59:29 a.m.
 */
public class Proveedor extends AbstractBo{

	private String nombre;
	private String sitio;
	private String  logo;
	private Set<Producto> productos;
	
	
	public String getNombre() {
		return nombre;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public Set<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	

}