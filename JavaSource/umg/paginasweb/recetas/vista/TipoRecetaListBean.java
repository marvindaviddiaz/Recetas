package umg.paginasweb.recetas.vista;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import umg.paginasweb.recetas.modelo.TipoReceta;

public class TipoRecetaListBean extends AbstractListBean<TipoRecetaBean> {

	public static final String BEAN_NAME = "tipoRecetaBean";
	public static final String BO_NAME = "TipoReceta";

	public String getLoad() {
		this.fillList();
		return null;
	}

	public void fillList() {
		this.beans.clear();
		List<TipoReceta> listado = (List<TipoReceta>) this.getRecetasService().getListadoObjectos(BO_NAME);
		for (TipoReceta bo : listado) {
			this.beans.add(new TipoRecetaBean(bo));
		}
	}

	@Override
	public void loadBean() {
		String id = getRequestParameterMap().get(BEAN_SELECTED);
		if (id == null) {
			id = selectedBean.getId().toString();
		}
		TipoReceta obj = (TipoReceta) this.getRecetasService().getObjecto(TipoReceta.class, Integer.parseInt(id));
		final TipoRecetaBean bean = (TipoRecetaBean) getSessionMap().get(BEAN_NAME);
		bean.loadBean(obj);
		this.editable = false;
	}

	public List<TipoRecetaBean> getLista() {
		return this.beans;
	}

	public void saveAction() {
		final TipoRecetaBean bean = (TipoRecetaBean) getSessionMap().get(BEAN_NAME);
		if (bean.getId() == null) {
			TipoReceta bo = new TipoReceta();
			bo.setNombre(bean.getNombre());
			bo.setDescripcion(bean.getDescripcion());
			this.getRecetasService().saveObjecto(bo);
		} else {
			TipoReceta bo = (TipoReceta) this.getRecetasService().getObjecto(TipoReceta.class, bean.getId());
			;
			bo.setNombre(bean.getNombre());
			bo.setDescripcion(bean.getDescripcion());
			this.getRecetasService().updateObjecto(bo);
		}
		this.fillList();
	}

	@Override
	public void clearFields() {
		final TipoRecetaBean obj = (TipoRecetaBean) getSessionMap().get(BEAN_NAME);
		obj.setId(null);
		obj.setNombre(null);
		obj.setDescripcion(null);
	}
	
	public void deleteAction(){
		TipoRecetaBean bean = null;
		try {
			for (int a = 0; a<this.beans.size(); a++) {
				bean = beans.get(a);
				if (bean.getSelected() == true) {
					getRecetasService().deleteObjecto(TipoReceta.class, bean.getId());
				}
			}
		} catch (DataIntegrityViolationException e) {
			addMessage("No se puede eliminar el registro '" + bean.getNombre() +  "' ya que tiene registros relacionados");
		}
		
		
		fillList();
	}

	public boolean isEditable() {
		return this.editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void setLista(List<TipoRecetaBean> arg) {

	}

	public void setLoad(String load) {

	}

}
