import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {
	private int id;
	String c = "Cliente";
	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
	private boolean entregue;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getC() {
		return c;
	}
	
	public void setC(String c) {
		this.c = c;
	}
	
	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	
	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	public boolean isEntregue() {
		return entregue;
	}
	
	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}
	
	
}
