import java.util.ArrayList;

public abstract class Pedido {
	private static int incrementaId = 1;
	private int id;
	private ArrayList<Pizza> listaPizza;
	Cliente c;
	private boolean entregue;
	
	public Pedido(Cliente c) {
		id = incrementaId++;
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
	
	public boolean isPreparada() {
		if(!this.listaPizza.isEmpty()) {
			boolean preparado = true;
			for (int i = 0; i < this.listaPizza.size(); i++) {
				if (!this.listaPizza.get(i).isPreparada()) {
					preparado = false;
				}
			}
			return preparado;
		}
		return false;
	}

	public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		this.c = c;
	}
}
