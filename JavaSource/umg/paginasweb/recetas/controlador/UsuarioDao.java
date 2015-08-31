package umg.paginasweb.recetas.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Iterator; 


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import umg.paginasweb.recetas.modelo.AbstractBo;
import umg.paginasweb.recetas.modelo.DetalleIngrediente;
import umg.paginasweb.recetas.modelo.Receta;
import umg.paginasweb.recetas.modelo.Usuario;
 
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.hibernate.cfg.Configuration;

import com.sun.org.apache.regexp.internal.recompile;



public class UsuarioDao extends HibernateDaoSupport {
	private static SessionFactory factory; 
	   /*public static void main(String[] args) {
	      try{
	         factory = new Configuration().configure().buildSessionFactory();
	      }catch (Throwable ex) { 
	         System.err.println("Error new SessionFactory." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      UsuarioDao user = new UsuarioDao();

	      /* List down all the employees */
	      //user.listEmployees();

	      /* Print Total employee's count */
	     // user.countEmployee();

	      /* Print Toatl salary */
	      //user.totalSalary();
	   //}*}
	   // Method to CREATE an employee in the database */
/*	   public Integer addUsuario(String nombreUsuario, String clave, String rol){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      Integer userID = null;
	      
	      try{
	         tx = session.beginTransaction();
	         Usuario usuario = new Usuario(nombreUsuario, clave, rol);
	         userID = (Integer) session.save(usuario); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return userID;
	   }
	   
	*/   
	private String nombreUsuario;
	private String clave;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String validateUser(String nombreUsuario, String clave){
		
		 Query q = getSession().createQuery("from usuario where nombreUsuario = ?1 and clave = ?2");
		 q.setParameter(1, nombreUsuario).setParameter(2, clave);
		 q.setMaxResults(1);
		 Usuario usuario = (Usuario) q.uniqueResult();
		 if(usuario!=null)
			 return "home";
		 else 
			 return "";


		/*   //Transaction transaction = null;

		   Session session = factory.openSession();
		   //Usuario usu = new Usuario();
		      setLogin(false);
		     // Transaction tx = null;
		      		      
		      String user ="";
		      try{
		    	 //boolean user=false;
		    	
		        user=session.createCriteria(Usuario.class).add(Restrictions.eq("nombreUsuario","usuario" )).uniqueResult().toString();
	        	
//                 .add(Restrictions.eq("status", "new"))
//                 .add(Restrictions.eq("current", true));
//		         query.setParameter("employee_id",10);

		      } catch (HibernateException e) {		         
		    	  e.printStackTrace();
		      }		      	      
		      finally {
		         session.close();
		      }
		      if(user == "usuario")
		        	 return "home";
		         else
		        	 return "";*/
		   }
	   
	   
	/*public int getValidarUsuario(final String usuario) {
		return (Integer) getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				String user = "";
				if (usuario != null) {
					user = usuario;
				}
				return (Integer) session.createCriteria(Receta.class).add(Restrictions.eq("nombre", user.toString());
				//return (Integer) session.createCriteria(Receta.class).add(Restrictions.eq("nombre", user.trim())).add(Restrictions.eq("clave", value));
			}
		});*/
	}
	
	
	// public void addUser(net.roseindia.dao.hibernate.User obj)
	// throws DataAccessException {
	// getHibernateTemplate().save(obj);
	// }

