package prueva.ups.edu.ec.CRUDUniversidad.Servicio;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import prueva.ups.edu.ec.CRUDUniversidad.Modelo.Estudiante;
import prueva.ups.edu.ec.CRUDUniversidad.Modelo.Titulo;
import prueva.ups.edu.ec.CRUDUniversidad.Negocio.GestionTituloON;

@Path("transacciones")
public class GestionTituloREST {
	@Inject
	private GestionTituloON gestionTituloON;
	
	@POST
	@Path("IngresoTitulo")
	@Consumes("application/json")
    @Produces("application/json")
	public Mensaje deposito(Titulo titulo) throws Exception {
    	Mensaje m = new Mensaje();
		try { 
			gestionTituloON.crearTitulo(titulo);
			m.setCode("ok");
			m.setMessage("Retiro exitoso");
			return m;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return m;
		} 
	}
	@POST
	@Path("IngresoPerona")
	@Consumes("application/json")
    @Produces("application/json")
	public Mensaje ingresoPersona(Estudiante estudiante) throws Exception {
    	Mensaje m = new Mensaje();
		try { 
			gestionTituloON.crearPersona(estudiante);
			m.setCode("ok");
			m.setMessage("Retiro exitoso");
			return m;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return m;
		} 
	}
	@GET
	@Path("listarTitulo")
	@Consumes("application/json")
   
	public Mensaje litaTulo(String cedula) throws Exception {
		Mensaje m = new Mensaje();
		try { 
			gestionTituloON.listaTitulos(cedula);
			m.setCode("ok");
			m.setMessage("Retiro exitoso");
			return m;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return m;
		} 
	}
	@GET
	@Path("IngresoPerona")
	@Consumes("application/json")
   
	public Mensaje Buscar(String cedula) throws Exception {
		Mensaje m = new Mensaje();
		try { 
			gestionTituloON.buscarEst(cedula);
			m.setCode("ok");
			m.setMessage("Retiro exitoso");
			return m;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return m;
		} 
	}
}
