package cliente;

public class Cliente {
	private static int incrementaId = 1;
	private int id;
	private String endereco;
	private String nome;
	
	public Cliente(String nome, String endereco) {
		this.id = incrementaId++;
		this.endereco = endereco;
		this.nome = nome;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
