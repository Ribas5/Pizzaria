package funcionario;

public abstract class Funcionario {
	private static int incrementaId = 1;
	protected int id = 0;
	protected String nome;
	protected double salario;
	protected int idade;
	protected String telefone;
	
	public Funcionario(String nome, double salario, int idade, String telefone) {
		this.id = incrementaId++;
		this.nome = nome;
		this.salario = salario;
		this.idade = idade;
		this.telefone = telefone;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
