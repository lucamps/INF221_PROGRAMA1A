package obi_classification;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
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
		
		Resultados result = new Resultados();
		result.setDados(dados);
		
		int numC = result.getNumClassificados();
		
		//Formatando saida
		Locale locale  = new Locale("en", "US");
		DecimalFormat df = (DecimalFormat)
		        NumberFormat.getNumberInstance(locale);
		df.applyPattern("#0.00");
		
		//Imprimindo resultados
		System.out.println(numC);
		System.out.println(df.format(result.getDesvioPadraoC(numC)));
		System.out.println(df.format(result.getMediaC(numC)));
		System.out.println(df.format(result.getDesvioPadraoGeral()));
		System.out.println(df.format(result.getMediaGeral()));
		
		sc.close();
	}
	

}
