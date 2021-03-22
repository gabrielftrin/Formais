package formais;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Formais {
	
	public static String regex = "aba|ab*|(ab)*";

	public static String caminhoBase = "C:\\Users\\mrgab\\Google Drive\\5-Formais\\";
	public static String entradaDeDado = caminhoBase.concat("entradas_ab.txt");
	public static String nomeArquivoAutomato = "ex 3";
	
	public static String resultadoAutomato = caminhoBase.concat("results" + nomeArquivoAutomato + ".jff.txt");	
	public static String tipoResultado = " Accept";

	public static void imprimir(Object object) {
		System.out.println(object);
	}

	public static void imprimirLinha(Object object) {
		System.out.print(object);

	}
	
	public static List<String> palavrasDaLista(String caminhoArquivo) {

		List<String> palavras = new ArrayList<>();

		try {
			File arquivo = new File(caminhoArquivo);
			Scanner sc = new Scanner(arquivo);
			while (sc.hasNext()) {
				palavras.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return palavras;
	}

	public static void main(String[] args) {

		List<String> p = palavrasDaLista(entradaDeDado);
		imprimir("Expressão: " + regex);

		int qtdPalavrasAceitasRegex = 0;

		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).matches(regex)) {
				imprimir(p.get(i));
				qtdPalavrasAceitasRegex++;
			}
		}
		qtdPalavrasAceitasRegex = ("".matches(regex)) ? qtdPalavrasAceitasRegex-- : qtdPalavrasAceitasRegex;
		imprimir("Palavras aceitas pela expressão: " + qtdPalavrasAceitasRegex);

		List<String> resultadosDoAutomato = palavrasDaLista(resultadoAutomato);
		int QtdPalavrasAceitasAutomato = 0;
		for (int i = 0; i < resultadosDoAutomato.size(); i++) {

			if (resultadosDoAutomato.get(i).contains(tipoResultado)) {
				imprimir(resultadosDoAutomato.get(i));
				QtdPalavrasAceitasAutomato++;
			}
		}
		imprimir("Palavras aceitas pelo automato:" + QtdPalavrasAceitasAutomato);
	}

}
