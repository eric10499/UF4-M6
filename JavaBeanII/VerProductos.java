import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class VerProductos {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos();
		ODB odb = baseDatos.getOdb();
		Objects<Producto> productos = odb.getObjects(Producto.class);
		Objects<Pedido> pedidos = odb.getObjects(Pedido.class);
		
		System.out.println("------------------");
		System.out.println("MOSTRAR PRODUCTOS");
		System.out.println("------------------");
		for(Producto producto : productos) {
			System.out.println(producto.getIdproducto() + " - " + producto.getDescripcion() + " - " + producto.getStockactual() + " - " + producto.getStockminimo() + " - " + producto.getPvp());
		}
		System.out.println("------------------");
		System.out.println("");
		System.out.println("------------------");
		System.out.println("MOSTRAR PEDIDOS");
		System.out.println("------------------");
		for(Pedido pedido : pedidos) {
			System.out.println(pedido.getNumeroPedido() + " - " + pedido.getProducto() + " - " + pedido.getFecha() + " - " + pedido.getCantidad());
		}
		System.out.println("------------------");

		baseDatos.cerrarDB();
	}

}
