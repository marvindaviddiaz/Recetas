package umg.paginasweb.recetas.vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.springframework.dao.DataIntegrityViolationException;

import umg.paginasweb.recetas.modelo.Ingrediente;
import umg.paginasweb.recetas.modelo.Marca;
import umg.paginasweb.recetas.modelo.Producto;

public class ProductoListBean extends AbstractListBean<ProductoBean> {

	public static final String BEAN_NAME = "productoBean";
	public static final String BO_NAME = "Producto";

	public List<Marca> marcas = new ArrayList<Marca>();
	public List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

	public List<SelectItem> marcasItem = new ArrayList<SelectItem>();
	public List<SelectItem> ingredientesItem = new ArrayList<SelectItem>();

	public String getLoad() {
		this.fillList();
		return null;
	}

	public void fillList() {
		this.beans.clear();
		List<Producto> listado = (List<Producto>) this.getRecetasService().getListadoObjectos(BO_NAME);
		for (Producto bo : listado) {
			this.beans.add(new ProductoBean(bo));
		}

		this.marcas = (List<Marca>) this.getRecetasService().getListadoObjectos("Marca");
		this.ingredientes = (List<Ingrediente>) this.getRecetasService().getListadoObjectos("Ingrediente");
	}

	@Override
	public void loadBean() {
		String id = getRequestParameterMap().get(BEAN_SELECTED);
		if (id == null) {
			id = selectedBean.getId().toString();
		}
		Producto obj = (Producto) this.getRecetasService().getObjecto(Producto.class, Integer.parseInt(id));
		final ProductoBean bean = (ProductoBean) getSessionMap().get(BEAN_NAME);
		bean.loadBean(obj);
		this.editable = false;
	}

	public List<ProductoBean> getLista() {
		return this.beans;
	}

	public void saveAction() {
		final ProductoBean bean = (ProductoBean) getSessionMap().get(BEAN_NAME);
		if (bean.getId() == null) {
			Producto bo = new Producto();
			bo.setNombre(bean.getNombre());
			bo.setDescripcion(bean.getDescripcion());
			if (bean.getIngredienteId() != null) {
				bo.setIngredienteRelacionado((Ingrediente) getRecetasService().getObjecto(Ingrediente.class, bean.getIngredienteId()));
			}
			if (bean.getMarcaId() != null) {
				bo.setMarca((Marca) getRecetasService().getObjecto(Marca.class, bean.getMarcaId()));
			}
			this.getRecetasService().saveObjecto(bo);
		} else {
			Producto bo = (Producto) this.getRecetasService().getObjecto(Producto.class, bean.getId());
			bo.setNombre(bean.getNombre());
			bo.setDescripcion(bean.getDescripcion());
			if (bean.getIngredienteId() != null) {
				bo.setIngredienteRelacionado((Ingrediente) getRecetasService().getObjecto(Ingrediente.class, bean.getIngredienteId()));
			}
			if (bean.getMarcaId() != null) {
				bo.setMarca((Marca) getRecetasService().getObjecto(Marca.class, bean.getMarcaId()));
			}
			this.getRecetasService().updateObjecto(bo);
		}
		this.fillList();
	}

	@Override
	public void clearFields() {
		final ProductoBean obj = (ProductoBean) getSessionMap().get(BEAN_NAME);
		obj.setId(null);
		obj.setNombre(null);
		obj.setDescripcion(null);
		obj.setMarcaId(null);
		obj.setMarca(null);
		obj.setIngredienteId(null);
		obj.setIngrediente(null);
	}

	public void deleteAction() {
		ProductoBean bean = null;
		try {
			for (int a = 0; a < this.beans.size(); a++) {
				bean = beans.get(a);
				if (bean.getSelected() == true) {
					getRecetasService().deleteObjecto(Producto.class, bean.getId());
				}
			}
		} catch (DataIntegrityViolationException e) {
			addMessage("No se puede eliminar el registro '" + bean.getNombre() + "' ya que tiene registros relacionados");
		}

		fillList();
	}

	public List<SelectItem> getMarcasItem() {
		marcasItem.clear();
		for (Marca bo : marcas) {
			marcasItem.add(new SelectItem(bo.getId(), bo.getNombre()));
		}
		return marcasItem;
	}

	public void setMarcasItem(List<SelectItem> marcasItem) {
		this.marcasItem = marcasItem;
	}

	public List<SelectItem> getIngredientesItem() {
		ingredientesItem.clear();
		for (Ingrediente bo : ingredientes) {
			ingredientesItem.add(new SelectItem(bo.getId(), bo.getNombre()));
		}
		return ingredientesItem;
	}

	public void setIngredientesItem(List<SelectItem> ingredientesItem) {
		this.ingredientesItem = ingredientesItem;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public List<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public boolean isEditable() {
		return this.editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public void setLista(List<ProductoBean> arg) {

	}

	public void setLoad(String load) {

	}

}
