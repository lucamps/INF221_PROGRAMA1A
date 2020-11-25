package obi_classification;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Resultados {
	private CadastrarInfo dados;
	
	Resultados(){
		dados = new CadastrarInfo();
	}
	void setDados(CadastrarInfo dados) {
		this.dados = dados;
	}
	
	public int getNumClassificados() {
		int classificados = dados.getNumMinClassificados();
		dados.ordenarLista();
		
		Double base = dados.pontos.get(classificados-1);
		
		while(dados.pontos.get(classificados-1) == base)
			classificados++;
		
		return classificados;
	}
	
	public Double getMediaGeral() {
		Double soma = 0.0;
		for(Double i : dados.pontos)
			soma += i;
		return soma/dados.pontos.size();
	}
	public Double getMediaC(int classificados) {
		Double soma = 0.0;
		for(int i =0; i< classificados; i++)
			soma += dados.pontos.get(i);
		return soma/classificados;
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
	public Double getDesvioPadraoC(int classificados) {
	    Double media = getMediaC(classificados);
	    int tam = classificados;
	    Double desvPadrao = 0.0;
	    Double aux;
	    for (int i =0; i< classificados; i++) {
	        aux = dados.pontos.get(i) - media;
	        desvPadrao += aux * aux;
	    }
	    desvPadrao = Math.sqrt(desvPadrao / (tam));
	    return desvPadrao;
	}
}
