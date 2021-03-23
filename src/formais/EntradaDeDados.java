package formais;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EntradaDeDados {

	private String expressaoRegular;

	private String nomeArquivoEntradaDados = "entradas_ab.txt";
	private String nomeArquivoAutomato;

	private String nomeArquivoResultadoAutomato = "results" + nomeArquivoAutomato + ".jff.txt";
	private String tipoResultado = " Accept";

	/**
	 * 
	 */
	public EntradaDeDados() {

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

	public List<String> ColetarLinhasDeUmArquivo(String caminhoArquivo) {

		List<String> linhas = new ArrayList<>();

		try {
			Scanner sc = new Scanner(new File(caminhoArquivo));
			while (sc.hasNext()) {
				linhas.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return linhas;
	}

}
