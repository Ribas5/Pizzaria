import java.util.ArrayList;
import java.util.Scanner;

public class Garcom extends Entregador {

	public Garcom(String nome, double salario, int idade, String telefone) {
		super(nome, salario, idade, telefone);
	}

	public void anotarPedido(Cliente c, int numPizza, int numMesa) {
		Pedido p = new PedidoLocal(c, numMesa);
		ArrayList<Pizza> listaPizza = new ArrayList<Pizza>();
		for (int i = 0; i < numPizza; i++) {
			Pizza p1 = anotarPizza();
			listaPizza.add(p1);
			System.out.println("A pizza "+ (i+1)+" foi anotada com sucesso");
		}
		p.setListaPizza(listaPizza);
		this.setListaPedidos(p);
		System.out.println("O pedido de numero "+ (p.getId())+" foi anotado com sucesso");
	}

	public void anotarPedidoEntrega(Cliente c, int numPizza, String endereco) {
		Pedido p = new PedidoEntrega(c, endereco);
		ArrayList<Pizza> listaPizza = new ArrayList<Pizza>();
		for (int i = 0; i < numPizza; i++) {
			Pizza p1 = anotarPizza();
			listaPizza.add(p1);
		}
		p.setListaPizza(listaPizza);
		this.setListaPedidos(p);
		System.out.println("O pedido de numero "+ (p.getId())+" foi anotado com sucesso");
	}
	
	private static Pizza anotarPizza() {
		Scanner s = new Scanner(System.in);
		System.out.println("Indique o sabor da pizza: ");
		String sabor = s.next();
		System.out.println("Indique o tamanho da pizza: ");
		char tamanho = s.next().charAt(0);
		System.out.println("Indique o valor da pizza: ");
		double valor = s.nextDouble();
		return new Pizza(sabor, tamanho, valor);
	}

	public void mandarCozinhar(Cozinheiro coz) {
		System.out.println("Todos os pedidos foram encaminhados para o cozinheiro!");
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
	public void entregarPedido(int idPedido) {
		boolean entregue = false;
		for(int i= 0; i< this.getListaPedidos().size(); i++) {
			if (this.getListaPedidos().get(i).getId() == idPedido
					&& this.getListaPedidos().get(i).isPreparada()
					&& this.getListaPedidos().get(i) instanceof PedidoLocal) {
				this.getListaPedidos().get(i).setEntregue(true);
				entregue = true;
				System.out.println("O pedido foi entregue na mesa correta");
			}
		}
		if(!entregue) {
			System.out.println("Esse pedido já foi entregue ou não existe para esse entregador.");
		}
	}
		
}

