package prueva.ups.edu.ec.CRUDUniversidad.Modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name = "titulo")
@Table (name = "titulo")
public class Titulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    @Id
    private String Codigo;
	private String NomTitulo;
	private String NomUniversidad;
	private Date Fecha;
	@OneToOne
	@JoinColumn(name="PK_EstudianteDT")
	private Estudiante EstudianteDT;
	public String getNomTitulo() {
		return NomTitulo;
	}
	public void setNomTitulo(String nomTitulo) {
		NomTitulo = nomTitulo;
	}
	public String getNomUniversidad() {
		return NomUniversidad;
	}
	public void setNomUniversidad(String nomUniversidad) {
		NomUniversidad = nomUniversidad;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public Estudiante getEstudianteDT() {
		return EstudianteDT;
	}
	public void setEstudianteDT(Estudiante estudianteDT) {
		EstudianteDT = estudianteDT;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	
}
