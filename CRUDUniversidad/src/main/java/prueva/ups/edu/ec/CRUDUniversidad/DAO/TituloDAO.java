package prueva.ups.edu.ec.CRUDUniversidad.DAO;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import prueva.ups.edu.ec.CRUDUniversidad.Modelo.Titulo;


@Stateless
public class TituloDAO implements Serializable {
	
	/**
 * 
 */
private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;

	public boolean Crearcuenta(Titulo entity) throws Exception {
		boolean estado = true;
		try {
			em.persist(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro en crear titulo " + e.getMessage());

		}

		return estado;
	}
	public List<Titulo>listaTitulo(String Cedula) throws Exception {
		try {
			 Query query = em.createNativeQuery("SELECT * FROM Titulo",Titulo.class);
			 query.setParameter(1, Cedula);
			 return  query.getResultList();
		     
	} catch(NoResultException e) {
	    return null;
	  }
		

	}
}
