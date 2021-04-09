package funcionario;
public class Motoboy extends Entregador {
	private String cnh;
	
	public Motoboy(String nome, double salario, int idade, String telefone, String cnh) {
		super(nome, salario, idade, telefone);
		this.cnh = cnh;
	}

	public String getCNH() {
		return this.cnh;
	}

	public void setCNH(String cNH) {
		this.cnh = cNH;
	}
}
