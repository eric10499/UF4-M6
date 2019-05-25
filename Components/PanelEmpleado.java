import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
@SuppressWarnings("serial")
public class PanelEmpleado extends PropertyException implements Serializable, PropertyChangeListener {     
	private Empleado empleado;
	private int limiteVariacionSueldo;
	private String[] listaDeCargos = {"Junior", "SemiSenior", "Analista", "CEO"};   
	public PanelEmpleado() {
		this.limiteVariacionSueldo = 10;
	}
	public PanelEmpleado (int valor, Empleado empleado) {
		this.limiteVariacionSueldo = valor;
		this.empleado = empleado;

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt)  {
		if((evt.getPropertyName()).equals("cargo")) {
			int contador = 0;
			String newValueCargo = (String) evt.getNewValue();
			System.out.printf("Cargo anterior: %s%n",evt.getOldValue());
			System.out.printf("Cargo actual: %s%n",evt.getNewValue());
			System.out.printf("REALIZAR CAMBIO EN EMPLEADO: %s%n",empleado.getNombre());
			for(String cargo : listaDeCargos) {
				if(cargo.equals(newValueCargo)) {
					contador = contador +1;
				}	
			}
			if (contador == 0) {
				try {
					empleado.setCargo((String) evt.getOldValue());;
					throw new PropertyException("PropertyException Cargo");
				} catch (PropertyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else if((evt.getPropertyName()).equals("sueldo")) {
			float newValue = (float) evt.getNewValue();
			float oldValue = (float) evt.getOldValue();
			float porcentaje = (float) 100f - (((newValue * 100f)/oldValue));
			System.out.printf("Sueldo anterior: %f%n",evt.getOldValue());
			System.out.printf("Sueldo actual: %f%n",evt.getNewValue());
			System.out.printf("Porcentage: %f%n",porcentaje);
			System.out.printf("REALIZAR CAMBIO EN EMPLEADO: %s%n",empleado.getNombre());
			if(porcentaje > limiteVariacionSueldo) {
				try {
					empleado.setSueldo((float) evt.getOldValue());
					throw new PropertyException("PropertyException porcentaje");
				} catch (PropertyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("ATRIBUTO MODIFICADO");
			}
		}
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public int getLimiteVariacionSueldo() {
		return limiteVariacionSueldo;
	}
	public void setLimiteVariacionSueldo(int limiteVariacionSueldo) {
		if(limiteVariacionSueldo >= 10 && limiteVariacionSueldo <= 50) {
			this.limiteVariacionSueldo = limiteVariacionSueldo;
		}
	}
	public String[] getListaDeCargos() {
		return listaDeCargos;
	}
	public void setListaDeCargos(String[] listaDeCargos) {
		this.listaDeCargos = listaDeCargos;
	}


}

