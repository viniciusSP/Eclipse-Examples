package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;

public class TestaApaga {

	public static void main(String[] args) {

		ContatoDao dao = new ContatoDao();

		dao.deleta(9);
		System.out.println("Contato excluido com sucesso!!");

	}

}
