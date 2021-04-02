
public class Pizza {
	private String sabor;
	private char tamanho;
	private double valor;
	private boolean preparada = false;
	
	public Pizza(String sabor, char tamanho, double valor ) {
		this.sabor = sabor;
		this.tamanho = tamanho;
		this.valor = valor;
	}
	
	public String getSabor() {
		return sabor;
	}
	
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	public char getTamanho() {
		return tamanho;
	}
	
	public void setTamanho(char tamanho) {
		this.tamanho = tamanho;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public boolean isPreparada() {
		return preparada;
	}
	
	public void setPreparada(boolean preparada) {
		this.preparada = preparada;
	}
}
