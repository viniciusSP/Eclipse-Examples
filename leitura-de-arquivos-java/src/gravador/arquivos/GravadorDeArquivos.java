package gravador.arquivos;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class GravadorDeArquivos {

	public static void main(String[] args) throws IOException {
//		ESTOU INDICANDO ONDE SERÁ A SAIDA (BYTE)
		OutputStream os = new FileOutputStream("saida.txt");

//		ESTOU INDICANDO E A SAIDA FOI CONVERTIDA EM CHAR
		OutputStreamWriter osw = new OutputStreamWriter(os);

//		ESTOU LENDO A SAIDA QUE É UMA STRING(SERÁ CONVERTIDO PARA CHAR E DEPOIS PARA BYTE)
		BufferedWriter bw = new BufferedWriter(osw);

//		ESTOU ESCREVENDO O QUE QUERO NA SAIDA
		bw.write("caelum");
//		FECHANDO A ESCRITA
		bw.close();
	}
}