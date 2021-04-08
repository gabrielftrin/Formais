/**
 * 
 */
package formais;

import java.util.Objects;

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
		this.quantidadeTransicoes = quantidadeEstados * 3;
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
	}

	/**
	 * @return the quantidadeTransicoes
	 */
	public int getQuantidadeTransicoes() {
		return quantidadeTransicoes;
	}

	public static int pontoMedio(int n) {

		if (n < 1) {
			return 0;
		}

		return n + pontoMedio(n - 1);
	}

	public static Automato gerarAutomatoQtdIguais(int n) {

		if (n < 0) {
			return null;
		}

		int totalEstados = 0;

		if (n < 3) {
			switch (n) {
			case 0:
				totalEstados = 1;

				break;
			case 1:
				totalEstados = 1;

				break;
			case 2:
				totalEstados = 1;

				break;

			default:
				break;
			}
			return new Automato(totalEstados);
		}

		int pontoMedio = pontoMedio(n); // Amarelo
		int maiorNumero = pontoMedio + n - 2; // Laranja

		for (int i = 0; i < n + 1; i++) {

			totalEstados = totalEstados + pontoMedio(i);

		}

		totalEstados = (totalEstados * 2) + maiorNumero + 1;

		return new Automato(totalEstados);
	}

	@Override
	public int hashCode() {
		return Objects.hash(quantidadeEstados, quantidadeTransicoes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Automato)) {
			return false;
		}
		Automato other = (Automato) obj;
		return quantidadeEstados == other.quantidadeEstados && quantidadeTransicoes == other.quantidadeTransicoes;
	}

	@Override
	public String toString() {
		return "Automato [quantidadeEstados=" + quantidadeEstados + ", quantidadeTransicoes=" + quantidadeTransicoes
				+ "]";
	}

}
