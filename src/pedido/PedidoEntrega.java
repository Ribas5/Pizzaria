package pedido;
import cliente.Cliente;

public class PedidoEntrega extends Pedido {
	private String endereco;
	private double taxaEntrega;
	
	public PedidoEntrega(Cliente c) {
		super(c);
		this.taxaEntrega = 5;
		this.endereco = c.getEndereco();
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getTaxaEntrega() {
		return taxaEntrega;
	}
	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}
	
	@Override
	public double getValor() {
		double valor = 0;
		for (int i=0 ; i < this.getListaPizza().size();i++) {
			valor += this.getListaPizza().get(i).getValor();
		}
		return valor + taxaEntrega;
	}
	

}
