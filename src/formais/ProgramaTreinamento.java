package formais;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProgramaTreinamento {

	public static void main(String[] args) throws IOException {
 	
		new PrintWriter(new FileWriter("C:\\Users\\mrgab\\Google Drive\\5-Formais\\teste.txt")).printf("conteudo").close();

	}

}
