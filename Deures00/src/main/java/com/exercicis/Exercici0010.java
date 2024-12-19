package com.exercicis;

import java.util.ArrayList;
import java.util.Random;


public class Exercici0010 {

    public static ArrayList<Integer> generarNumerosAleatoris(int quantitat, int min, int max) {
        ArrayList<Integer>numsAleatoris = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < quantitat; i++ ) {
            numsAleatoris.add(random.nextInt((max-min) + 1) + min);
        }
        return numsAleatoris;
    }

    public static ArrayList<Integer> multiplicarPerDos(ArrayList<Integer> llista) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : llista) {
            result.add(num * 2);
        }
        return result;
    }

    public static ArrayList<Integer> filtrarImparells(ArrayList<Integer> llista) {
        ArrayList<Integer> imparells = new ArrayList<>();
        for (int imp : llista) {
            if (imp % 2 != 0) {
                imparells.add(imp);
            }
        }
        return imparells;
    }

    public static ArrayList<Double> dividirPerDos(ArrayList<Integer> llista) {
        ArrayList<Double> dividit = new ArrayList<>();
        for (double div : llista) {
            dividit.add(div / 2);
        }
        return dividit;
    }

    public static void main(String[] args) {
        ArrayList<Integer> llistaAleatoria = generarNumerosAleatoris(10, 0, 99);
        System.out.println("Llista inicial: " + llistaAleatoria);

        ArrayList<Integer> llistaMultiplicada = multiplicarPerDos(llistaAleatoria);
        System.out.println("Llista multiplicada per 2: " + llistaMultiplicada);

        ArrayList<Integer> llistaImparells = filtrarImparells(llistaAleatoria);
        System.out.println("Llista només amb números imparells: " + llistaImparells);

        ArrayList<Double> llistaDividida = dividirPerDos(llistaImparells);
        System.out.println("Llista imparells dividits per 2: " + llistaDividida);
    
    }
}
