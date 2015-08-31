package umg.paginasweb.recetas.modelo;

/**
 * <font color="#000000">Clase que tiene la relacion entre un ingrediente un
 * tipo de medida y la cantidad, para una receta en espec�fico. Ej:</font>
 * <font color="#000000"> </font><font color="#000000">2 - Onz - Azucar.</font>
 * 
 * @author marvin
 * @version 1.0
 * @created 26-oct-2012 06:59:29 a.m.
 */
public class DetalleIngrediente extends AbstractBo {

	private Integer cantidad;
	private TipoMedida tipoMedida;
	private Ingrediente ingrediente;
	private Receta receta;


	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public TipoMedida getTipoMedida() {
		return tipoMedida;
	}

	public void setTipoMedida(TipoMedida tipoMedida) {
		this.tipoMedida = tipoMedida;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

}