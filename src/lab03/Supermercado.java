package lab03;

import java.util.Scanner;

public class Supermercado {
	Estoque estoque;
	Scanner sc = new Scanner(System.in);
	
	public Supermercado() {
		estoque = new Estoque();
	}
	
	public void iniciaCadastro() {
		System.out.println("\n= = = = Cadastro de Produtos = = = =");
		String opcao = "";
		
		while(!opcao.equals("Nao")) {
			System.out.print("Digite o nome do produto: ");
			String nome = sc.nextLine().trim();
 
			System.out.print("Digite o preÃ§o unitÃ¡rio do produto: ");
			double preco = Double.parseDouble(sc.nextLine().trim());
 
			System.out.print("Digite o tipo do produto: ");
			String tipo = sc.nextLine().trim();
 
			System.out.print("Digite a quantidade no estoque: ");
			int quantidade = Integer.parseInt(sc.nextLine().trim());
 
			cadastraProduto(nome, tipo, preco, quantidade);
			System.out.println(quantidade +  " produto(s) \"" + nome + "\" cadastrado(s) com sucesso.\n");
 
			System.out.print("Deseja cadastrar outro produto? ");
			opcao = sc.nextLine().trim();
		}
	}

	private void cadastraProduto(String nome, String tipo, double preco, int quantidade) {
		Produto novoProduto = new Produto(nome, tipo, preco, quantidade);
		estoque.cadastraProduto(novoProduto);
	}
	
	public void iniciaVenda() {
		System.out.println("\n= = = = Venda de Produtos = = = =");
		String opcao = "";
		
		while(!opcao.equals("Nao")) {
			System.out.print("Digite o nome do produto: ");
			String nome = sc.nextLine().trim();
			
			Produto produtoParaVenda = estoque.pesquisaProduto(nome);
			if(produtoParaVenda != null) { 
				
				System.out.print("Digite a quantidade a ser vendida: ");
				int quantidade = Integer.parseInt(sc.nextLine().trim());
				
				int quantidadeDisponivel = produtoParaVenda.getQuantidade();
				if(quantidade >= quantidadeDisponivel) {
					vendeProduto(nome, quantidade);
					System.out.println("==> Total arrecadado: R$ " + quantidade * produtoParaVenda.getPreco()); 
					
				} else {
					System.out.println("Não é possível vender pois não há " + nome + " suficiente."); 
					System.out.println("Há apenas " + quantidadeDisponivel + " produto(s) "+ nome + " no estoque"); 
				}
			} else System.out.println("==> " + nome + " nao cadastrado no sistema.");
			
			System.out.print("Deseja cadastrar outro produto? ");
			opcao = sc.nextLine().trim();
		}
	}
}
