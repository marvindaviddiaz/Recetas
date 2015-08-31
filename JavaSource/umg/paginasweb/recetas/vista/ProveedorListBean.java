package umg.paginasweb.recetas.vista;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import umg.paginasweb.recetas.modelo.Proveedor;

public class ProveedorListBean extends AbstractListBean<ProveedorBean> {

	public static final String BEAN_NAME = "proveedorBean";
	public static final String BO_NAME = "Proveedor";

	public String getLoad() {
		this.fillList();
		return null;
	}

	public void fillList() {
		this.beans.clear();
		List<Proveedor> listado = (List<Proveedor>) this.getRecetasService().getListadoObjectos(BO_NAME);
		for (Proveedor bo : listado) {
			this.beans.add(new ProveedorBean(bo));
		}
	}

	@Override
	public void loadBean() {
		String id = getRequestParameterMap().get(BEAN_SELECTED);
		if (id == null) {
			id = selectedBean.getId().toString();
		}
		Proveedor obj = (Proveedor) this.getRecetasService().getObjecto(Proveedor.class, Integer.parseInt(id));
		final ProveedorBean bean = (ProveedorBean) getSessionMap().get(BEAN_NAME);
		bean.loadBean(obj);
		this.editable = false;
	}

	public List<ProveedorBean> getLista() {
		return this.beans;
	}

	public void saveAction() {
		final ProveedorBean bean = (ProveedorBean) getSessionMap().get(BEAN_NAME);
		if (bean.getId() == null) {
			Proveedor bo = new Proveedor();
			bo.setNombre(bean.getNombre());
			bo.setSitio(bean.getSitio());
			this.getRecetasService().saveObjecto(bo);
		} else {
			Proveedor bo = (Proveedor) this.getRecetasService().getObjecto(Proveedor.class, bean.getId());
			bo.setNombre(bean.getNombre());
			bo.setSitio(bean.getSitio());
			this.getRecetasService().updateObjecto(bo);
		}
		this.fillList();
	}

	@Override
	public void clearFields() {
		final ProveedorBean obj = (ProveedorBean) getSessionMap().get(BEAN_NAME);
		obj.setId(null);
		obj.setNombre(null);
		obj.setSitio(null);
	}

	public void deleteAction() {
		ProveedorBean bean = null;
		try {
			for (int a = 0; a < this.beans.size(); a++) {
				bean = beans.get(a);
				if (bean.getSelected() == true) {
					getRecetasService().deleteObjecto(Proveedor.class, bean.getId());
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

	public void setLista(List<ProveedorBean> arg) {

	}

	public void setLoad(String load) {

	}

}
