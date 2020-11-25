package obi_classification;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CadastrarInfo dados = new CadastrarInfo();
		Scanner sc = new Scanner (System.in);

		dados.setNumParticipantes(sc.nextInt());
		dados.setNumMinClassificados(sc.nextInt());
		
		for(int i = 0; i< dados.getNumParticipantes(); i++) {
			dados.pontos.add(sc.nextDouble());
		}
		
		sc.close();
		
		Resultados result = new Resultados(dados);
		
		result.printResult();
		
		
	}
	

}
