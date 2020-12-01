package obi_classification;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTestCadastrarInfo {

	CadastrarInfo dados;
	
	@BeforeEach
	void init() {
		 dados = new CadastrarInfo();
		 dados.setNumParticipantes(1);
		 dados.addPontuacao(55.0);
	}
	
	//condição do if falsa
	@Test
	void testA() {
		assertEquals(55.0, dados.getPontuacao(0));
	}
	
	//condição do if verdadeira
	@Test
	void testB() {
		assertEquals(-1.0, dados.getPontuacao(1));
	}
}
