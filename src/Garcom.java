import java.util.ArrayList;

public class Garcom extends Entregador {
	
	public Pedido anotarPedido (Cliente c) {
		Pedido p = new PedidoLocal(c); // como diferenciar cada pedido se todos se chamam P?
		return p; /// ele precisa retornar um pedido?
	}
	public Pedido anotarPedidoEntrega (Cliente c, String endereco) {
		Pedido p= new PedidoEntrega(c, endereco);
		return p;
	}
	
	public void mandarCozinhar() {
		
	}
	
	public void entregarPedido(ArrayList<Pedido> pe) {
	}

}
