package umg.paginasweb.recetas.vista;

import umg.paginasweb.recetas.modelo.Ingrediente;
import umg.paginasweb.recetas.modelo.Marca;
import umg.paginasweb.recetas.modelo.Producto;

public class ProductoBean extends AbstractBean<Producto> {

	private String nombre;
	private String descripcion;
	private Marca marca;
	private Integer marcaId;
	private Ingrediente ingrediente;
	private Integer ingredienteId;

	public ProductoBean(Producto bo) {
		super();
		this.id = bo.getId();
		this.nombre = bo.getNombre();
		this.descripcion = bo.getDescripcion();
		this.marca = bo.getMarca();
		this.marcaId = bo.getMarca().getId();
		this.ingrediente = bo.getIngredienteRelacionado();
		this.ingredienteId = bo.getIngredienteRelacionado().getId();
	}

	public void loadBean(Producto bo) {
		this.id = bo.getId();
		this.nombre = bo.getNombre();
		this.descripcion = bo.getDescripcion();
		this.marca = bo.getMarca();
		this.marcaId = bo.getMarca().getId();
		this.ingrediente = bo.getIngredienteRelacionado();
		this.ingredienteId = bo.getIngredienteRelacionado().getId();
	}

	public ProductoBean() {
		super();
	}

	public String getNombre() {
		return this.nombre;
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

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Integer getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
	}

	public Integer getIngredienteId() {
		return ingredienteId;
	}

	public void setIngredienteId(Integer ingredienteId) {
		this.ingredienteId = ingredienteId;
	}
	
}
