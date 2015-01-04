package leitor.arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeitorDeArquivosJavaIO {
	
	public static void main(String args[]) {

//		DECLARANDO FILE ONDE O ARQUIVO SERÁ CRIADO FILE É DO JAVA.IO
		File f = new File("ArquivoCriado.txt");

		
		try {
			
//		UTILIZANDO O FILEWRITER PARA GRAVAR O ARQUIVO CRIADO ACIMA
			FileWriter fw = new FileWriter(f);
//		MESMO CONCEITO DO INPUTSTREAM GRAVANDO EM STRING COM O BUFFEREDWRITER
			BufferedWriter bw = new BufferedWriter(fw);
//			ESCREVENDO O QUE EU QUERO NO MEU ARQUIVO
			bw.write("Esse texto está sendo inserido");
			
			//INSERE UMA NOVA LINHA
			bw.newLine();
			
			bw.write("Continua sendo inserido em uma nova linha");
			
			bw.newLine();
			
			bw.write("Continua sendo inserido em uma 3ª linha");
			
			bw.newLine();
			bw.write("Acabou");
			
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//EFETUANDO A LEITURA
		try {
			
//			EFETUANDO A LEITURA COM FILEREADER DA CLASSE JAVA.IO
			FileReader fr = new FileReader(f);

//			MESMO CONCEITO DO OUTPUTSTREAM AQUI CONVERTIVO PARA CHAR
			BufferedReader br = new BufferedReader(fr);

			String s;
			
			//ENQUANTO EXISTE DADOS CONTINUA IMPRIMINDO
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			System.out.println("###### Erro: "+e.getMessage());
			e.printStackTrace();
		}
	}
}
