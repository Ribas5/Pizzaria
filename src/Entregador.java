import java.util.ArrayList;
import java.util.List;

public abstract class Entregador extends Funcionario {
	private List listaPedidos = new ArrayList<>();

	public List getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
}
