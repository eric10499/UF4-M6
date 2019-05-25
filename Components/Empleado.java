import java.beans.*;
import java.io.Serializable;


@SuppressWarnings("serial")
public class Empleado implements Serializable {

	public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
	private String nif;
	private String nombre;
	private String cargo;
	private float sueldo;

	private PropertyChangeSupport propertySupport;

	public Empleado () {
		propertySupport = new PropertyChangeSupport (this);
		this.cargo = "Junior";
		this.sueldo = 1000;
	}

	public Empleado (String nif, String nombre) {
		this();
		propertySupport = new PropertyChangeSupport(this);
		this.nif = nif;
		this.nombre = nombre;

	}

	public void addPropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener (PropertyChangeListener listener) {
		propertySupport.removePropertyChangeListener(listener);
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		if(cargo.isEmpty() || cargo.equals(null)) {
			System.out.println("Error");
		} else {
			propertySupport.firePropertyChange("cargo", this.cargo, cargo);
			this.cargo = cargo;
		}
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		if(sueldo > 0) {
			propertySupport.firePropertyChange("sueldo", this.sueldo, sueldo);
			this.sueldo = sueldo;
		} else {
			System.out.println("Error");
		}
	}

	public PropertyChangeSupport getPropertySupport() {
		return propertySupport;
	}

	public void setPropertySupport(PropertyChangeSupport propertySupport) {
		this.propertySupport = propertySupport;
	}

}
