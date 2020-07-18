package modelo.Ventas;

/**
 * @author Asullom
 * @version 1.0
 * @created 26-Jun-2020 12:25:14 p.m.
 */
public class VentaDet {

	private double cantidad;
	private double precio;
	private double subtotal;
	private double igv;
	private double descto;
	private int prod_id;
	private int venta_id;
	public Venta m_Venta;
	public Item m_Item;

	public VentaDet(){

	}

	public void finalize() throws Throwable {

	}

}