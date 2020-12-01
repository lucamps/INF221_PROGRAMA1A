package obi_classification;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTestMain {
	
	CadastrarInfo dados;
	
	@BeforeEach
	void init() {
		 dados = new CadastrarInfo();
	}
	
	//Caso em que a primeira condição do for não é válida desde a primeira verificação
	@Test
	void testA() {
		dados.setNumParticipantes(0);
		dados.setNumMinClassificados(2);
		
		// Se isso ocorrer, numParticipantes = 0 e obtemos uma exceção 
		// por acessar uma posição inválida do array
		assertThrows(IndexOutOfBoundsException.class, () -> {
			for(int i = 0; i< dados.getNumParticipantes(); i++) {
				dados.addPontuacao(500.00);
			}
			Resultados result = new Resultados(dados);
			result.printResult();
		});	
	}
	
	// Caso em que o programa passa pelo for 1 vez
	@Test
	void testB() {
		dados.setNumParticipantes(1);
		dados.setNumMinClassificados(1);

		for(int i = 0; i< dados.getNumParticipantes(); i++) {
			dados.addPontuacao(5.0);
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
