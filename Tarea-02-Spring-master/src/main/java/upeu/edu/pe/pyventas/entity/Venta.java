package upeu.edu.pe.pyventas.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Venta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int idventas;
	private String fecha;
	
	public int getIdventas() {
		return idventas;
	}
	public void setIdventas(int idventas) {
		this.idventas = idventas;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
