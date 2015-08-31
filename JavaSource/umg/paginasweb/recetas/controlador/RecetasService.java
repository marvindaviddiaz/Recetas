package umg.paginasweb.recetas.controlador;

import java.util.List;

import umg.paginasweb.recetas.modelo.AbstractBo;
import umg.paginasweb.recetas.modelo.DetalleIngrediente;
import umg.paginasweb.recetas.modelo.Receta;

public class RecetasService {

	private RecetasDao recetasDao;

	public List<?> getListadoObjectos(String clazz) {
		return this.recetasDao.getLitadoObjectos(clazz);
	}

	public AbstractBo getObjecto(Class clazz, Integer id) {
		return this.recetasDao.getObjecto(clazz, id);
	}

	public void saveObjecto(AbstractBo bo) {
		this.recetasDao.saveObjecto(bo);
	}

	public void updateObjecto(AbstractBo bo) {
		this.recetasDao.updateObjecto(bo);
	}

	public void deleteObjecto(Class clazz, Integer id) {
		this.recetasDao.deleteObjecto(clazz, id);
	}

	public int getNumeroRecetas(String filter) {
		return this.recetasDao.getNumeroRecetas(filter);
	}

	public List<Receta> getRecetasPorPagina(int pagina, String nombre) {
		return this.recetasDao.getRecetasPorPagina(pagina, nombre);
	}

	public RecetasDao getRecetasDao() {
		return this.recetasDao;
	}

	public List<DetalleIngrediente> getDetalleIngrediente(Integer recetaId){
		return this.recetasDao.getDetalleIngrediente(recetaId);
	}
	
	public void setRecetasDao(RecetasDao recetasDao) {
		this.recetasDao = recetasDao;
	}

}
