package umg.paginasweb.recetas.vista;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import umg.paginasweb.recetas.modelo.Usuario;

public class UserListBean extends AbstractListBean<UserBean> {

	public static final String BEAN_NAME = "userBean";
	public static final String BO_NAME = "Usuario";

	public String getLoad() {
		this.fillList();
		return null;
	}
	
	public void fillList() {
		this.beans.clear();
		List<Usuario> listado = (List<Usuario>) this.getRecetasService().getListadoObjectos(BO_NAME);
		for (Usuario bo : listado) {
			this.beans.add(new UserBean(bo));
		}
	}

	@Override
	public void loadBean() {
		String id = getRequestParameterMap().get(BEAN_SELECTED);
		if (id == null) {
			id = selectedBean.getId().toString();
		}
		Usuario obj = (Usuario) this.getRecetasService().getObjecto(Usuario.class, Integer.parseInt(id));
		final UserBean bean = (UserBean) getSessionMap().get(BEAN_NAME);
		bean.loadBean(obj);
		this.editable = false;
	}

	public List<UserBean> getLista() {
		return this.beans;
	}

	public void saveAction() {
		final UserBean bean = (UserBean) getSessionMap().get(BEAN_NAME);
		if (bean.getId() == null) {
			Usuario bo = new Usuario();
			bo.setNombreUsuario(bean.getNombreUsuario());
			bo.setClave(bean.getClave());
			bo.setCorreo(bean.getCorreo());
			bo.setNombre(bean.getNombre());
			bo.setApellido(bean.getApellido());
			bo.setRol(bean.getRol());			
			this.getRecetasService().saveObjecto(bo);
		} else {
			Usuario bo = (Usuario) this.getRecetasService().getObjecto(Usuario.class, bean.getId());
			bo.setNombreUsuario(bean.getNombreUsuario());
			bo.setClave(bean.getClave());
			bo.setCorreo(bean.getCorreo());
			bo.setNombre(bean.getNombre());
			bo.setApellido(bean.getApellido());
			bo.setRol(bean.getRol());
			this.getRecetasService().updateObjecto(bo);
		}
		this.fillList();
	}
	
	

	@Override
	public void clearFields() {
		final UserBean obj = (UserBean) getSessionMap().get(BEAN_NAME);
		obj.setId(null);
		obj.setNombreUsuario(null);
		obj.setClave(null);
		obj.setCorreo(null);
		obj.setNombre(null);
		obj.setApellido(null);
		obj.setRol(null);		
	}

	public void deleteAction() {
		UserBean bean = null;
		try {
			for (int a = 0; a < this.beans.size(); a++) {
				bean = beans.get(a);
				if (bean.getSelected() == true) {
					getRecetasService().deleteObjecto(Usuario.class, bean.getId());
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
