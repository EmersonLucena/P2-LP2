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
 
			System.out.print("Digite o preço unitário do produto: ");
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
}
