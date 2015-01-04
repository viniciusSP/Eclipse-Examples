package leitor.arquivos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeitorDeArquivos {

	public static void main(String[] args) throws IOException {

	//	INPUTSTREAM LÊ OS ARQUIVOS EM BYTE
	//		NESTE CASO O ARQUIVO ESTÁ DIRECIONADO NA RAIZ DO PROJETO
		
	InputStream is = new FileInputStream("arquivo.txt");
	
//	INPUTSTREAMREADER TRANSFORMA A REFERENICIA DO INPUTSTREAM EM CHAR
	InputStreamReader isr = new InputStreamReader(is);

//	POR FIM O BUFFEREDREADER TRANSFORMA OS CHARS DO STREAMREADER EM STRING
	BufferedReader br = new BufferedReader(isr);
	
//	PEGANDO ESSA STRING DO BUFFEREDREADER E TRANSFORMANDO NA NOSSA LINHA
	 String s = br.readLine(); // primeira linha
	 
//	 ENQUANTO NOSSAS LINHAS FOREM DIFERENTES DE NULL (ULTIMA LINHA SERÁ NULL)
//	 IMPRIMA ESSAS STRINGS
//	 LEIA A PROXIMA LINHA
	 while (s!= null) {
		System.out.println(s);
		s = br.readLine();
	 }
//	TEMOS DE FECHAR O BUFFEREDREADER
	 br.close();
	 }
}
