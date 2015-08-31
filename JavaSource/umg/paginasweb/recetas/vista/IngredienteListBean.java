package umg.paginasweb.recetas.vista;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import umg.paginasweb.recetas.modelo.Ingrediente;

public class IngredienteListBean extends AbstractListBean<IngredienteBean> {

	public static final String BEAN_NAME = "ingredienteBean";
	public static final String BO_NAME = "Ingrediente";

	public String getLoad() {
		this.fillList();
		return null;
	}

	public void fillList() {
		this.beans.clear();
		List<Ingrediente> listado = (List<Ingrediente>) this.getRecetasService().getListadoObjectos(BO_NAME);
		for (Ingrediente bo : listado) {
			this.beans.add(new IngredienteBean(bo));
		}
	}

	@Override
	public void loadBean() {
		String id = getRequestParameterMap().get(BEAN_SELECTED);
		if (id == null) {
			id = selectedBean.getId().toString();
		}
		Ingrediente obj = (Ingrediente) this.getRecetasService().getObjecto(Ingrediente.class, Integer.parseInt(id));
		final IngredienteBean bean = (IngredienteBean) getSessionMap().get(BEAN_NAME);
		bean.loadBean(obj);
		this.editable = false;
	}

	public List<IngredienteBean> getLista() {
		return this.beans;
	}

	public void saveAction() {
		final IngredienteBean bean = (IngredienteBean) getSessionMap().get(BEAN_NAME);
		if (bean.getId() == null) {
			Ingrediente bo = new Ingrediente();
			bo.setNombre(bean.getNombre());
			this.getRecetasService().saveObjecto(bo);
		} else {
			Ingrediente bo = (Ingrediente) this.getRecetasService().getObjecto(Ingrediente.class, bean.getId());
			;
			bo.setNombre(bean.getNombre());
			this.getRecetasService().updateObjecto(bo);
		}
		this.fillList();
	}

	@Override
	public void clearFields() {
		final IngredienteBean obj = (IngredienteBean) getSessionMap().get(BEAN_NAME);
		obj.setId(null);
		obj.setNombre(null);
	}

	public void deleteAction() {
		IngredienteBean bean = null;
		try {
			for (int a = 0; a < this.beans.size(); a++) {
				bean = beans.get(a);
				if (bean.getSelected() == true) {
					getRecetasService().deleteObjecto(Ingrediente.class, bean.getId());
				}
			}
		} catch (DataIntegrityViolationException e) {
			addMessage("No se puede eliminar el registro '" + bean.getNombre() + "' ya que tiene registros relacionados");
		}

		fillList();
	}

	public boolean isEditable() {
		return this.editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void setLista(List<IngredienteBean> arg) {

	}

	public void setLoad(String load) {

	}

}
