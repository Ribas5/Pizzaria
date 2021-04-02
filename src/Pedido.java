import java.util.ArrayList;
import java.util.List;

public abstract class Pedido {
	private static int incrementaId = 0;
	private int id;
	private ArrayList<Pizza> listaPizza;
	Cliente c;
	private boolean entregue;
	
	public Pedido(Cliente c) {
		incrementaId ++;
		id = incrementaId;
		this.listaPizza = new ArrayList<Pizza>();
		this.c = c;
	}
	
	public abstract double getValor();
	
	public int getId() {
		return id;
	}
	
	
	public ArrayList<Pizza> getListaPizza() {
		return listaPizza;
	}
	
	public void setListaPizza(ArrayList<Pizza> listaPizza) {
		this.listaPizza = listaPizza;
	}
	
	public boolean isEntregue() {
		return entregue;
	}
	
	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}


	public Cliente getC() {
		return c;
	}


	public void setC(Cliente c) {
		this.c = c;
	}
	
	
}
