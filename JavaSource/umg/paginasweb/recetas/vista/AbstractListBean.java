package umg.paginasweb.recetas.vista;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import umg.paginasweb.recetas.controlador.RecetasService;

public abstract class AbstractListBean<T extends AbstractBean> {

	public List<T> beans = new ArrayList<T>();
	public boolean editable;
	private final RecetasService recetasService;
	protected ApplicationContext appContext;
	public String labelBotonBack;
	public static final String BEAN_SELECTED = "BEAN_SELECTED";
	public T selectedBean;
	public boolean selectedAll;

	public AbstractListBean() {
		super();
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		this.appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		this.recetasService = (RecetasService) this.lookupService("recetasService");
	}

	private Object lookupService(String serviceBeanName) {
		return this.appContext.getBean(serviceBeanName);
	}

	public abstract void loadBean();

	public abstract void clearFields();

	public void addAction() {
		this.clearFields();
		this.editable = true;
	}

	public void editAction() {
		int cont = 0;
		for (final T bean : this.beans) {
			if (bean.getSelected() == true) {
				cont++;
				selectedBean = bean;
			}
			if (cont > 1) {
				addMessage("Debe seleccionar solamente un registro");
				return;
			}
		}
		if (cont == 0) {
			addMessage("Debe seleccionar un registro");
		}
		this.loadBean();
		this.editable = true;
	}

	public void seleccionarAll() {
		for (final T bean : this.beans) {
			bean.setSelected(!selectedAll);
		}
	}

	public HttpSession getSession() {
		return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getSession(false);
	}

	public Map<String, Object> getSessionMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	}

	public Map<String, String> getRequestParameterMap() {
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
	}

	public RecetasService getRecetasService() {
		return this.recetasService;
	}

	public void addMessage(String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje));
	}

	public String getLabelBotonBack() {
		return editable ? "Cancelar" : "Regresar";
	}

	public void setLabelBotonBack(String labelBotonBack) {
		this.labelBotonBack = labelBotonBack;
	}

}
