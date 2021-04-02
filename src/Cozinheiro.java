import java.util.ArrayList;

public class Cozinheiro extends Funcionario {

	public Pedido fazerPedido(Pedido p) {
		ArrayList<Pizza> listPizza = p.getListaPizza();
		for(int i = 0; i < listPizza.size();i++) {
			if(!listPizza.get(i).isPreparada()) {
				listPizza.get(i).setPreparada(true);
			}
		}
		p.setListaPizza(listPizza);
		return p;
	}

}
