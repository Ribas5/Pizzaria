import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {
	private int id;
	String c = "Cliente";
	private List listaPedidos = new ArrayList<Pizza>();
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
	public List getListaPedidos() {
		return listaPedidos;
	}
	public void setListaPedidos(List listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	public boolean isEntregue() {
		return entregue;
	}
	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}
	
	
}
