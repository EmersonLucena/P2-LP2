package lab03;
 
public class Produto {
	private String nome;
	private String tipo;
	private double preco;
	private int quantidade;
 
	public Produto(String nome, String tipo, double preco, int quantidade) {
		this.nome = nome;
		this.tipo = tipo;
		this.preco = preco;
		this.quantidade = quantidade;
	}
 
	public String getNome() {
		return nome;
	}
 
	public String getTipo() {
		return tipo;
	}
 
	public double getPreco() {
		return preco;
	}
 
	public void setPreco(double preco) {
		this.preco = preco;
	}
 
	public int getQuantidade() {
		return quantidade;
	}
 
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	@Override
	public String toString() {
		return String.format("%s (%s). R$%.2f Restante: %d", nome, tipo, preco, quantidade);
	}
}
