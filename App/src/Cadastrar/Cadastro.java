package Cadastrar;

import Dados.DadosIniciais;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {

	public static void main(String[] args) {
		Inicio();
	}

	public static void Inicio() {
		Scanner scan = new Scanner(System.in);
		List<DadosIniciais> lista = new ArrayList<>();
		int opc;

		do {
			opc = Menu(lista);
			switch (opc) {
			case 1:
				Cadastrar(lista);
				break;
			case 2:
				Visualizar(lista);
				break;
			case 3:
				Editar(lista);
				break;
			case 4:
				Excluir(lista);
				break;
			case 5:
				System.out.println("Sistema encerrado!");
				break;
			default:
				System.out.println("Opção invalida!");
				break;
			}
		} while (opc != 5);

	}

	static int Menu(List<DadosIniciais> lista) {
		Scanner scan = new Scanner(System.in);
		System.out.println("\n---Menu---");
		System.out.println("1-Cadastrar novo usuario.");
		System.out.println("2-Visualizar usuario.");
		System.out.println("3-Editar usuario.");
		System.out.println("4-Excluir usuario.");
		System.out.println("5-Sair.");
		int opc = scan.nextInt();
		return opc;
	}

	static void Cadastrar(List<DadosIniciais> lista) {
		Scanner scan = new Scanner(System.in);
		DadosIniciais Dados = new DadosIniciais();

		System.out.println("\nPreencha os dados abaixo:");
		System.out.print("Nome: ");
		Dados.setNome(scan.nextLine());
		System.out.print("Data de Nascimento: ");
		Dados.setDataNascimento(scan.nextLine());
		System.out.print("Cargo: ");
		Dados.setCargo(scan.nextLine());
		lista.add(Dados);
		System.out.println("Usuario cadastrado com sucesso!");
	}

	static void Visualizar(List<DadosIniciais> lista) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Qual nome do funcionario que deseja visualizar?");
		String nomeBusca = scan.nextLine();

		for (DadosIniciais busca : lista) {
			if (busca.getNome().equalsIgnoreCase(nomeBusca)) {
				System.out.println("Nome: " + busca.getNome());
				System.out.println("Data de Nascimento: " + busca.getDataNascimento());
				System.out.println("Cargo: " + busca.getCargo());
				return;
			}
		}
		System.out.println("Usuario não encontrado!");
	}

	static void Editar(List<DadosIniciais> lista) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Qual nome do funcionario que deseja editar?");
		String nomeBusca = scan.nextLine();

		for (DadosIniciais busca : lista) {
			if (busca.getNome().equalsIgnoreCase(nomeBusca)) {
				System.out.println("Nome: " + busca.getNome());
				System.out.println("Data de Nascimento: " + busca.getDataNascimento());
				System.out.println("Cargo: " + busca.getCargo());
				
				char alt = 'S';
				
				while(alt == 'S'|| alt =='s') {	
				System.out.println("Qual dado deseja alterar? \n1-Nome\n2-Data de Nascimento\n3-Cargo");
				int opc = scan.nextInt();
				scan.nextLine();

			switch(opc) {
			case 1:
				System.out.println("Qual o Nome correto?");
				busca.setNome(scan.nextLine());
				System.out.println("Nome alterado!");
				break;
			case 2: 
				System.out.println("Qual a Data de Nascimento correta?");
				busca.setDataNascimento(scan.nextLine());
				System.out.println("Data de Nascimento alterado!");
				break;
			case 3:
				System.out.println("Qual o Cargo correto?");
				busca.setCargo(scan.nextLine());
				System.out.println("Cargo alterado!");
				break;
			default: 
				System.out.println("Opção invalida!");
				break;
			}
			System.out.println("Deseja Alterar outra informação?\nS-Sim\nN-Não");
			alt = scan.next().charAt(0);
			scan.nextLine();
			}
			System.out.println("\nDados alterados:");
			System.out.println("Nome: " + busca.getNome());
			System.out.println("Data de Nascimento: " + busca.getDataNascimento());
			System.out.println("Cargo: " + busca.getCargo());
			return;
		}
		System.out.println("Usuario não encontrado!");
	}
	}

	static void Excluir(List<DadosIniciais> lista) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Qual nome do funcionario que deseja excluir?");
		String nomeBusca = scan.nextLine();

		for (int i = 0; i < lista.size(); i++) {
			DadosIniciais usuario = lista.get(i);
			if (usuario.getNome().equalsIgnoreCase(nomeBusca)) {
				System.out.println("Usuario:");
				System.out.println("Nome: " + usuario.getNome());
				System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
				System.out.println("Cargo: " + usuario.getCargo());

				System.out.println("\nDeseja continuar exclusão?\n1-Sim\n2-Não");
				int resp = scan.nextInt();

				switch (resp) {
				case 1:
					lista.remove(i);
					System.out.println("Usuario excluido!");
					break;
				case 2:
					System.out.println("Operação cancelada!");
					break;
				}
				return;
			}
		}
		System.out.println("Usuario não encontrado!");
	}

}
