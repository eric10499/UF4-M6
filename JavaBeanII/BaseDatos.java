import java.math.BigDecimal;
import java.util.Calendar;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;


public class BaseDatos {
	
	private ODB odb;

	public BaseDatos() {
		this.odb = ODBFactory.open("Producto_Ped.BD");
	}
	
	public ODB getOdb() {
		return odb;
	}

	public void setOdb(ODB odb) {
		this.odb = odb;
	}

	public void cerrarDB(){
		odb.close();
	}
	
	public void insertarProducto(String descripcion, int idproducto, int stockactual, int stockminimo, float pvp) {
		Producto producto = new Producto(idproducto, descripcion, stockactual, stockminimo, pvp);
		odb.store(producto);
		odb.commit();
	}
	
	public void insertarPedido(int numeroPedido, Producto producto, int cantitad) {
		java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Pedido pedido = new Pedido(numeroPedido, producto, fecha, cantitad);
		odb.store(pedido);
		odb.commit();
	}
	
	public void insertarVenta(int idProducto, int cantidad, String observaciones) {
		java.sql.Date fecha = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Venta venta = new Venta(consultarMaxVenta() +1, idProducto, fecha, cantidad, observaciones);
		odb.store(venta);
		odb.commit();
	}
	
	public int consultarMaxPedido() {
		Values valores = odb.getValues(new ValuesCriteriaQuery(Pedido.class).max("numeroPedido"));
		BigDecimal pedidoMax = (BigDecimal) valores.getFirst().getByAlias("numeroPedido");
		return pedidoMax.intValue();

	}
	
	public int consultarMaxVenta() {
		Values valores = odb.getValues(new ValuesCriteriaQuery(Venta.class).max("numeroVenta"));
		BigDecimal ventaMax = (BigDecimal) valores.getFirst().getByAlias("numeroVenta");
		return ventaMax.intValue();
	}
}
