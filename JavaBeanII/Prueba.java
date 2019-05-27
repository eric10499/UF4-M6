import java.util.Scanner;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;

public class Prueba {

	public static void main(String[] args) {
		BaseDatos baseDatos = new BaseDatos();
		ODB odb = baseDatos.getOdb();
		Objects<Producto> productos = odb.getObjects(Producto.class);
		Objects<Pedido> pedidos = odb.getObjects(Pedido.class);
		Objects<Venta> ventas = odb.getObjects(Venta.class);
		Scanner sc = new Scanner(System.in);
		
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

		System.out.println("------------------");
		System.out.println("");
		System.out.println("------------------");
		System.out.println("MOSTRAR VENTAS");
		System.out.println("------------------");
		for(Venta venta : ventas) {
			System.out.println(venta.getNumeroVenta() + " - " + venta.getIdProducto() + " - " + venta.getCantidad() + " - " + venta.getObservaciones());
		}
		System.out.println("------------------");
		
		baseDatos.cerrarDB();

		int idProducto = sc.nextInt();

		int cantidad = sc.nextInt();

		Producto productoSolicitado = null;

		
		BaseDatos baseDatos2 = new BaseDatos();
		Pedido pedido =new Pedido();
		Venta venta = new Venta();
		


		for(Producto producto : productos) {
			if(producto.getIdproducto() == idProducto) {
				productoSolicitado = producto;
				baseDatos2.insertarVenta(idProducto, cantidad, "");
				pedido.setProducto(productoSolicitado);
				productoSolicitado.addPropertyChangeListener (pedido);
				productoSolicitado.addPropertyChangeListener(venta);
				productoSolicitado.setStockactual(1);
				
			}
		}

		if(productoSolicitado == null) {
			System.out.println("Este producto no se encuentra en nuestra tienda");
		}



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
			Producto productoVenta = pedido2.getProducto();
			System.out.println(pedido2.getNumeroPedido() + " - " + productoVenta.getDescripcion() + " - " + pedido2.getFecha() + " - " + pedido2.getCantidad());
		}
		System.out.println("------------------");

		System.out.println("------------------");
		System.out.println("");
		System.out.println("------------------");
		System.out.println("MOSTRAR VENTAS");
		System.out.println("------------------");
		for(Venta venta2 : ventas) {
			System.out.println(venta2.getNumeroVenta() + " - " + venta2.getIdProducto() + " - " + venta2.getCantidad() + " - " + venta2.getObservaciones());
		}
		System.out.println("------------------");
		
		baseDatos2.cerrarDB();

	}



}
