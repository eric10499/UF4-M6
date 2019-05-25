
public class Prueba {
	public static void main(String[] args) {
		Empleado empleado = new Empleado("123456789E", "Eric");
		PanelEmpleado panelEmpleado =new PanelEmpleado();
		panelEmpleado.setEmpleado(empleado);

		empleado.addPropertyChangeListener (panelEmpleado);

		//CASOS para comprobar que se lanzan las execepciones
		//empleado.setCargo("Policia");
		empleado.setSueldo(300);
	}
}
