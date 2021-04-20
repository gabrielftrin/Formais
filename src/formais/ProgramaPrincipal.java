package formais;

public class ProgramaPrincipal {

	public static void imprimir(Object object) {
		System.out.println(object);
	}

	public static void imprimirNaLinha(Object object) {
		System.out.print(object);
	}

	public static void main(String[] args) throws Exception {

//		imprimir(
//				Automato.calcularQtdEstadosVariosEstadosFinaisQtdsDiferentes(0, 0, 1).getQuantidadeEstados()
//			);		
		
		System.out.println(Automato.calcularQtdEstadosVariosEstadosFinaisQtdsDiferentes(1, 3, 3).getQuantidadeEstados());
		
	}
}
