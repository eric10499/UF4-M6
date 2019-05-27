import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class Venta implements Serializable, PropertyChangeListener {
	
	private int numeroVenta;
	private int idProducto;
	private Date fecha;
	private int cantidad;
	private String Observaciones;
	
	private PropertyChangeSupport propertySupport;
	
	public Venta(int numeroVenta, int idProducto, Date fecha, int cantidad, String observaciones) {
		this.numeroVenta = numeroVenta;
		this.idProducto = idProducto;
		this.fecha = fecha;
		this.cantidad = cantidad;
		Observaciones = observaciones;
	}
	
	

	public Venta() {
		propertySupport = new PropertyChangeSupport (this);
	}



	public int getNumeroVenta() {
		return numeroVenta;
	}



	public void setNumeroVenta(int numeroVenta) {
		this.numeroVenta = numeroVenta;
	}



	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}



	public String getObservaciones() {
		return Observaciones;
	}



	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}



	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		BaseDatos baseDatos = new BaseDatos();
		ODB odb = baseDatos.getOdb();
		int ultimaVenta = baseDatos.consultarMaxVenta();
		Objects<Venta> objects = odb.getObjects(Venta.class);
		for(Venta venta : objects) {
			if(venta.getNumeroVenta() == ultimaVenta) {
				venta.setObservaciones("Pendiente de pedido por falta de stock");
				odb.store(venta);
			}
		}
	}

}
