package formais;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mrgab
 *
 */
public class EntradaDeDados {

	private String expressaoRegular;

	private String caminhoBase;
	private String nomeArquivoEntradaDados;
	private String nomeArquivoAutomato;
	private String nomeArquivoResultadoAutomato;

	private String tipoResultado;

	private ArrayList<String> listaPalavrasLidasExpressao = new ArrayList<>();
	private ArrayList<String> listaPalavrasAceitasExpressao = new ArrayList<>();

	private ArrayList<String> listaPalavrasResultadoAutomato = new ArrayList<>();
	private ArrayList<String> listaPalavrasAceitasAutomato = new ArrayList<>();

	/**
	 * @param expressaoRegular
	 * @param nomeArquivoAutomato     deve ser informado no formato "automato1.jff"
	 *                                (com a extensão)
	 * @param caminhoBase             deve ser informado no formato "C:\\Users\\"
	 * @param nomeArquivoEntradaDados deve ser informado no formato
	 *                                "entradas_ab.txt"
	 */
	public EntradaDeDados(String expressaoRegular, String caminhoBase, String nomeArquivoEntradaDados,
			String nomeArquivoAutomato) {

		this.expressaoRegular = expressaoRegular;

		this.caminhoBase = caminhoBase;
		this.nomeArquivoEntradaDados = caminhoBase + nomeArquivoEntradaDados;
		this.nomeArquivoAutomato = nomeArquivoAutomato;
		this.nomeArquivoResultadoAutomato = caminhoBase + "results" + nomeArquivoAutomato + ".txt";

		tipoResultado = "  Result: Accept ";
	}

	/**
	 * @return the expressaoRegular
	 */
	public String getExpressaoRegular() {
		return expressaoRegular;
	}

	/**
	 * @param expressaoRegular the expressaoRegular to set
	 */
	public void setExpressaoRegular(String expressaoRegular) {
		this.expressaoRegular = expressaoRegular;
	}

	/**
	 * @return the caminhoBase
	 */
	public String getCaminhoBase() {
		return caminhoBase;
	}

	/**
	 * @param caminhoBase the caminhoBase to set
	 */
	public void setCaminhoBase(String caminhoBase) {
		this.caminhoBase = caminhoBase;
		setNomeArquivoAutomato(getNomeArquivoAutomato());
		setNomeArquivoEntradaDados(getNomeArquivoEntradaDados());
		setNomeArquivoAutomato(getNomeArquivoAutomato());
	}

	/**
	 * @return the nomeArquivoEntradaDados
	 */
	public String getNomeArquivoEntradaDados() {
		return nomeArquivoEntradaDados;
	}

	/**
	 * @param nomeArquivoEntradaDados the nomeArquivoEntradaDados to set
	 */
	public void setNomeArquivoEntradaDados(String nomeArquivoEntradaDados) {
		this.nomeArquivoEntradaDados = caminhoBase + nomeArquivoEntradaDados;
	}

	/**
	 * @return the nomeArquivoAutomato
	 */
	public String getNomeArquivoAutomato() {
		return nomeArquivoAutomato;
	}

	/**
	 * @param nomeArquivoAutomato the nomeArquivoAutomato to set
	 */
	public void setNomeArquivoAutomato(String nomeArquivoAutomato) {
		this.nomeArquivoAutomato = nomeArquivoAutomato;
	}

	/**
	 * @return the nomeArquivoResultadoAutomato
	 */
	public String getNomeArquivoResultadoAutomato() {
		return nomeArquivoResultadoAutomato;
	}

	/**
	 * @param nomeArquivoResultadoAutomato the nomeArquivoResultadoAutomato to set
	 *                                     informe apenas o nome do arquivo, sem o
	 *                                     caminho
	 */
	public void setNomeArquivoResultadoAutomato(String nomeArquivoResultadoAutomato) {
		this.nomeArquivoResultadoAutomato = caminhoBase + nomeArquivoResultadoAutomato;
	}

	/**
	 * @return the tipoResultado
	 */
	public String getTipoResultado() {
		return tipoResultado;
	}

	/**
	 * @param tipoResultado the tipoResultado to set define qual string deve conter
	 *                      na linha para ela ser considerada para entrar na lista
	 */
	public void setTipoResultado(String tipoResultado) {
		this.tipoResultado = tipoResultado;
	}

	/**
	 * @return the listaPalavrasLida
	 */
	public List<String> getListaPalavrasLidasExpressao() {
		return listaPalavrasLidasExpressao;
	}

	/**
	 * @param listaPalavrasLida the listaPalavrasLida to set
	 */
	public void setListaPalavrasLidasExpressao(ArrayList<String> listaPalavrasLida) {
		this.listaPalavrasLidasExpressao = listaPalavrasLida;
	}

	/**
	 * @return the listaPalavrasAceitas
	 */
	public List<String> getListaPalavrasAceitasExpressao() {
		return listaPalavrasAceitasExpressao;
	}

	/**
	 * @param listaPalavrasAceitas the listaPalavrasAceitas to set
	 */
	public void setListaPalavrasAceitas(ArrayList<String> listaPalavrasAceitas) {
		this.listaPalavrasAceitasExpressao = listaPalavrasAceitas;
	}

	/**
	 * @return the listaPalavrasResultado
	 */
	public List<String> getListaPalavrasResultadoAutomato() {
		return listaPalavrasResultadoAutomato;
	}

	/**
	 * @param listaPalavrasResultado the listaPalavrasResultado to set
	 */
	public void setListaPalavrasResultadoAutomato(ArrayList<String> listaPalavrasResultado) {
		this.listaPalavrasResultadoAutomato = listaPalavrasResultado;
	}

