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
			Pizza p1 = this.anotarPizza();
			listaPizza.add(p1);
		}
		p.setListaPizza(listaPizza);
		this.setListaPedidos(p);
	}

	public void anotarPedidoEntrega(Cliente c, int numPizza, String endereco) {
		Pedido p = new PedidoEntrega(c, endereco);
		ArrayList<Pizza> listaPizza = new ArrayList<Pizza>();
		for (int i = 0; i < numPizza; i++) {
			Pizza p1 = this.anotarPizza();
			listaPizza.add(p1);
		}
		p.setListaPizza(listaPizza);
		this.setListaPedidos(p);
	}
	
	private Pizza anotarPizza() {
		Scanner s = new Scanner(System.in);
		System.out.println("Indique o sabor da pizza: ");
		String sabor = s.next();
		System.out.println("Indique o tamanho da pizza: ");
		char tamanho = s.next().charAt(0);
		System.out.println("Indique o valor da pizza: ");
		double valor = s.nextDouble();
		s.close();
		return new Pizza(sabor, tamanho, valor);
	}

	public void mandarCozinhar(Cozinheiro coz) {
		for (int i = 0; i<getListaPedidos().size();i++) {
			if (getListaPedidos().get(i).isEntregue()) {
				continue;
			}
			Pedido p = coz.fazerPedido(getListaPedidos().get(i));
			setListaPedidos(getListaPedidos().set(i, p));
		}
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
		for(int i= 0; i< this.getListaPedidos().size(); i++) {
			if (this.getListaPedidos().get(i).getId() == idPedido
					&& this.getListaPedidos().get(i).isPreparada()
					&& this.getListaPedidos().get(i) instanceof PedidoLocal) {
				this.getListaPedidos().get(i).setEntregue(true);
			}
		}
	}
}

