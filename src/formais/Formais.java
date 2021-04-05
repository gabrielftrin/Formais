package formais;

public class Formais {

	public static boolean metodo(int a, int b, int c, String palavra) {

		if (a < 1 || b < 1 || c < 1) {
			return false;
		}

		return true;

	}

	public static void main(String[] args) {

		EntradaDeDados dados = new EntradaDeDados(
					"("
					+ "((c|b|s)*)"
					+ "c"
					+ "((c|b|s)*)"
					+ "c"
					+ "((c|b|s)*)|" 
					+ "((c|b|s)*)"
					+ "b"
					+ "((c|b|s)*)"
					+ "b"
					+ "((c|b|s)*)|"
					+ "((c|b|s)*)"
					+ "s"
					+ "((c|b|s)*)"
					+ "s"
					+ "((c|b|s)*)"
					+ "s"
					+ "((c|b|s)*))" // Expressão
																														// regular
				, "automato223" // Nome do arquivo do automato
				, "C:\\Users\\mrgab\\Google Drive\\5-Formais\\"// Camindo da pasta base. Exemplo: C:\\Users\\Joao
		);

		dados.processar();

//		for (String string : dados.getListaPalavrasAceitasExpressao()) {
//			System.out.println(string);
//		}

		// dados.preencherListaDePalavrasPossiveis("a","b");

		// EntradaDeDados.imprimir(metodo(0, 0, 0, "a"));
 

	}

}
