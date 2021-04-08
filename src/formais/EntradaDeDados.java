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

	private String tipoResultado = "  Result: Accept ";

	private List<String> listaPalavrasLidasExpressao = new ArrayList<>();
	private List<String> listaPalavrasAceitasExpressao = new ArrayList<>();

	private List<String> listaPalavrasResultadoAutomato = new ArrayList<>();
	private List<String> listaPalavrasAceitasAutomato = new ArrayList<>();

	/**
	 * @param expressaoRegular
	 * @param nomeArquivoAutomato     deve ser informado no formato "automato1.jff"
	 *                                (com a extensão)
	 * @param caminhoBase             deve ser informado no formato "C:\\Users\\"
	 * @param nomeArquivoEntradaDados deve ser informado no formato
	 *                                "entradas_ab.txt"
	 */
	public EntradaDeDados(String expressaoRegular, String caminhoBase, String nomeArquivoEntradaDados,
			String nomeArquivoAutomato, String nomeArquivoResultadoAutomato) {

		this.expressaoRegular = expressaoRegular;

		this.caminhoBase = caminhoBase;
		this.nomeArquivoEntradaDados = caminhoBase + nomeArquivoEntradaDados;
		this.nomeArquivoAutomato = nomeArquivoAutomato;
		this.nomeArquivoResultadoAutomato = caminhoBase + "results" + nomeArquivoAutomato + ".txt";
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
	public void setListaPalavrasLidasExpressao(List<String> listaPalavrasLida) {
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
	public void setListaPalavrasAceitas(List<String> listaPalavrasAceitas) {
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
	public void setListaPalavrasResultadoAutomato(List<String> listaPalavrasResultado) {
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
	public void setListaPalavrasAceitasAutomato(List<String> listaPalavrasAceitasAutomato) {
		this.listaPalavrasAceitasAutomato = listaPalavrasAceitasAutomato;
	}

	public void lerResultadosDoAutomato() {

		List<String> linhas = new ArrayList<>();

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

		List<String> linhas = new ArrayList<>();

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

	}

	/**
	 * TODO Falta implementar
	 * 
	 * 
	 */
	public void gerarArquivoComPalavras(String... param) {

		if (param != null) {

		}

	}
}