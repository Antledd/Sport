package it.polito.tdp.toto;

import java.util.ArrayList;
import java.util.List;

public class Espandi {
	
	private List<Schedina> soluzioni;
	
	public List<Schedina> espandiPronostico(Pronostico p) {
		Schedina parziale = new Schedina(p.getN());
		this.soluzioni = new ArrayList<Schedina>();
		
		espandi(p, parziale, 0);
		
		return this.soluzioni;
	}
	
	//Livello della ricorsione = singola partita
	//livello =0 -> scedina con 0 risultati
	//livello = 1 -> scedina con 1 risultato...
	//ecc. ecc....
	
	//private List<Schedina> soluzione;
/*	
	public List<Schedina> expand(Pronostico p){
		
		soluzione = new ArrayList<Schedina>();	
		//caso iniziale
		cerca(new Schedina(p.getN()), p, 0); //p=unacopiadi pronostico; 0 partite
		
		return soluzione;
	}
*/	
	private void espandi(Pronostico p, Schedina parziale, int livello) {
		
		// parziale contiene già (livello) valori
		// nelle posizioni 0... livello-1
		// Io devo determinare parziale[livello]
		//  (cioè la livello+1 esima riga
		// sulla base dellaprevisione in p[livello]

		
		if(livello == p.getN()) {
//			System.out.println(parziale);
			this.soluzioni.add(new Schedina(parziale));
			return;
		}
		
		
		Previsione prev = p.get(livello);
		
		//prova le varie alternative
		for(Risultato r : prev.getValori()) {
			// provo ad aggiungere 'r'
			parziale.add(r); 	
			
			espandi(p, parziale, livello+1);
			
			//backtrack (togliere)
			parziale.removeLast();
		}
	}

	/*
	private void cerca(Schedina parziale, Pronostico p, int livello) {
			if(livello == p.getN()) {
			//caso terminale => ho una soluzione completa
			soluzione.add(new Schedina(parziale));
			return;
		}
		
		//caso intermedio
		Previsione mosse = p.get(livello);
		for(Risultato mossa : mosse.getValori()) {
			parziale.add(mossa); // prova la soluzione
			cerca(parziale, p, livello+1);
			parziale.removeLast(); // backtrack (rimettere le cose a posto)
			
		}
		
	}
*/	
	
	/*
	 Problema parziale: Schedina 1-X, livello 2
	 Devo guardare pronostico p(2). Supponiamo sia X2
	 Allora genererò le nuove soluzioni parziali 1-X-X, 1-X-2
	 */
	
	
}
