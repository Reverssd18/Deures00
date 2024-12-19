package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exercici0011 {

    public static ArrayList<String> escullNomsAleatoris(ArrayList<String> noms, int quantitat) {
        
        if (quantitat > noms.size()) {
            throw new IllegalArgumentException("La quantitat no pot ser més gran que " + noms.size() + ".");
        }

        ArrayList<String> result = new ArrayList<>();
        Random random = new Random();
        
        ArrayList<String> aux = new ArrayList<>(noms); // Evitar duplicats
        for (int i = 0; i < quantitat; i++) {
            if (aux.isEmpty()) break;
            int index = random.nextInt(aux.size());
            result.add(aux.remove(index));
        }
        return result;
    }
   
    public static ArrayList<String> nomsAcabenVocal(ArrayList<String> noms) {
        ArrayList<String> result = new ArrayList<>();
        for (String nom : noms) {
            char index = nom.toLowerCase().charAt(nom.length()-1);
            if ("aeiou".indexOf(index) >= 0) {
                result.add(nom);
            }
        }
        
        return result;
    }

    public static ArrayList<String> nomsCompostos(ArrayList<String> noms) {
        ArrayList<String> result = new ArrayList<>();
        for (String nom : noms) {
            if (nom.contains(" ")) {
                result.add(nom);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"
        ));

       
        ArrayList<String> randnoms = escullNomsAleatoris(noms, 5);
        System.out.println("Noms escollits a l'atzar: " + randnoms );
        
        try {
            ArrayList<String> seleccionatsError = escullNomsAleatoris(noms, 25);
            System.out.println("Noms escollits: " + seleccionatsError);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            
            ArrayList<String> nomsVocal = nomsAcabenVocal(noms);
            System.out.println("Noms que acaben amb vocal: " + nomsVocal);

            ArrayList<String> nomsCompostos = nomsCompostos(noms);
            System.out.println("Noms compostos: " + nomsCompostos);
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
