package prueva.ups.edu.ec.CRUDUniversidad.DAO;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import prueva.ups.edu.ec.CRUDUniversidad.Modelo.Estudiante;


@Stateless
public class EstudianteDAO implements Serializable {
	
	/**
 * 
 */
private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	public boolean Crearcuenta(Estudiante entity) throws Exception {
		boolean estado = true;
		try {
			em.persist(entity);
			estado = true;
		} catch (Exception e) {
			estado = false;
			throw new Exception("Erro en crear Estudiante " + e.getMessage());

		}

		return estado;
	}
	public Estudiante Buscar(String cedula) throws Exception {
		try {
			
			return em.find(Estudiante.class, cedula);
		} catch (Exception e) {
			throw new Exception("Erro leer  " + e.getMessage());
		}
	}

}
