
public class LlenarProductos {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos();
		
		baseDatos.insertarProducto("Duruss Cobalt", 1, 10, 3, 220);
		baseDatos.insertarProducto("Varlion Avant Carbon", 2, 5, 2, 176);
		baseDatos.insertarProducto("Star Vie Pyramid R50", 3, 20, 5, 193);
		baseDatos.insertarProducto("Dunlop Titan", 4, 8, 3, 85);
		baseDatos.insertarProducto("Vision King", 5, 7, 1, 159);
		baseDatos.insertarProducto("Slazenger Reflex Pro", 6, 5, 2, 80);
		
		baseDatos.cerrarDB();
	}

}
