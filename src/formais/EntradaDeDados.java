package formais;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntradaDeDados {

	private String expressaoRegular;

	private String caminhoBase = "C:\\Users\\mrgab\\Google Drive\\5-Formais\\";
	private String nomeArquivoEntradaDados = caminhoBase.concat("entradas_ab.txt");
	private String nomeArquivoAutomato;

	private String nomeArquivoResultadoAutomato;

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
	}

	private String tipoResultado = " Accept";

	private List<String> listaPalavrasAceitasExpressao = new ArrayList<>();
	private List<String> listaPalavrasLidasExpressao = new ArrayList<>();
	private List<String> listaPalavrasResultadoAutomato = new ArrayList<>();
	private List<String> listaPalavrasAceitasAutomato = new ArrayList<>();

	/**
	 * @param expressaoRegular
	 * @param nomeArquivoAutomato
	 */
	public EntradaDeDados(String expressaoRegular, String nomeArquivoAutomato, String caminhoBase) {
		this.expressaoRegular = expressaoRegular;
		this.nomeArquivoAutomato = caminhoBase + nomeArquivoAutomato;
		this.caminhoBase = caminhoBase;
		this.nomeArquivoResultadoAutomato = caminhoBase + "results" + nomeArquivoAutomato + ".jff.txt";
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
	 * @return the nomeArquivoEntradaDados
	 */
	public String getNomeArquivoEntradaDados() {
		return nomeArquivoEntradaDados;
	}

	/**
	 * @param nomeArquivoEntradaDados the nomeArquivoEntradaDados to set
	 */
	public void setNomeArquivoEntradaDados(String nomeArquivoEntradaDados) {
		this.nomeArquivoEntradaDados = nomeArquivoEntradaDados;
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
	 */
	public void setNomeArquivoResultadoAutomato(String nomeArquivoResultadoAutomato) {
		this.nomeArquivoResultadoAutomato = nomeArquivoResultadoAutomato;
	}

	/**
	 * @return the tipoResultado
	 */
	public String getTipoResultado() {
		return tipoResultado;
	}

	/**
	 * @param tipoResultado the tipoResultado to set
	 */
	public void setTipoResultado(String tipoResultado) {
		this.tipoResultado = tipoResultado;
	}

	public void imprimir(Object object) {
		System.out.println(object);
	}

	public void imprimirNaLinha(Object object) {
		System.out.print(object);

	}

	public void lerResultados() {

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

	public void lerEntradas() {

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
	 * @return the listaPalavrasLida
	 */
	public List<String> getListaPalavrasLidasExpressao() {
		return listaPalavrasLidasExpressao;
	}

	/**
	 * @param listaPalavrasLida the listaPalavrasLida to set
	 */
	public void setListaPalavrasLidas(List<String> listaPalavrasLida) {
		this.listaPalavrasLidasExpressao = listaPalavrasLida;
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
	public void setListaPalavrasResultado(List<String> listaPalavrasResultado) {
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

}
