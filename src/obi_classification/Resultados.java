package obi_classification;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Resultados {
	private CadastrarInfo dados;
	private int numClassif;
	
	// Construtor
	public Resultados(CadastrarInfo dados) {
		this.dados = dados;
		calculaNumClassif();
	}
	
	public void calculaNumClassif() {
		numClassif = dados.getNumMinClassificados();
		dados.ordenarLista();
		
		Double base = dados.pontos.get(numClassif-1);
		
		while(dados.pontos.get(numClassif-1) == base) {
			numClassif++;
		}
		
	}
	
	public Double getMediaGeral() {
		Double soma = 0.0;
		for(Double i : dados.pontos)
			soma += i;
		return soma/dados.pontos.size();
	}
	public Double getMediaC() {
		Double soma = 0.0;
		for(int i =0; i< numClassif; i++)
			soma += dados.pontos.get(i);
		return soma/numClassif;
	}
	public Double getDesvioPadraoGeral() {
	    Double media = getMediaGeral();
	    int tam = dados.pontos.size();
	    Double desvPadrao = 0.0;
	    Double aux;
	    for (Double i : dados.pontos) {
	        aux = i - media;
	        desvPadrao += aux * aux;
	    }
	    desvPadrao = Math.sqrt(desvPadrao / (tam));
	    return desvPadrao;
	}
	public Double getDesvioPadraoC() {
	    Double media = getMediaC();
	    int tam = numClassif;
	    Double desvPadrao = 0.0;
	    Double aux;
	    for (int i =0; i< numClassif; i++) {
	        aux = dados.pontos.get(i) - media;
	        desvPadrao += aux * aux;
	    }
	    desvPadrao = Math.sqrt(desvPadrao / (tam));
	    return desvPadrao;
	}
	public int getNumClassif() {
		return numClassif;
	}
	public void setNumClassif(int numClassif) {
		this.numClassif = numClassif;
	}
	
	public void printResult() {
		//Formatando saida
				Locale locale  = new Locale("en", "US");
				DecimalFormat df = (DecimalFormat)
				        NumberFormat.getNumberInstance(locale);
				df.applyPattern("#0.00");
				
				//Imprimindo resultados
				System.out.println(getNumClassif());
				System.out.println(df.format(getDesvioPadraoC()));
				System.out.println(df.format(getMediaC()));
				System.out.println(df.format(getDesvioPadraoGeral()));
				System.out.println(df.format(getMediaGeral()));
	}
}
