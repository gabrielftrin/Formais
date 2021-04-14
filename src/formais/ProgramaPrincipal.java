package formais;

public class ProgramaPrincipal {

	public static void imprimir(Object object) {
		System.out.println(object);
	}

	public static void imprimirNaLinha(Object object) {
		System.out.print(object);
	}

	public static void main(String[] args) throws Exception {

//		System.out.println(Automato.calcularQtdEstadosUmEstadoFinalQtdsIguais(5).getQuantidadeEstados());

//		for (int i = 0; i < 10; i++) {
//			imprimirNaLinha(Automato.calcularQtdEstadosVariosEstadosFinaisQtdsIguais(i).getQuantidadeEstados() + " ");
//		}
//		imprimir("");
//
//		for (int i = 0; i < 10; i++) {
//			imprimirNaLinha(i + " ");
//		}

		imprimir(Automato.calcularQtdEstadosVariosEstadosFinaisQtdsDiferentes(3, 3, 5).getQuantidadeEstados());
	}
}