	/**
	 * @return the listaPalavrasAceitasAutomato
	 */
	public List<String> getListaPalavrasAceitasAutomato() {
		return listaPalavrasAceitasAutomato;
	}

	/**
	 * @param listaPalavrasAceitasAutomato the listaPalavrasAceitasAutomato to set
	 */
	public void setListaPalavrasAceitasAutomato(ArrayList<String> listaPalavrasAceitasAutomato) {
		this.listaPalavrasAceitasAutomato = listaPalavrasAceitasAutomato;
	}

	public void lerResultadosDoAutomato() {

		ArrayList<String> linhas = new ArrayList<>();

		try {
			Scanner sc = new Scanner(new File(this.nomeArquivoResultadoAutomato));
			while (sc.hasNext()) {
				linhas.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.listaPalavrasResultadoAutomato = linhas;
	}

	public void lerArquivoDeEntradaDeDados() {

		ArrayList<String> linhas = new ArrayList<>();

		try {
			Scanner sc = new Scanner(new File(this.nomeArquivoEntradaDados));
			while (sc.hasNext()) {
				linhas.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		this.listaPalavrasLidasExpressao = linhas;
	}

	public void verificarPalavrasAceitasExpressao() {

		for (int i = 0; i < getListaPalavrasLidasExpressao().size(); i++) {
			if (getListaPalavrasLidasExpressao().get(i).matches(getExpressaoRegular())) {
				getListaPalavrasAceitasExpressao().add(getListaPalavrasLidasExpressao().get(i));
			}
		}

	}

	public void verificarPalavrasAceitasAutomato() {

		for (int i = 0; i < getListaPalavrasResultadoAutomato().size(); i++) {
			if (getListaPalavrasResultadoAutomato().get(i).contains(getTipoResultado())) {
				getListaPalavrasAceitasAutomato().add(getListaPalavrasResultadoAutomato().get(i));
			}
		}

	}

	public void imprimirPalavrasAceitasExpressao() {
		System.out.println(("Palavras aceitas pela expressão: " + getListaPalavrasAceitasExpressao().size()));
	}

	public void imprimirPalavrasAceitasAutomato() {
		System.out.println(("Palavras aceitas pelo automato: " + getListaPalavrasAceitasAutomato().size()));
	}

	public void processar() {
		lerArquivoDeEntradaDeDados();
		verificarPalavrasAceitasExpressao();
		imprimirPalavrasAceitasExpressao();

		lerResultadosDoAutomato();
		verificarPalavrasAceitasAutomato();
		imprimirPalavrasAceitasAutomato();

		System.out.println("Todas as palavras aceitas pelo autômato são aceitas pela expressão (e vice-versa)? "
				+ todasAsPalavrasSaoAceitasPelaExpressaoEPeloAutomato());

	}

	/**
	 * Cria uma lista com todas as possibildiades de palavras a partir dos 'param'
	 * informados.
	 * 
	 * @param qtdCaracteres Quantidade de caracteres máxima da última palavra
	 * @param param         Letras ou palavras a serem processadas
	 * @return Uma lista de todas as palavras
	 */
	public ArrayList<String> gerarListaDePalavras(int qtdCaracteres, String... param) {

		if (param == null) {
			return null;
		}

		// Declarar lista
		ArrayList<String> listaDePalavrasGeradas = new ArrayList<String>();

		// Preencher lista principal com os unitarios dos simbolos
		for (String string : param) {
			listaDePalavrasGeradas.add(string);
		}

		if (qtdCaracteres > 1) {

			ArrayList<String> listaAux1 = new ArrayList<String>();
			ArrayList<String> listaAux2 = new ArrayList<String>();

			// Copiar principal para a 2
			listaAux2.addAll(listaDePalavrasGeradas);

			for (int i = 0; i < qtdCaracteres - 1; i++) {

				// Concatenar param com aux e colocar na aux 1
				for (String parametro : param) {
					for (String string : listaAux2) {
						listaAux1.add(parametro + string);
					}
				}

				// Copiar lista aux 1 para o fim da principal
				for (String string : listaAux1) {
					listaDePalavrasGeradas.add(string);
				}

				// Apagar lista aux 2
				listaAux2.clear();

				// Copiar aux 1 para aux 2
				listaAux2.addAll(listaAux1);

				// Apagar lista aux 1
				listaAux1.clear();

			}
		}

		return listaDePalavrasGeradas;
	}

	/**
	 * TODO arquivo
	 * @return
	 */
	public static boolean criarArquivoComPalavrasPossiveis(String caminho) {
		
		//validar string caminho 

		//Verificar se já existe um arquivo com esse mesmo nome
		
		//new PrintWriter(new FileWriter("C:\\Users\\mrgab\\Google Drive\\5-Formais\\teste.txt")).printf("conteudo").close();
		
		//tratar siatuação da palavra vazia
		
		//nome do arquivo qual é?
		
		
		
		return true;
	}

	/**
	 * Verifica (uma a uma) se todas as palavras aceitas pela expressão são também
	 * aceitas pelo automato e vice-versa.
	 * 
	 * @return
	 */
	public boolean todasAsPalavrasSaoAceitasPelaExpressaoEPeloAutomato() {

		boolean palavraExistaNaOutraLista = true;

		while (palavraExistaNaOutraLista) {

			for (String string : listaPalavrasAceitasAutomato) {
				palavraExistaNaOutraLista = listaPalavrasAceitasExpressao.contains(string);
			}

			for (String string : listaPalavrasAceitasExpressao) {
				palavraExistaNaOutraLista = listaPalavrasAceitasAutomato.contains(string);
			}

			if (palavraExistaNaOutraLista)
				break;

		}

		return palavraExistaNaOutraLista;
	}

}