package prueva.ups.edu.ec.CRUDUniversidad.Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import prueva.ups.edu.ec.CRUDUniversidad.DAO.EstudianteDAO;
import prueva.ups.edu.ec.CRUDUniversidad.DAO.TituloDAO;
import prueva.ups.edu.ec.CRUDUniversidad.Modelo.Estudiante;
import prueva.ups.edu.ec.CRUDUniversidad.Modelo.Titulo;

@Stateless
public class GestionTituloON {
	@Inject
	private EstudianteDAO estudianteDAO;
	@Inject
	private TituloDAO tituloDAO;
	
	public boolean crearPersona(Estudiante estudiante) throws Exception {
		return estudianteDAO.Crearcuenta(estudiante);
	}
	public boolean crearTitulo(Titulo titulo) throws Exception {
		return tituloDAO.Crearcuenta(titulo);
	}
	public List<Titulo>listaTitulos(String Cedula) throws Exception {
		return tituloDAO.listaTitulo(Cedula);
	}
	public Estudiante buscarEst(String cedula) throws Exception {
		return estudianteDAO.Buscar(cedula);
	}
}
