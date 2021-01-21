package prueva.ups.edu.ec.CRUDUniversidad.Modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "estudiante")
@Table (name = "estudiante")
public class Estudiante  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String Cedula;
	private String Nombre;
	
	@OneToMany()
	@JoinColumn(name="detalles")
	private List<Titulo> detalles;

	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public List<Titulo> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Titulo> detalles) {
		this.detalles = detalles;
	}

	
	
}
