package formais;

import java.rmi.UnexpectedException;
import java.util.ArrayList;

/**
 * @author mrgab
 *
 */
public class Automato {

	private int quantidadeEstados;
	private int quantidadeTransicoes;

	/**
	 * 
	 * @param quantidadeEstados
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
	 * 
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
	 * @deprecated
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

	/**
	 * @deprecated
	 * @param n
	 * @return
	 */
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
	 * V??rios estados finais
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
	 * V??rios estados finais
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
	 * V??rios estados finais
	 * 
	 * @deprecated
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
	 * V??rios estados finais
	 * 
	 * @param n
	 * @return
	 * @throws Exception
	 */
	public static Automato calcularQtdEstadosVariosEstadosFinaisQtdsDiferentes(int c, int b, int s)
			throws UnexpectedException {

		int caso = identificarCaso(c, b, s);

		// Todos as quantidades s??o iguais
		if (caso == 0) {
			return calcularQtdEstadosVariosEstadosFinaisQtdsIguais(c);
		}

		// Pega o maior e o menor numero
		int menorNumero = menorNumero(c, b, s);
		int maiorNumero = maiorNumero(c, b, s);
		int totalEstados = 0;

		// Caso 1: Menor = (apenas) um dos outros 2 (e o terceiro ?? diferente)
		if (caso == 1) {

			// Calcula quantidade de estado para n = menor
			totalEstados = calcularQtdEstadosVariosEstadosFinaisQtdsIguais(menorNumero).getQuantidadeEstados();

			// Calcular quantidade de estados
			totalEstados += (maiorNumero - menorNumero) * ((menorNumero + 1) * (menorNumero + 1));

			return new Automato(totalEstados);
		}

		// Caso 2 - O menor diferente dos outros 2 e estes outros 2 s??o iguais entre si
		if (caso == 2) { //TODO s?? est?? funcionando para o caso 2
			
			// Calcula quantidade de estado para n = menor
			totalEstados = calcularQtdEstadosVariosEstadosFinaisQtdsIguais(menorNumero).getQuantidadeEstados();

			//S?? funciona para o em que o menor ?? igual a 2 
			for (int i = menorNumero; i < maiorNumero; i++) {
				totalEstados += ((i + 1) * 6) + 3;
			}

			return new Automato(totalEstados);
		}

		// Caso 3 - Todos s??o diferentes entre si
		if (caso == 3) { //TODO fazer o caso 3
			return null;
		}

		throw new UnexpectedException("Algo deu errado, caminho n??o previsto");
	}

	/**
	 * Retorna o menor n??mero
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int menorNumero(int a, int b, int c) {
		return Integer.min(Integer.min(a, b), c);
	}

	/**
	 * Retorna o maior n??mero
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int maiorNumero(int a, int b, int c) {
		return Integer.max(Integer.max(a, b), c);
	}

	/**
	 * Identifica em qual caso a entrada de n??mero se encaixa.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return Os seguintes valores podem ser retornados:</br>
	 *         0) se os n??meros s??o iguais. </br>
	 *         1) se existe apenas um n??mero maior. </br>
	 *         2) se existe apenas um n??mero menor. </br>
	 *         3) se todos os n??mero s??o diferentes.
	 * @throws UnexpectedException      Caso n??o se encaixe em nenhum caso.
	 * @throws IllegalArgumentException Caso algum n??mero seja menor que zero.
	 */
	private static int identificarCaso(int a, int b, int c) throws UnexpectedException, IllegalArgumentException {

		// Algum n??mero negativo
		if (a < 0 || b < 0 || c < 0) {
			throw new IllegalArgumentException("Um dos valores ?? menor que zero. Argumento inv??lido.");
		}

		// N??mero iguais
		if (a == b && b == c)
			return 0;

		// Contabilizar maiores e menores
		int quantidadeMaior = 0, quantidadeMenor = 0, maior = maiorNumero(a, b, c), menor = menorNumero(a, b, c);

		ArrayList<Integer> numeros = new ArrayList<Integer>();
		numeros.add(a);
		numeros.add(b);
		numeros.add(c);

		for (Integer integer : numeros) {
			if (integer == maior) {
				quantidadeMaior++;
			}
			if (integer == menor) {
				quantidadeMenor++;
			}
		}

		// Apenas um maior -> Retorna 1
		if (quantidadeMaior == 1 && quantidadeMenor == 2) {
			return 1;
		}

		// Apenas um menor -> Retorna 2
		if (quantidadeMaior == 2 && quantidadeMenor == 1) {
			return 2;
		}

		// Todos diferentes -> Retorna 3
		if (quantidadeMaior == 1 && quantidadeMenor == 1) {
			return 3;
		}

		// Situa????o n??o esperada
		throw new UnexpectedException("Situa????o n??o esperada");
	}

	@Override
	public String toString() {
		return "Automato [quantidadeEstados=" + quantidadeEstados + ", quantidadeTransicoes=" + quantidadeTransicoes
				+ "]";
	}

}
