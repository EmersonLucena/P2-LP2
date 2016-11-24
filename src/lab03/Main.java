package lab03;
 
import java.util.Scanner;
 
public class Main {
	//TODO retirar prints do main
	static Scanner sc = new Scanner(System.in);
	private static final String NL = System.lineSeparator(); 
 
	private static final String CADASTRAR = "1";
	private static final String VENDER = "2";
	private static final String IMPRIMIR = "3";
	private static final String SAIR = "4";
 
	public static void main(String[] args) {
		Supermercado supermercado = new Supermercado();
		String opcao;
 
		do {
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
				supermercado.imprimeBalanco();
				break;
			case SAIR:
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		} while(!opcao.equals(SAIR));
	}
 
	private static void imprimeMenu() {
		System.out.print(NL + "= = = = Bem-vindo(a) ao EconomizaP2 = = = =" + NL
				+ "Digite a opção desejada:" + NL + NL
				+ "1 - Cadastrar um Produto" + NL
				+ "2 - Vender um Produto" + NL
				+ "3 - Imprimir Balanço" + NL
				+ "4 - Sair" + NL + NL
				+ "Opção: ");
	}
}