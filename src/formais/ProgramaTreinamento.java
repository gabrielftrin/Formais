package formais;

import java.util.ArrayList;

public class ProgramaTreinamento {

	public static void main(String[] args) {

		ArrayList<String> lista1 = new ArrayList<String>();

		ArrayList<String> lista2 = new ArrayList<String>();

		lista1.add("joao");
		lista1.add("pedro");

		lista2.add("pedro");
		lista2.add("joao");

		System.out.println(lista1.equals(lista2));

	}

}