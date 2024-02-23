package cinesElorrieta.modelo;

public class SesionTmp {

	
    private String duracion;
    private double precio;
    private String fecha;
    private String horario;
    private String nombreSala;
	public SesionTmp(String duracion, double precio, String fecha, String horario, String nombreSala) {
		super();
		this.duracion = duracion;
		this.precio = precio;
		this.fecha = fecha;
		this.horario = horario;
		this.nombreSala = nombreSala;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getNombreSala() {
		return nombreSala;
	}
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}
    
    

}
