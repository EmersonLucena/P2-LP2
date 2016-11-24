package lab03;

public class Estoque {
	ArrayDinamicoDeProdutos arrayDinamico;
	private Double totalArrecadado;
	
	public Estoque() {
		arrayDinamico = new ArrayDinamicoDeProdutos();
		totalArrecadado = 0.0;
	}
	
	public void cadastraProduto(Produto novoProduto) {
		Produto antigoProduto = arrayDinamico.pesquisaProduto(novoProduto.getNome());
		
		if(antigoProduto == null) {
			arrayDinamico.adicionaProduto(novoProduto);
		}else {
			antigoProduto.setQuantidade(antigoProduto.getQuantidade() + novoProduto.getQuantidade());
			antigoProduto.setPreco(novoProduto.getPreco());
		}
	}
	
	public Produto pesquisaProduto(String nome) {
		return arrayDinamico.pesquisaProduto(nome);
	}

	public void vendeProduto(Produto produtoParaVenda, int quantidade) {	
		totalArrecadado += (produtoParaVenda.getPreco() * quantidade);
		produtoParaVenda.setQuantidade(produtoParaVenda.getQuantidade() - quantidade);
		
		if(produtoParaVenda.getQuantidade() == 0) {
			arrayDinamico.removeProduto(produtoParaVenda);
		}
	}
	
	public String[] listaBalanco() {
		//TODO retornar uma só string
		String[] balanco = new String[arrayDinamico.size()];
		for(int i = 0; i < balanco.length; i++) {
			balanco[i] = arrayDinamico.getProduto(i).toString();
		}
		return balanco;
	}
	
	public double getTotalArrecadado() {
		return totalArrecadado;
	}

	public double getTotalDisponivel() {
		double total = 0;
		for(int i = 0; i < arrayDinamico.size(); i++) {
			Produto produto = arrayDinamico.getProduto(i);
			total += produto.getPreco() * produto.getQuantidade();
		}
		return total;
	}
}
