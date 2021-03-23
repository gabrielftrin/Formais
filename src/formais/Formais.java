package formais;

public class Formais {

	public static void main(String[] args) {

		EntradaDeDados dados = new EntradaDeDados(
				"(a|b)*aa(a|b)*" //Expressão regular
				,
				"ex 3" //Nome do arquivo do automato
				);

		dados.processar();
	}

}
