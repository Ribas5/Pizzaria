package main;
import pedido.*;
import funcionario.*;
import cliente.Cliente;

import java.util.ArrayList;
import java.util.Scanner;


public class Pizzaria {
	private static Garcom g = new Garcom("Roberto", 1250.0, 25, "9865-7542");
	private static Motoboy m = new Motoboy("Marcos", 1250.0, 27, "9685-7452", "12345678901");
	private static Cozinheiro coz = new Cozinheiro("Cláudia", 1625.00, 30, "8866-9658");
	
	public static void sysPizzaria(Scanner s) {
		int op = 0;
		while (op != 9) {
			switch (op) {
			case 0:
				System.out.println("\n--- Menu principal ---");
				System.out.println("1 - Fazer pedido");
				System.out.println("2 - Detalhes de um pedido");
				System.out.println("3 - Mandar para a cozinha");
				System.out.println("4 - Mandar para o motoboy");
				System.out.println("5 - Realizar uma entrega");
				System.out.println("9 - Sair do sistema");
				op = s.nextInt();
				break;
			case 1:
				fazerPedido(s);
				op = 0;	break;
			case 2:
				detalhesPedido(s);
				op = 0;	break;
			case 3:
				mandarCozinha();
				op = 0;	break;
			case 4:
				mandarMotoboy();
				op = 0;	break;
			case 5:
				entregarPedido(s);
				op = 0;	break;
			default:
				op = 0;
				break;
			}
		}
	}
	
	private static void fazerPedido(Scanner s) {
		System.out.println("\n--- Anotar pedido ---");
		
		System.out.println("Digite o nome do cliente:");
		String nome = s.next() + s.nextLine();
		System.out.println("Digite o endereco do cliente:");
		String endereco = s.next() + s.nextLine();
		Cliente c = new Cliente(nome, endereco);
		
		System.out.println("Pedido para entrega? (S/n)");
		char opt = s.next().charAt(0);
		
		if (opt == 'S' || opt == 's') {
			int id = g.anotarPedidoEntrega(c, anotarPizza(s));
			System.out.println("O pedido de numero " + id + " foi anotado com sucesso");
		} else if (opt == 'N' || opt == 'n') {
			System.out.println("Digite o número da mesa:");
			int numMesa = s.nextInt();
			int id = g.anotarPedido(c, numMesa, anotarPizza(s));
			System.out.println("O pedido de numero " + id + " foi anotado com sucesso");
		} else {
			System.out.println("Comando inválido!");
		}
	}
	
	private static ArrayList<Pizza> anotarPizza(Scanner s) {
		char op = 's';
		int n = 0;
		ArrayList<Pizza> listaPizza = new ArrayList<Pizza>();
		while (true) {
			if (op == 'n' || op == 'N') {
				break;
			}
			switch (op) {
			case 'S':
			case 's':
				System.out.println("Indique o sabor da pizza: ");
				String sabor = s.next() + s.nextLine();
				System.out.println("Indique o tamanho da pizza: ");
				char tamanho = s.next().charAt(0);
				System.out.println("Indique o valor da pizza: ");
				double valor = s.nextDouble();
				System.out.println("Pizza");
				listaPizza.add(new Pizza(sabor, tamanho, valor));
				System.out.println("Pizza "+ ++n +" anotada com sucesso!");
				op = 'a';
				break;
			case 'N':
			case 'n':
				break;
			default:
				System.out.println("Deseja adicionar uma nova pizza? (S/n)");
				op = s.next().charAt(0);
				break;
			}
		}
		return listaPizza;
	}
	
	private static void mandarCozinha() {
		System.out.println("\nTodos os pedidos foram encaminhados para o cozinheiro!");
		g.mandarCozinhar(coz);
	}
	
	private static void mandarMotoboy() {
		g.mandarMotoboy(m);
		System.out.println("\nTodos os pedidos para entrega foram encaminhados para o motoboy!");
	}
	
	private static void entregarPedido(Scanner s) {
		System.out.println("\n--- Entregar Pedido ---");
		System.out.println("Digite o ID do pedido: ");
		int idPedido = s.nextInt();
		if (idPedido > 0) {
			if (g.entregarPedido(idPedido)) {
				System.out.println("O pedido foi entregue na mesa correta");
				return;
			} else if (m.entregarPedido(idPedido)) {
				System.out.println("O pedido foi entregue na residencia correta");
				return;
			}
		}
		System.out.println("Esse pedido já foi entregue ou não existe");
	}
	
	private static void detalhesPedido(Scanner s) {
		System.out.println("\n--- Detalhes de pedido ---");
		System.out.println("Digite um ID de pedido para buscar:");
		int idPedido = s.nextInt();
		if (idPedido > 0) {
			Pedido p = g.getPedido(idPedido);
			if (p != null) {
				System.out.println("--- Detalhes do pedido ---");
				System.out.println("Cliente: " + p.getC().getNome() + " - " + p.getC().getEndereco());
				System.out.println("Número de pizzas: " + p.getListaPizza().size());
				System.out.println("Valor do pedido: R$ " + p.getValor());
				System.out.println("Pizzas:");
				ArrayList<Pizza> listaPizzas = p.getListaPizza();
				for (int i = 0; i < listaPizzas.size(); i++) {
					System.out.println(listaPizzas.get(i).getSabor() + "\t" +
										listaPizzas.get(i).getTamanho() + "\t" +
										listaPizzas.get(i).getValor());
				}
				return;
			}
		}
		System.out.println("Esse pedido não existe!");
	}
}
