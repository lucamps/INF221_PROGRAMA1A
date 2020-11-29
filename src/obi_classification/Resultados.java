package obi_classification;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class Resultados {
	private CadastrarInfo dados;
	private int numClassif;
	
	// Construtor
	public Resultados(CadastrarInfo dados) {
		this.dados = dados;
		calculaNumClassif();
	}
	
	// Calcula o número de classificados (chamado apenas no construtor)
	public void calculaNumClassif() {
		numClassif = dados.getNumMinClassificados();
		dados.ordenarLista();
		
		Double base = dados.getPontuacao(numClassif-1);
		
		while(dados.getPontuacao(numClassif).equals(base)) 
			numClassif++;
	}
	// Gets & Sets
	public int getNumClassif() {
		return numClassif;
	}
	public void setNumClassif(int numClassif) {
		this.numClassif = numClassif;
	}
	// Calcula e retorna a média geral
	public Double getMediaGeral() {
		Double soma = 0.0;
		
		for(Double i : dados.pontos)
			soma += i;
		return soma/dados.pontos.size();
	}
	// Calcula e retorna a média dos classificados
	public Double getMediaC() {
		Double soma = 0.0;
		for(int i =0; i< numClassif; i++)
			soma += dados.pontos.get(i);
		return soma/numClassif;
	}
	// Calcula e retorna o desvio padrão geral
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
	// Calcula e retorna o desvio padrão dos classificados
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
	// Imprime o resultado no formato pedido
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