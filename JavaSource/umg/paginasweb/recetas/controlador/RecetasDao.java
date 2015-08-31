package umg.paginasweb.recetas.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import umg.paginasweb.recetas.modelo.AbstractBo;
import umg.paginasweb.recetas.modelo.DetalleIngrediente;
import umg.paginasweb.recetas.modelo.Receta;

public class RecetasDao extends HibernateDaoSupport {

	public List<?> getLitadoObjectos(String clazz) {
		return this.getHibernateTemplate().find("from " + clazz);
	}

	@SuppressWarnings({ "unchecked" })
	public List<Receta> getRecetasPorPagina(final int pagina, final String nombre) {
		return (List<Receta>) getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public List<Receta> doInHibernate(Session session) throws HibernateException, SQLException {
				String name = "";
				if (nombre != null) {
					name = nombre;
				}
				return session.createCriteria(Receta.class).add(Restrictions.like("nombre", "%" + name.trim() + "%")).setMaxResults(3).setFirstResult(pagina * 3).list();
			}
		});
	}

	@SuppressWarnings({ "unchecked" })
	public List<DetalleIngrediente> getDetalleIngrediente(final Integer recetaId) {
		return (List<DetalleIngrediente>) getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public List<DetalleIngrediente> doInHibernate(Session session) throws HibernateException, SQLException {
				return session.createCriteria(DetalleIngrediente.class).add(Restrictions.eq("receta.id", recetaId)).list();
			}
		});
	}

	public int getNumeroRecetas(final String filter) {
		return (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				String name = "";
				if (filter != null) {
					name = filter;
				}
				return (Integer) session.createCriteria(Receta.class).add(Restrictions.like("nombre", "%" + name.trim() + "%")).setProjection(Projections.rowCount()).uniqueResult();
			}
		});
	}

	public AbstractBo getObjecto(Class clazz, Integer id) {
		return (AbstractBo) this.getHibernateTemplate().get(clazz, id);
	}

	public void saveObjecto(AbstractBo bo) {
		this.getHibernateTemplate().save(bo);
	}

	public void updateObjecto(AbstractBo bo) {
		this.getHibernateTemplate().update(bo);
	}

	public void deleteObjecto(Class clazz, Integer id) {
		this.getHibernateTemplate().delete(getObjecto(clazz, id));
	}

}
