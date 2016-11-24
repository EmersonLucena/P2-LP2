package lab03;

import java.util.Scanner;

public class Supermercado {
	Estoque estoque;
	Scanner sc = new Scanner(System.in);
	private final String NL = System.lineSeparator(); 
	
	public Supermercado() {
		estoque = new Estoque();
	}
	
	public void iniciaCadastro() {
		System.out.println(NL + "= = = = Cadastro de Produtos = = = =");
		String opcao = "";
		
		while(!opcao.equals("Nao")) {
			System.out.print("Digite o nome do produto: ");
			String nome = sc.nextLine().trim();
 
			System.out.print("Digite o preço unitário do produto: ");
			double preco = Double.parseDouble(sc.nextLine().trim());
 
			System.out.print("Digite o tipo do produto: ");
			String tipo = sc.nextLine().trim();
 
			System.out.print("Digite a quantidade no estoque: ");
			int quantidade = Integer.parseInt(sc.nextLine().trim());
 
			cadastraProduto(nome, tipo, preco, quantidade);
			System.out.println(quantidade +  " produto(s) \"" + nome + "\" cadastrado(s) com sucesso." + NL);
 
			System.out.print("Deseja cadastrar outro produto? ");
			opcao = sc.nextLine().trim();
		}
	}

	private void cadastraProduto(String nome, String tipo, double preco, int quantidade) {
		Produto novoProduto = new Produto(nome, tipo, preco, quantidade);
		estoque.cadastraProduto(novoProduto);
	}
	
	public void iniciaVenda() {
		System.out.println(NL + "= = = = Venda de Produtos = = = =");
		String opcao;
		
		do {
			System.out.print("Digite o nome do produto: ");
			String nome = sc.nextLine().trim();
			
			Produto produtoParaVenda = estoque.pesquisaProduto(nome);
			if(produtoParaVenda != null) { 
				System.out.println("==> " + nome + " (" + produtoParaVenda.getTipo() + "). R$" + produtoParaVenda.getPreco());
				
				System.out.print("Digite a quantidade a ser vendida: ");				
				int quantidade = Integer.parseInt(sc.nextLine().trim());
				
				int quantidadeDisponivel = produtoParaVenda.getQuantidade();
				if(quantidade <= quantidadeDisponivel) {
					estoque.vendeProduto(produtoParaVenda, quantidade);
					System.out.printf("==> Total arrecadado: R$ %.2f%s", quantidade * produtoParaVenda.getPreco(), NL); 
					
				} else {
					System.out.println("Não é possível vender pois não há " + nome + " suficiente."); 
					System.out.println("Há apenas " + quantidadeDisponivel + " produto(s) "+ nome + " no estoque"); 
				}
			} else System.out.println("==> " + nome + " nao cadastrado no sistema.");
			
			System.out.print("Deseja vender outro produto? ");
			opcao = sc.nextLine().trim();
		} while(!opcao.equals("Nao"));
	}

	public void imprimeBalanco() {
		System.out.println(NL + "= = = = Impressao de Balanco = = = =");
		System.out.println("Produtos cadastrados:");
		
		String[] balanco = estoque.listaBalanco();
		for(int i = 0; i < balanco.length; i++) {
			System.out.printf("\t%d) %s\n", i+1, balanco[i]);
		}
		
		System.out.printf("%sTotal arrecadado em vendas: R$ %.2f%s", NL, estoque.getTotalArrecadado(), NL);
		System.out.printf("Total que pode ser arrecadado: R$ %.2f%s", estoque.getTotalDisponivel(), NL);
	}
}
