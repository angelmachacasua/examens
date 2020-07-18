package modelo.Ventas;

/**
 * @author Asullom
 * @version 1.0
 * @created 26-Jun-2020 12:25:10 p.m.
 */
public class Venta {

	private Date fecha;
	private double total_base;
	private int clie_id;
	private double total_igv;
	private double total_descto;
	private double total_final;
	public User user_id;
	public Cliente m_Cliente;

	public Venta(){

	}

	public void finalize() throws Throwable {

	}

}