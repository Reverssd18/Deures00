package com.exercicis;

import java.util.Locale;

public class Exercici0007 {

    public static double calculaCostLloc(String tipusLloc) {
        
        return switch (tipusLloc.toLowerCase()) {
            case "sala estàndard" -> 100.0;
            case "jardí amb piscina" -> 200.0;
            case "saló gran amb escenari" -> 500.0;
            default -> throw new IllegalArgumentException("Tipus de lloc desconegut: "+ tipusLloc);
        };
    } 

    public static double calculaCostMenjar(String tipusMenjar, int numConvidats) {
        double preuperconvidat = switch (tipusMenjar.toLowerCase()) {
            case "menú bàsic" -> 15.0;
            case "menú premium" -> 30.0;
            default -> throw new IllegalArgumentException("Tipus de menú desconegut: "+ tipusMenjar);
        };
        double totmenjar = preuperconvidat * numConvidats;
        
        if (numConvidats > 50) {
            totmenjar *= 0.95;
        }
        
        return totmenjar;
    }

    public static double calculaCostEntreteniment(String tipusEntreteniment) {
        double resultat = 0.0;
        switch (tipusEntreteniment.toLowerCase()) {
            case "màgia" : 
                resultat = 250.0;
                break;
            case "música en directe": 
                resultat = 500.0;
                break;
            case "cap":
                resultat = 0.0;
                break; 
            default:
                throw new IllegalArgumentException("Tipus d'entreteniment desconegut: "+ tipusEntreteniment);                
        }

        return resultat;
    }

    public static double calculaFesta(String tipusLloc, String tipusMenjar, String tipusEntreteniment, int numConvidats) {
        double preulloc = calculaCostLloc(tipusLloc);
        double preumenjar = calculaCostMenjar(tipusMenjar, numConvidats);
        double preuentre = calculaCostEntreteniment(tipusEntreteniment);
        
        if (tipusLloc.equals("saló gran amb escenari") && tipusEntreteniment.equals("música en directe")) {
            preuentre -= 100.0;
        }
        
        return preulloc + preumenjar + preuentre;
    }

    public static void main(String[] args) {
        String template = "%-75s%.2f€";

        System.out.println(String.format(Locale.US, template, "Cas 1 (\"sala estàndard\", \"menú bàsic\", \"cap\", 20):", calculaFesta("sala estàndard", "menú bàsic", "cap", 20)));
        System.out.println(String.format(Locale.US, template, "Cas 2 (\"jardí amb piscina\", \"menú premium\", \"màgia\", 60):", calculaFesta("jardí amb piscina", "menú premium", "màgia", 60)));
        System.out.println(String.format(Locale.US, template, "Cas 3 (\"jardí amb piscina\", \"menú bàsic\", \"música en directe\", 40):", calculaFesta("jardí amb piscina", "menú bàsic", "música en directe", 40)));
        System.out.println(String.format(Locale.US, template, "Cas 4 (\"saló gran amb escenari\", \"menú premium\", \"música en directe\", 70):", calculaFesta("saló gran amb escenari", "menú premium", "música en directe", 70)));
        System.out.println(String.format(Locale.US, template, "Cas 5 (\"sala estàndard\", \"menú premium\", \"màgia\", 15):", calculaFesta("sala estàndard", "menú premium", "màgia", 15)));
   
    }
}
