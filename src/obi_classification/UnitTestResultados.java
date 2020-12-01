package obi_classification;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTestResultados {

	private CadastrarInfo dados;
	private int numClassif;
	
	// Caso de teste que passa por todas as arestas do grafo
	@Test
	void init() {
		CadastrarInfo dados = new CadastrarInfo();

		dados.setNumParticipantes(5);
		
		dados.setNumMinClassificados(2);
		
		for(int i = 0; i< dados.getNumParticipantes(); i++) {
			
			dados.addPontuacao(500.00);
		}
	
		
		Resultados result = new Resultados(dados);
		
		//result.printResult();
		
		assertEquals(1, result.getNumClassif());
		
		assertEquals(0.00, result.getDesvioPadraoC());
		
		assertEquals(5.00, result.getMediaC());
		
		assertEquals(0.00, result.getDesvioPadraoGeral());
		
		assertEquals(5.00, result.getMediaGeral());
	}

}
