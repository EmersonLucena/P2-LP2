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
}
