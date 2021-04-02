import java.util.ArrayList;
import java.util.Scanner;

public class Garcom extends Entregador {

	public void anotarPedido(Cliente c, int numPizza) {
		Scanner s = new Scanner(System.in);
		Pedido p = new PedidoLocal(c);
		ArrayList<Pizza> listaPizza = new ArrayList<Pizza>();
		for (int i = 0; i < numPizza; i++) {
			System.out.println("Indique o sabor da pizza: ");
			String sabor = s.next();
			System.out.println("Indique o tamanho da pizza: ");
			char tamanho = s.next().charAt(0);
			System.out.println("Indique o valor da pizza: ");
			double valor = s.nextDouble();
			Pizza p1 = new Pizza(sabor, tamanho, valor);
			listaPizza.add(p1);
		}
		p.setListaPizza(listaPizza);
		this.setListaPedidos(p);
		s.close();
	}

	public void anotarPedidoEntrega(Cliente c, int numPizza, String endereco) {
		Scanner s = new Scanner(System.in);
		Pedido p = new PedidoEntrega(c, endereco);
		ArrayList<Pizza> listaPizza = new ArrayList<Pizza>();
		for (int i = 0; i < numPizza; i++) {
			System.out.println("Indique o sabor da pizza: ");
			String sabor = s.next();
			System.out.println("Indique o tamanho da pizza: ");
			char tamanho = s.next().charAt(0);
			System.out.println("Indique o valor da pizza: ");
			double valor = s.nextDouble();
			Pizza p1 = new Pizza(sabor, tamanho, valor);
			listaPizza.add(p1);
		}
		p.setListaPizza(listaPizza);
		this.setListaPedidos(p);
		s.close();
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


		
		

}

