import java.util.ArrayList;

public abstract class Entregador extends Funcionario {
	public Entregador(String nome, double salario, int idade, String telefone) {
		super(nome, salario, idade, telefone);
	}

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
	
	public void entregarPedido(int idPedido) {
		for(int i= 0; i< this.listaPedidos.size(); i++) {
			if (this.listaPedidos.get(i).getId() == idPedido && this.listaPedidos.get(i).isPreparada()) {
				this.listaPedidos.get(i).setEntregue(true);
			}
		}
	}
}
