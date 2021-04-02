
public class PedidoLocal extends Pedido {
	public PedidoLocal(Cliente c) {
		super(c);
	}

	private int numMesa;

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
