package umg.paginasweb.recetas.vista;


public abstract class AbstractBean<Z> {

	protected Integer id;
	protected boolean selected;
	
	public Boolean getSelected() {
		return this.selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
