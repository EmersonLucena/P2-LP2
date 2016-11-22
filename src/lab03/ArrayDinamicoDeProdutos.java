package lab03;
 
public class ArrayDinamicoDeProdutos {
	private int quantidadeDeProdutos;
	private Produto[] produtos;
 
	public ArrayDinamicoDeProdutos() {
		produtos = new Produto[5];
		quantidadeDeProdutos = 0;
	}
 
	public void adicionaProduto(Produto novoProduto) {
		if(quantidadeDeProdutos == produtos.length) {
			Produto[] novoArray = new Produto[produtos.length * 2];
			copiaProdutosParaNovoArray(novoArray);
			produtos = novoArray;
		}
 
		produtos[quantidadeDeProdutos++] = novoProduto;
	}
  
	private void copiaProdutosParaNovoArray(Produto[] novoArray) {
		for(int i = 0; i < produtos.length; i++)
			novoArray[i] = produtos[i];
	}
	
	public Produto pesquisaProduto(String nome) {
		for(int i = 0; i < quantidadeDeProdutos; i++)
			if(produtos[i].getNome().equals(nome))
				return produtos[i];
		return null;
	}

	public Produto getProduto(int indice) {
		return produtos[indice];
	}
	
	public void setProduto(int indice, Produto produto) {
		produtos[indice] = produto;
	}
}