package umg.paginasweb.recetas.modelo;

/**
 * <font color="#000000">Clase que dara mantenimiento a los productos que vende un
 * cliente.</font>
 * @author marvin
 * @version 1.0
 * @created 26-oct-2012 06:59:29 a.m.
 */
public class Producto extends AbstractBo {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Marca marca;
	private Ingrediente ingredienteRelacionado;
	
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
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Ingrediente getIngredienteRelacionado() {
		return ingredienteRelacionado;
	}
	public void setIngredienteRelacionado(Ingrediente ingredienteRelacionado) {
		this.ingredienteRelacionado = ingredienteRelacionado;
	}



	


}