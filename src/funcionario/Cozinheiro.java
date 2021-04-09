package funcionario;
import java.util.ArrayList;
import pedido.*;

public class Cozinheiro extends Funcionario {

	public Cozinheiro(String nome, double salario, int idade, String telefone) {
		super(nome, salario, idade, telefone);
	}

	public Pedido fazerPedido(Pedido p) { 
		ArrayList<Pizza> listPizza = p.getListaPizza();
		for(int i = 0; i < listPizza.size();i++) {
			if(!listPizza.get(i).isPreparada()) {
				listPizza.get(i).setPreparada(true);
			}
		}
		p.setListaPizza(listPizza);
		System.out.println("Todas as pizzas do pedido "+p.getId()+" foram preparadas");
		return p;
		
	}

}
