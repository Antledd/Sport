package it.polito.tdp.toto;

import java.util.List;

public class TestPronostico {
	
	public static void main(String[] args) {
		Pronostico p = new Pronostico(5); // 5 indica una schedina da 3 (invece di 13)
		p.add(new Previsione(Risultato.DUE, Risultato.UNO));
		p.add(new Previsione(Risultato.UNO, Risultato.ICS));
		p.add(new Previsione(Risultato.UNO, Risultato.ICS, Risultato.DUE ));
		p.add(new Previsione(Risultato.ICS));
		p.add(new Previsione(Risultato.UNO, Risultato.DUE));
		
		System.out.println("Problema posto:\n" + p);
		
		Espandi e = new Espandi();
		List<Schedina> soluzioni = e.espandiPronostico(p);
		//e.espandiPronostico(p);
		
		System.out.println("Soluzione trovata:\n" + soluzioni);
	
	}

}
