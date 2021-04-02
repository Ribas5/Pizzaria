import java.util.ArrayList;
import java.util.List;

public abstract class Entregador extends Funcionario {
	private ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();

	public ArrayList<Pedido> getListaPedidos() {
		return listaPedidos;
	}
	
	public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	public void setListaPedidos(Pedido p) {
		this.listaPedidos.add(p);
	}
	
	public void entregarPedido(ArrayList<Pedido> listPe) {
		for(int i= 0; i< listPe.size(); i++) {
			boolean pizzasPronta = true;
			
			for(int j = 0; j< listPe.get(i).getListaPizza().size();j++) {
				if(!listPe.get(i).getListaPizza().get(j).isPreparada()) {
					pizzasPronta = false;
				}
			}
			listPe.get(i).setEntregue(pizzasPronta);
			
		}
	}
}
