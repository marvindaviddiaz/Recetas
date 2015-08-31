package umg.paginasweb.recetas.modelo;

import java.util.List;

/**
 * <font color="#000000">Clase de mantenimiento que se encargara de almacenar
 * las recetas.</font>
 * 
 * @author marvin
 * @version 1.0
 * @created 26-oct-2012 06:59:29 a.m.
 */
public class Receta extends AbstractBo {

	private Integer id;
	private String nombre;
	private String descripcion;
	private TipoReceta tipoReceta;
	private String imagen;
	private List<DetalleIngrediente> detalleIngredientes;
	private String procedimiento;

	public static final String IMAGE_DEFAULT = "/recetas/images/burritos.jpg";

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoReceta getTipoReceta() {
		return tipoReceta;
	}

	public void setTipoReceta(TipoReceta tipoReceta) {
		this.tipoReceta = tipoReceta;
	}

	public List<DetalleIngrediente> getDetalleIngredientes() {
		return detalleIngredientes;
	}

	public void setDetalleIngredientes(List<DetalleIngrediente> detalleIngredientes) {
		this.detalleIngredientes = detalleIngredientes;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getImagen() {
		if (imagen == null) {
			return IMAGE_DEFAULT;
		}
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}