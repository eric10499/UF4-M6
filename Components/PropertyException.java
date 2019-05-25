public class PropertyException extends Exception {
	private String mensaje;
	public PropertyException() {}

	public PropertyException(String mensaje) {
		this.mensaje = mensaje;
	}
}
