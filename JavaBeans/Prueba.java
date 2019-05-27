import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class Prueba {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos();
		ODB odb = baseDatos.getOdb();
		Objects<Producto> productos = odb.getObjects(Producto.class);
		Objects<Pedido> pedidos = odb.getObjects(Pedido.class);
		
		Producto productoNum2 = new Producto();
		Producto productoNum5 = new Producto();

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
			Producto productoVenta = pedido.getProducto();
			System.out.println(pedido.getNumeroPedido() + " - " + productoVenta.getDescripcion() + " - " + pedido.getFecha() + " - " + pedido.getCantidad());
		}
		System.out.println("------------------");
		
		baseDatos.cerrarDB();

		for(Producto producto : productos) {
			if(producto.getIdproducto() == 2) {
				productoNum2 = producto;
			} else if(producto.getIdproducto() == 5) {
				productoNum5 = producto;
			}
		}
		
		Pedido pedido =new Pedido();
        pedido.setProducto(productoNum2);
        
        productoNum2.addPropertyChangeListener (pedido);
        
        productoNum2.setStockactual(1);
        
        Pedido pedidoNum2 = new Pedido();
        pedidoNum2.setProducto(productoNum5);
        
        productoNum5.addPropertyChangeListener (pedidoNum2);
        
        productoNum5.setStockactual(4);
        
		
		
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
		for(Pedido pedido2 : pedidos) {
			Producto productoVenta2 = pedido2.getProducto();
			System.out.println(pedido2.getNumeroPedido() + " - " + productoVenta2.getDescripcion() + " - " + pedido2.getFecha() + " - " + pedido2.getCantidad());
		}
		System.out.println("------------------");

	}
	
	

}
