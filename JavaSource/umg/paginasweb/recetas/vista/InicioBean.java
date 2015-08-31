package umg.paginasweb.recetas.vista;

import java.util.ArrayList;
import java.util.List;

import umg.paginasweb.recetas.modelo.Receta;

public class InicioBean extends AbstractListBean<DetalleRecetaBean> {

	public static final String BEAN_NAME = "detalleRecetaBean";
	public static final String BO_NAME = "Receta";

	int paginaActual = 0;
	boolean mostrarListado = false;
	boolean showPrevPage, showNextPage;
	private String recetaSeleccionado, labelPaginas;
	private List<Receta> recetas = new ArrayList<Receta>();
	private String filtro;

	public String getLoad() {
		Integer recetas = getRecetasService().getNumeroRecetas(filtro);
		this.showPrevPage = (this.paginaActual > 0);
		if (recetas == 0) {
			this.showNextPage = false;
		} else {
			Integer recetasSiguientes = recetas - ((this.paginaActual + 1) * 3);
			this.showNextPage = recetasSiguientes > 0;
		}

		int paginaFinal = recetas / 3;
		if (recetas % 3 != 0) {
			paginaFinal++;
		}
		paginaFinal = (paginaFinal == 0) ? 1 : paginaFinal;
		this.labelPaginas = "Pag. " + (this.paginaActual + 1) + "/" + paginaFinal;

		fillList();
		return null;
	}

	public void fillList() {
		recetas = (List<Receta>) getRecetasService().getRecetasPorPagina(this.paginaActual, filtro);
	}

	public Receta[] getListaRecetas() {
		System.out.println("getListado");
		return recetas.toArray(new Receta[recetas.size()]);
	}

	public void setListaRecetas(List<Receta> recetas) {

	}

	public void mostrarListadoRecetas() {
		try {
			String id = getRequestParameterMap().get("recetaSeleccionada");
			if (id == null) {
				id = selectedBean.getId().toString();
			}
			Receta obj = (Receta) this.getRecetasService().getObjecto(Receta.class, Integer.parseInt(id));
			final DetalleRecetaBean bean = (DetalleRecetaBean) getSessionMap().get(BEAN_NAME);
			bean.setDetalleIngredientes(this.getRecetasService().getDetalleIngrediente(obj.getId()));
			bean.loadBean(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * METODOS DE CONVENCION PARA RICHFACES
	 */

	public void siguientePagineo() {
		this.paginaActual++;
	}

	public void anteriorPagineo() {
		this.paginaActual--;
		if (this.paginaActual < 0) {
			this.paginaActual = 0;
		}
	}

	public boolean isMostrarListado() {
		return this.mostrarListado;
	}

	public void setMostrarListado(boolean mostrarListado) {
		this.mostrarListado = mostrarListado;
	}

	public String getRecetaSeleccionado() {
		return this.recetaSeleccionado;
	}

	public void setRecetaSeleccionado(String recetaSeleccionado) {
		this.recetaSeleccionado = recetaSeleccionado;
	}

	public void setListaRecetas(Receta[] listadoRecetas) {

	}

	public boolean isShowPrevPage() {
		return this.showPrevPage;
	}

	public void setShowPrevPage(boolean showPrevPage) {
		this.showPrevPage = showPrevPage;
	}

	public boolean isShowNextPage() {
		return this.showNextPage;
	}

	public void setShowNextPage(boolean showNextPage) {
		this.showNextPage = showNextPage;
	}

	public String getLabelPaginas() {
		return this.labelPaginas;
	}

	public void setLabelPaginas(String labelPaginas) {
		this.labelPaginas = labelPaginas;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void setLoad(String load) {

	}

	@Override
	public void loadBean() {
	}

	@Override
	public void clearFields() {
	}
}
