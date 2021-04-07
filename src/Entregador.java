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
		boolean entregue = false;
		for(int i= 0; i< this.listaPedidos.size(); i++) {
			if (this.listaPedidos.get(i).getId() == idPedido && this.listaPedidos.get(i).isPreparada()) {
				this.listaPedidos.get(i).setEntregue(true);
				System.out.println("O pedido foi entregue na residencia correta");
				entregue = true;
			}
		}
		if(!entregue) {
			System.out.println("Esse pedido já foi entregue ou não existe para esse entregador.");
		}
		
	}
}
