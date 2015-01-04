package br.caelum.testeio;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TestaEntrada {

	public static void main(String[] args) throws IOException {

		// PELA ENTRADA DO TECLADO
		InputStream in = System.in;
		Scanner entrada = new Scanner(in);
		System.out.println("Digite a sua mensagem: ");

		// PELO ARQUIVO
		// FileInputStream is = new FileInputStream("arquivo.txt");
		// Scanner entrada = new Scanner(is);

		OutputStream os = new FileOutputStream("saida.txt");
		OutputStreamWriter osw = new OutputStreamWriter(os);
		BufferedWriter bw = new BufferedWriter(osw);

		while (entrada.hasNextLine()) {
			String linha = entrada.nextLine();
			bw.write(linha);
			bw.newLine();
		}
		bw.close();

		// IMPRIMINDO A SAIDA NO CONSOLE
		// while (entrada.hasNextLine()) {
		// System.out.println(entrada.nextLine());
		// }
		// entrada.close();

	}

}