package lab03;
 
import java.util.Scanner;
 
public class Main {
	static Scanner sc = new Scanner(System.in);
 
	private static final String CADASTRAR = "1";
	private static final String VENDER = "2";
	private static final String IMPRIMIR = "3";
	private static final String SAIR = "4";
 
	public static void main(String[] args) {
		Supermercado supermercado = new Supermercado();
		String opcao = "";
 
		while(!opcao.equals(SAIR)) {
			imprimeMenu();
			opcao = sc.nextLine();
 
			switch (opcao) {
			case CADASTRAR:
				supermercado.iniciaCadastro();
				break;
			case VENDER:
				supermercado.iniciaVenda();
				break;
			case IMPRIMIR:
				break;
			case SAIR:
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
 
	private static void imprimeMenu() {
		System.out.print("\n= = = = Bem-vindo(a) ao EconomizaP2 = = = =\n"
				+ "Digite a opção desejada:\n\n"
				+ "1 - Cadastrar um Produto\n"
				+ "2 - Vender um Produto\n"
				+ "3 - Imprimir Balanço\n"
				+ "4 - Sair\n\n"
				+ "Opção: ");
	}
}