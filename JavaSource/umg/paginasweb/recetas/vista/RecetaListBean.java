package umg.paginasweb.recetas.vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.dao.DataIntegrityViolationException;

import umg.paginasweb.recetas.modelo.Receta;
import umg.paginasweb.recetas.modelo.TipoReceta;

public class RecetaListBean extends AbstractListBean<RecetaBean> {

	public static final String BEAN_NAME = "recetaBean";
	public static final String BO_NAME = "Receta";

	public List<TipoReceta> tiposRecetas = new ArrayList<TipoReceta>();
	public List<SelectItem> tiposRecetasItem = new ArrayList<SelectItem>();

	public String getLoad() {
		this.fillList();
		return null;
	}

	public void fillList() {
		this.beans.clear();
		List<Receta> listado = (List<Receta>) this.getRecetasService().getListadoObjectos(BO_NAME);
		for (Receta bo : listado) {
			this.beans.add(new RecetaBean(bo));
		}

		this.tiposRecetas = (List<TipoReceta>) this.getRecetasService().getListadoObjectos("TipoReceta");
	}

	@Override
	public void loadBean() {
		String id = getRequestParameterMap().get(BEAN_SELECTED);
		if (id == null) {
			id = selectedBean.getId().toString();
		}
		Receta obj = (Receta) this.getRecetasService().getObjecto(Receta.class, Integer.parseInt(id));
		final RecetaBean bean = (RecetaBean) getSessionMap().get(BEAN_NAME);
		bean.loadBean(obj);
		this.editable = false;
	}

	public List<RecetaBean> getLista() {
		return this.beans;
	}

	public void saveAction() {
		final RecetaBean bean = (RecetaBean) getSessionMap().get(BEAN_NAME);
		if (bean.getId() == null) {
			Receta bo = new Receta();
			bo.setNombre(bean.getNombre());
			bo.setDescripcion(bean.getDescripcion());
			bo.setProcedimiento(bean.getProcedimiento());
			if (bean.getTipoRecetaId() != null) {
				bo.setTipoReceta((TipoReceta) getRecetasService().getObjecto(TipoReceta.class, bean.getTipoRecetaId()));
			}
			this.getRecetasService().saveObjecto(bo);
		} else {
			Receta bo = (Receta) this.getRecetasService().getObjecto(Receta.class, bean.getId());
			bo.setNombre(bean.getNombre());
			bo.setDescripcion(bean.getDescripcion());
			bo.setProcedimiento(bean.getProcedimiento());
			if (bean.getTipoRecetaId() != null) {
				bo.setTipoReceta((TipoReceta) getRecetasService().getObjecto(TipoReceta.class, bean.getTipoRecetaId()));
			}
			this.getRecetasService().updateObjecto(bo);
		}
		this.fillList();
	}

	@Override
	public void clearFields() {
		final RecetaBean obj = (RecetaBean) getSessionMap().get(BEAN_NAME);
		obj.setId(null);
		obj.setNombre(null);
		obj.setDescripcion(null);
		obj.setProcedimiento(null);
		obj.setTipoReceta(null);
		obj.setTipoRecetaId(null);
	}

	public void deleteAction() {
		RecetaBean bean = null;
		try {
			for (int a = 0; a < this.beans.size(); a++) {
				bean = beans.get(a);
				if (bean.getSelected() == true) {
					getRecetasService().deleteObjecto(Receta.class, bean.getId());
				}
			}
		} catch (DataIntegrityViolationException e) {
			addMessage("No se puede eliminar el registro '" + bean.getNombre() + "' ya que tiene registros relacionados");
		}

		fillList();
	}

	public List<SelectItem> getTiposRecetasItem() {
		tiposRecetasItem.clear();
		for (TipoReceta bo : tiposRecetas) {
			tiposRecetasItem.add(new SelectItem(bo.getId(), bo.getNombre()));
		}
		return tiposRecetasItem;
	}

	public void setTiposRecetasItem(List<SelectItem> items) {
		this.tiposRecetasItem = items;
	}

	public boolean isEditable() {
		return this.editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void setLista(List<RecetaBean> arg) {

	}

	public void setLoad(String load) {

	}

}
