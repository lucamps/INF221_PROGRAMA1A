package obi_classification;

import java.util.ArrayList;
import java.util.Collections;

public class CadastrarInfo {
	private int numParticipantes;
	private int numMinClassificados;
	public ArrayList<Double> pontos;
	
	public void ordenarLista() {
		Collections.sort(pontos, Collections.reverseOrder());
	}
	public CadastrarInfo() {
		numParticipantes = 0;
		numMinClassificados = 0;
		pontos = new ArrayList<Double>();
	}
	public int getNumMinClassificados() {
		return numMinClassificados;
	}
	public void setNumMinClassificados(int numMinClassificados) {
		this.numMinClassificados = numMinClassificados;
	}
	public int getNumParticipantes() {
		return numParticipantes;
	}
	public void setNumParticipantes(int numParticipantes) {
		this.numParticipantes = numParticipantes;
	}
}
