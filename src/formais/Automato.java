/**
 * 
 */
package formais;

/**
 * @author mrgab
 *
 */
public class Automato {

	private int quantidadeEstados;
	private int quantidadeTransicoes;

	/**
	 * 
	 */
	public Automato(int quantidadeEstados) {
		this.setQuantidadeEstados(quantidadeEstados);
		setQuantidadeTransicoes();
	}

	/**
	 * @return the quantidadeEstados
	 */
	public int getQuantidadeEstados() {
		return quantidadeEstados;
	}

	/**
	 * @param quantidadeEstados the quantidadeEstados to set
	 */
	public void setQuantidadeEstados(int quantidadeEstados) {
		this.quantidadeEstados = quantidadeEstados;
		setQuantidadeTransicoes();
	}

	/**
	 * @return the quantidadeTransicoes
	 */
	public int getQuantidadeTransicoes() {
		return quantidadeTransicoes;
	}

	private void setQuantidadeTransicoes() {
		this.quantidadeTransicoes = getQuantidadeEstados() * 3;
	}

	/**
	 * O 'ponto medio' representa uma coluna (quantidade de caracteres lidos) de
	 * estados que possui a maior quantidade completa de estados
	 * 
	 * @param n
	 * @return
	 */
	private static int pontoMedioUmEstadoFinalQtdsIguais(int n) {

		if (n < 1) {
			return 0;
		}

		int aux = 0;

		for (int i = 0; i < n; i++) {

			aux = aux + i + 1;

		}

		return aux;

	}

	public static Automato calcularQtdEstadosUmEstadoFinalQtdsIguais(int n) {

		if (n < 0) {
			return null;
		}

		int totalEstados = 0;

		int pontoMedio = pontoMedioUmEstadoFinalQtdsIguais(n); // Amarelo
		int maiorNumero = pontoMedio + n - 2; // Laranja

		if (n < 3) {
			maiorNumero = 0;
		}

		if (n != 1) {
			for (int i = 0; i < n + 1; i++) {

				totalEstados = totalEstados + pontoMedioUmEstadoFinalQtdsIguais(i);

			}

			totalEstados = (totalEstados * 2) + maiorNumero + 1;
		} else {
			totalEstados = 2;
		}

		return new Automato(totalEstados);
	}

	/**
	 * Vários estados finais
	 * 
	 * @param n
	 * @return
	 */
	private static int pontoMedioVariosEstadosFinaisQtdsIguais(int n) {

		if (n < 1) {
			return 1;
		}

		int aux = 0;

		for (int i = 0; i < n + 1; i++) {

			aux = aux + i + 1;

		}

		return aux;

	}

	/**
	 * Vários estados finais
	 * 
	 * @param n
	 * @return
	 */
	public static Automato calcularQtdEstadosVariosEstadosFinaisQtdsIguais(int n) {

		if (n < 0) {
			return null;
		}

		int totalEstados = 0;

		int pontoMedioDoSucessorDeN = pontoMedioVariosEstadosFinaisQtdsIguais(n + 1); // Amarelo
		int maiorNumero = pontoMedioDoSucessorDeN - 3; // Laranja

		if (n < 2) {
			maiorNumero = 0;
		}

		if (n > 1) {
			// Calcular um lado (uma metade) da quantidade de caracteres lidos
			for (int i = 0; i < n + 1; i++) {

				totalEstados = totalEstados + pontoMedioVariosEstadosFinaisQtdsIguais(i);

			}

			totalEstados = (totalEstados * 2) + maiorNumero;
		} else {
			totalEstados = (n == 0) ? 1 : 8;
		}

		return new Automato(totalEstados);
	}

	/**
	 * Vários estados finais
	 * 
	 * @param n
	 * @return
	 */
	public static int pontoMedioVariosEstadosFinaisQtdsDiferentes(int c, int b, int s) {

//		if (n < 1) {
//			return 1;
//		}
//
//		int aux = 0;
//
//		for (int i = 0; i < n + 1; i++) {
//
//			aux = aux + i + 1;
//
//		}
//
//		return aux;

		return 0;
	}

	/**
	 * Vários estados finais
	 * 
	 * @param n
	 * @return
	 * @throws Exception
	 */
	public static Automato calcularQtdEstadosVariosEstadosFinaisQtdsDiferentes(int c, int b, int s) throws Exception {

		// Todos as quantidades são iguais
		if (c == b && b == s) {
			return calcularQtdEstadosVariosEstadosFinaisQtdsIguais(c);
		}

		// Pega o menor numero
		int menorNumero = menorNumero(c, b, s);
		int totalEstados = 0;

		// Caso 1: Menor = (apenas) um dos outros 2 (e o terceiro é diferente)
		// TODO: Guardar os números em uma lista
		int contador = 0;

		if (menorNumero == c)
			contador++;

		if (menorNumero == b)
			contador++;

		if (menorNumero == s)
			contador++;

		if (contador == 2) {

			// Calcula quantidade de estado para n = menor
			totalEstados = calcularQtdEstadosVariosEstadosFinaisQtdsIguais(menorNumero).getQuantidadeEstados();

			// Identificar o maior numero
			int maiorNumero = 0;
			if (c > menorNumero) {
				maiorNumero = c;
			}
			if (b > menorNumero) {
				maiorNumero = b;
			}
			if (s > menorNumero) {
				maiorNumero = s;
			}

			//Calcular quantidade de estados
			totalEstados += (maiorNumero - menorNumero) * ((menorNumero + 1) * (menorNumero + 1));

			return new Automato(totalEstados);
		}

		// Caso 2 - O menor diferente dos outros 2 e estes outros 2 são iguais entre si
		if (contador == 1) {
			if (c == b || b == s || c == s) {
				return null;
			}
		}

		// Caso 3 - Todos são diferentes entre si
		if (contador == 1) {
			if (c != b || b != s || c != s) {
				return null;
			}
		}

		throw new Exception("Algo deu errado, caminho não previsto");

//		// Se algum valor for menor que 1, retorna null
//		if (c < 1 || b < 1 || s < 1) {
//			return null;
//		}

//		int totalEstados = 0;

//		int pontoMedioDoSucessorDeN = pontoMedioVariosEstadosFinaisQtdsIguais(n + 1); // Amarelo
//		int maiorNumero = pontoMedioDoSucessorDeN - 3; // Laranja
//
//		if (n < 2) {
//			maiorNumero = 0;
//		}
//
//		if (n > 1) {
//			// Calcular um lado (uma metade) da quantidade de caracteres lidos
//			for (int i = 0; i < n + 1; i++) {
//
//				totalEstados = totalEstados + pontoMedioVariosEstadosFinaisQtdsIguais(i);
//
//			}
//
//			totalEstados = (totalEstados * 2) + maiorNumero;
//		} else {
//			totalEstados = (n == 0) ? 1 : 8;
//		}

//		return new Automato(totalEstados);
	}

	/**
	 * Retorna o menor número
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int menorNumero(int a, int b, int c) {
		return Integer.min(Integer.min(a, b), c);
	}

//	/**
//	 * Retorna qual o indice do menor número
//	 * 
//	 * @param a
//	 * @param b
//	 * @param c
//	 * @return
//	 */
//	private static int qualMenorNumero(int a, int b, int c) {
//		return menorNumero(a, b, c) == a ? 1 : (menorNumero(a, b, c) == b ? 2 : 3);
//
//	}

	@Override
	public String toString() {
		return "Automato [quantidadeEstados=" + quantidadeEstados + ", quantidadeTransicoes=" + quantidadeTransicoes
				+ "]";
	}

}
