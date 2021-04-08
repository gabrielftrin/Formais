package formais;

public class ProgramaPrincipal {

	public static void imprimir(Object object) {
		System.out.println(object);
	}

	public static void imprimirNaLinha(Object object) {
		System.out.print(object);
	}

	public static void main(String[] args) {

		System.out.println(Automato.gerarAutomatoQtdIguais(0).getQuantidadeEstados());

	}
}
