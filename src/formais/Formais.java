package formais;

public class Formais {

	public static void main(String[] args) {

		EntradaDeDados dados = new EntradaDeDados("(a|b)*aa(a|b)*", "ex 1",
				"C:\\Users\\mrgab\\Google Drive\\5-Formais\\");
		dados.imprimir(dados.getExpressaoRegular());

		dados.lerEntradas();

		for (int i = 0; i < dados.getListaPalavrasLidasExpressao().size(); i++) {

			if (dados.getListaPalavrasLidasExpressao().get(i).matches(dados.getExpressaoRegular())) {
				dados.getListaPalavrasAceitasExpressao().add(dados.getListaPalavrasLidasExpressao().get(i));
			}
		}

		dados.imprimir("Palavras aceitas pela expressão: " + dados.getListaPalavrasAceitasExpressao().size());

		dados.lerResultados();

		for (int i = 0; i < dados.getListaPalavrasResultadoAutomato().size(); i++) {
			if (dados.getListaPalavrasResultadoAutomato().get(i).contains(dados.getTipoResultado())) {
				dados.getListaPalavrasAceitasAutomato().add(dados.getListaPalavrasResultadoAutomato().get(i));
			}
		}

		dados.imprimir("Palavras aceitas pelo automato: " + dados.getListaPalavrasAceitasAutomato().size());
	}

}
