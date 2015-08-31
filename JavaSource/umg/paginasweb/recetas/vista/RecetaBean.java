package umg.paginasweb.recetas.vista;

import umg.paginasweb.recetas.modelo.Receta;
import umg.paginasweb.recetas.modelo.TipoReceta;

public class RecetaBean extends AbstractBean<Receta> {

	private String nombre;
	private String descripcion;
	private TipoReceta tipoReceta;
	private Integer tipoRecetaId;
	private String procedimiento;

	public RecetaBean(Receta bo) {
		super();
		this.id = bo.getId();
		this.nombre = bo.getNombre();
		this.descripcion = bo.getDescripcion();
		this.tipoReceta = bo.getTipoReceta();
		this.tipoRecetaId = bo.getTipoReceta().getId();
		this.procedimiento = bo.getProcedimiento();
	}

	public void loadBean(Receta bo) {
		this.id = bo.getId();
		this.nombre = bo.getNombre();
		this.descripcion = bo.getDescripcion();
		this.tipoReceta = bo.getTipoReceta();
		this.tipoRecetaId = bo.getTipoReceta().getId();
		this.procedimiento = bo.getProcedimiento();
	}

	public RecetaBean() {
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

	public TipoReceta getTipoReceta() {
		return tipoReceta;
	}

	public void setTipoReceta(TipoReceta tipoReceta) {
		this.tipoReceta = tipoReceta;
	}

	public Integer getTipoRecetaId() {
		return tipoRecetaId;
	}

	public void setTipoRecetaId(Integer tipoRecetaId) {
		this.tipoRecetaId = tipoRecetaId;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}
}
