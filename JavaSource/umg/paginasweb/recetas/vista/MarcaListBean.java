package umg.paginasweb.recetas.vista;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import umg.paginasweb.recetas.modelo.Marca;

public class MarcaListBean extends AbstractListBean<MarcaBean> {

	public static final String BEAN_NAME = "marcaBean";
	public static final String BO_NAME = "Marca";

	public String getLoad() {
		this.fillList();
		return null;
	}

	public void fillList() {
		this.beans.clear();
		List<Marca> listado = (List<Marca>) this.getRecetasService().getListadoObjectos(BO_NAME);
		for (Marca bo : listado) {
			this.beans.add(new MarcaBean(bo));
		}
	}

	@Override
	public void loadBean() {
		String id = getRequestParameterMap().get(BEAN_SELECTED);
		if (id == null) {
			id = selectedBean.getId().toString();
		}
		Marca obj = (Marca) this.getRecetasService().getObjecto(Marca.class, Integer.parseInt(id));
		final MarcaBean bean = (MarcaBean) getSessionMap().get(BEAN_NAME);
		bean.loadBean(obj);
		this.editable = false;
	}

	public List<MarcaBean> getLista() {
		return this.beans;
	}

	public void saveAction() {
		final MarcaBean bean = (MarcaBean) getSessionMap().get(BEAN_NAME);
		if (bean.getId() == null) {
			Marca bo = new Marca();
			bo.setNombre(bean.getNombre());
			this.getRecetasService().saveObjecto(bo);
		} else {
			Marca bo = (Marca) this.getRecetasService().getObjecto(Marca.class, bean.getId());
			;
			bo.setNombre(bean.getNombre());
			this.getRecetasService().updateObjecto(bo);
		}
		this.fillList();
	}

	@Override
	public void clearFields() {
		final MarcaBean obj = (MarcaBean) getSessionMap().get(BEAN_NAME);
		obj.setId(null);
		obj.setNombre(null);
	}

	public void deleteAction() {
		MarcaBean bean = null;
		try {
			for (int a = 0; a < this.beans.size(); a++) {
				bean = beans.get(a);
				if (bean.getSelected() == true) {
					getRecetasService().deleteObjecto(Marca.class, bean.getId());
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

	public void setLista(List<MarcaBean> arg) {

	}

	public void setLoad(String load) {

	}

}
