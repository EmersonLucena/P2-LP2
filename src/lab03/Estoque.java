package lab03;

public class Estoque {
	ArrayDinamicoDeProdutos arrayDinamico;
	
	public Estoque() {
		arrayDinamico = new ArrayDinamicoDeProdutos();
	}
	
	public void cadastraProduto(Produto novoProduto) {
		Produto antigoProduto = arrayDinamico.pesquisaProduto(novoProduto.getNome());
		
		if(antigoProduto == null) {
			arrayDinamico.adicionaProduto(novoProduto);
		}else {
			antigoProduto = novoProduto;
		}
	}
	
	public Produto pesquisaProduto(String nome) {
		return arrayDinamico.pesquisaProduto(nome);
	}
	
	//TODO na venda, caso quantidade = 0 retirar produto do array
}
