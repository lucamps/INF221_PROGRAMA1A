package obi_classification;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CadastrarInfo dados = new CadastrarInfo();
		Scanner sc = new Scanner (System.in);

		dados.setNumParticipantes(sc.nextInt());
		dados.setNumMinClassificados(sc.nextInt());
		
		for(int i = 0; i< dados.getNumParticipantes(); i++) {
			dados.addPontuacao(sc.nextDouble());
		}
		
		sc.close();
		
		if(dados.getNumParticipantes() > 0 && dados.getNumMinClassificados() >0) {
			Resultados result = new Resultados(dados);
			result.printResult();
		}
		else 
			System.out.println("0\n0.00\n0.00\n0.00\n0.00");
		
	}
	
}