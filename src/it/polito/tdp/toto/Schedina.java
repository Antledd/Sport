package it.polito.tdp.toto;

import java.util.ArrayList;
import java.util.List;

public class Schedina {

	private int N;
	
	private List<Risultato> colonna;
	
	public Schedina(int N) {
		this.N= N;
		this.colonna = new ArrayList<Risultato>();
	}
	
	//clone constructor
	public Schedina(Schedina other) {
		this.N = other.N;
		this.colonna = new ArrayList<>(other.colonna);
	}
	
	public void add(Risultato valore) {
		if(colonna.size() < N) {
			colonna.add(valore);
		}else {
			throw new IllegalStateException("Too may elements in Schedina");
		}
	}
	
	public Risultato get(int partita) {
		return colonna.get(partita);
	}
	
	public void removeLast() {
		colonna.remove(colonna.size()-1);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Risultato r : colonna) {
			sb.append(r.toString());
			sb.append("-");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
}
