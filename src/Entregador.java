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
	
	public void entregarPedido(ArrayList<Pedido> listPe) {
		for(int i= 0; i< listPe.size(); i++) {
			listPe.get(i).setEntregue(true);
		}
	}
}
