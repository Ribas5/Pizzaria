package funcionario;
import java.util.ArrayList;
import pedido.*;
import cliente.Cliente;

public class Garcom extends Entregador {

	public Garcom(String nome, double salario, int idade, String telefone) {
		super(nome, salario, idade, telefone);
	}

	public int anotarPedido(Cliente c, int numMesa, ArrayList<Pizza> listaPizza) {
		Pedido p = new PedidoLocal(c, numMesa);
		p.setListaPizza(listaPizza);
		this.setListaPedidos(p);
		return p.getId();
	}

	public int anotarPedidoEntrega(Cliente c, ArrayList<Pizza> listaPizza) {
		Pedido p = new PedidoEntrega(c);
		p.setListaPizza(listaPizza);
		this.setListaPedidos(p);
		return p.getId();
	}
	

	public void mandarCozinhar(Cozinheiro coz) {
		ArrayList<Pedido> pedido = this.getListaPedidos();
		for (int i = 0; i<pedido.size();i++) {
			if (pedido.get(i).isEntregue()) {
				continue;
			}
			Pedido p = coz.fazerPedido(pedido.get(i));
			pedido.set(i, p);
		}
		this.setListaPedidos(pedido);
	}

	public void mandarMotoboy(Motoboy mb) {
		for (int i = 0; i < this.getListaPedidos().size(); i++) {
			Pedido p = this.getListaPedidos().get(i);
			if (!p.isEntregue() && p.isPreparada() && p instanceof PedidoEntrega) {
				mb.setListaPedidos(p);
			}
		}
	}
	
	@Override
	public boolean entregarPedido(int idPedido) {
		for(int i= 0; i< this.getListaPedidos().size(); i++) {
			if (this.getListaPedidos().get(i).getId() == idPedido
					&& this.getListaPedidos().get(i).isPreparada()
					&& this.getListaPedidos().get(i) instanceof PedidoLocal) {
				this.getListaPedidos().get(i).setEntregue(true);
				return true;
			}
		}
		return false;
	}
		
}

