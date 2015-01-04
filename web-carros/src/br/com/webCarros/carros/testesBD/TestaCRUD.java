package br.com.webCarros.carros.testesBD;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.webCarros.carros.dao.CarroDAO;
import br.com.webCarros.carros.model.Carro;

public class TestaCRUD {

	private static CarroDAO dao;

	@Autowired
	public TestaCRUD(CarroDAO dao) {
		this.dao = dao;
	}

	public static void chamaAdiciona() throws Exception {
		Carro carro = new Carro();

		String anoAdiciona, marcaAdiciona, nomeAdiciona;

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o ano do Carro: ");
		anoAdiciona = sc.nextLine();

		System.out.println("Digite a Marca:  ");
		marcaAdiciona = sc.nextLine();

		System.out.println("Digite o nome: ");
		nomeAdiciona = sc.nextLine();

		carro.setAno(anoAdiciona);
		carro.setMarca(marcaAdiciona);
		carro.setNome(nomeAdiciona);


		dao.Adiciona(carro);

	}

	public static void chamaLista() throws Exception {

		List<Carro> listaCarros = dao.getLista();
		System.out.println("\t LISTA DE CARROS NO BANCO ");
		for (Carro carro : listaCarros) {

			System.out.println("| ID: " + carro.getId() + " | Ano: "
					+ carro.getAno() + " | Marca: " + carro.getMarca()
					+ " | Nome: " + carro.getNome());
		}

	}

	public static void chamaDeleta() throws Exception {

		int idCarro = 2;

		Scanner sc = new Scanner(System.in);

		System.out.println("\n\nDigite o ID do Carro que deseja excluir: ");
		idCarro = sc.nextInt();

		// dao.deletaCarro(idCarro);

	}

	public static void chamaAltera() throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o ID do carro que deseja alterar:");
		int escolhaNum = (int) sc.nextLong();
		sc.nextLine();

		Carro carro = new Carro();

		String novoAno, nomaMarca, novoNome;

		System.out.println("Digite o ano do Carro: ");
		novoAno = sc.nextLine();

		System.out.println("Digite a Marca:  ");
		nomaMarca = sc.nextLine();

		System.out.println("Digite o nome: ");
		novoNome = sc.nextLine();

		carro.setAno(novoAno);
		carro.setMarca(nomaMarca);
		carro.setNome(novoNome);


		dao.AlteraCarro(escolhaNum, carro);

	}

	private static Scanner mandaEsperar() {
		Scanner espera = new Scanner(System.in);
		System.out.println("\n\nPressione ENTER para voltar ao MENU\n\n");
		espera.nextLine();
		return espera;
	}

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n;

		System.out.printf("Informe uma opcao desejada: \n\n");
		System.out.println("1 - Testar Insercao: ");
		System.out.println("2 - Testar Listar: ");
		System.out.println("3 - Testar Apagar: ");
		System.out.println("4 - Testar Altera: ");
		System.out.println("0 - Sair: ");
		n = sc.nextInt();
		Scanner espera = mandaEsperar();
		switch (n) {
		case 1:
			TestaCRUD.chamaAdiciona();
			TestaCRUD.chamaLista();
			mandaEsperar();
		case 2:
			TestaCRUD.chamaLista();
			mandaEsperar();
			main(null);
		case 3:
			TestaCRUD.chamaLista();
			TestaCRUD.chamaDeleta();
			TestaCRUD.chamaLista();
			mandaEsperar();
		case 4:
			TestaCRUD.chamaLista();
			TestaCRUD.chamaAltera();
			TestaCRUD.chamaLista();
			mandaEsperar();
		case 0:
			System.out.println("\n\nSaindo do Sistema\nBye");
			break;
		}

	}

}
