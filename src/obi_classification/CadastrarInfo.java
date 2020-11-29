package obi_classification;
import java.util.ArrayList;
import java.util.Collections;

public class CadastrarInfo {
	private int numParticipantes;
	private int numMinClassificados;
	protected ArrayList<Double> pontos;
	
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
	public void setListPontos(ArrayList<Double> pontos) {
		this.pontos = pontos;
	}
	public ArrayList<Double> getListPontos(){
		return pontos;
	}
	public void ordenarLista() {
		Collections.sort(pontos, Collections.reverseOrder());
	}
	public CadastrarInfo() {
		numParticipantes = 0;
		numMinClassificados = 0;
		pontos = new ArrayList<Double>();
	}
	public void addPontuacao(Double num) {
		pontos.add(num);
	}
	public Double getPontuacao(int pos) {
		if(pos >= numParticipantes)
			return -1.0;
		return pontos.get(pos);
	}
	
}