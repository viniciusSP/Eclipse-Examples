package br.com.caelum.jdbc.teste;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInterfaceDao {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n;

		System.out.printf("Informe ua opcao desejada: \n\n");
		System.out.println("1 - Testar Insercao: ");
		System.out.println("2 - Testar Listar: ");
		System.out.println("3 - Testar Apagar: ");
		System.out.println("0 - Sair: ");
		n = sc.nextInt();

		switch (n) {
		case 1:
			// pronto para gravar
			Contato contato = new Contato();
			contato.setNome("Caelum");
			contato.setEmail("contatovinicius@caelum.com.br");
			contato.setEndereco("R.Vergueiro 3185 cj57");
			contato.setDataNascimento(Calendar.getInstance());

			// grave nessa conexao!!

			ContatoDao dao = new ContatoDao();

			// metodo elegante!!

			dao.adiciona(contato);

			System.out.println("Gravado!!!");
			sc.nextLine();
			System.in.read();
			break;

		case 2:
			ContatoDao dao2 = new ContatoDao();
			List<Contato> contatos = dao2.getLista();

			for (Contato contato1 : contatos) {
				System.out.println("ID: " + contato1.getId());
				System.out.println("Nome: " + contato1.getNome());
				System.out.println("Email: " + contato1.getEmail());
				System.out.println("Endereco: " + contato1.getEndereco());
				System.out.println("Data de Nascimento: "
						+ contato1.getDataNascimento().getTime() + "\n");

			}
			sc.nextLine();
			System.in.read();
			break;

		case 3:
			ContatoDao dao3 = new ContatoDao();
			System.out.println("Digite o ID que deseja excluir ");
			n = sc.nextInt();
			dao3.deleta(n);
			sc.nextLine();
			System.out.println("Contato excluido com sucesso!!");
			System.in.read();
			break;
		default:
			break;
		}
		main(null);
	}

}
