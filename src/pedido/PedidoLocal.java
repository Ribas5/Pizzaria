package pedido;
import cliente.Cliente;

public class PedidoLocal extends Pedido {
	private int numMesa;
	
	public PedidoLocal(Cliente c, int numMesa) {
		super(c);
		this.numMesa = numMesa;
	}

	public int getNumMesa() {
		return numMesa;
	}

	public void setNumMesa(int numMesa) {
		this.numMesa = numMesa;
	}

	@Override
	public double getValor() {
		double valor = 0;
		for (int i=0 ; i < this.getListaPizza().size();i++) {
			valor += this.getListaPizza().get(i).getValor();
		}
		return valor;
	}
}
