package formais;

public class Formais {

	public static void main(String[] args) {

		EntradaDeDados dados = new EntradaDeDados("(a|b)*aa(a|b)*", "ex 1");

		dados.processar();
	}

}
