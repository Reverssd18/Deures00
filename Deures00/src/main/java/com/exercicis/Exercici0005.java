package com.exercicis;


public class Exercici0005 {

    public static boolean isPalindrom(String text) {
        text = normalize(text);

        int ultLletra = text.length() - 1;
        String invertit = "";
        for (int cnt = ultLletra; cnt >= 0;cnt = cnt--) {
            String lletra = String.valueOf(text.charAt(cnt));
            invertit = invertit + lletra;
        } 
        
        return text.equalsIgnoreCase(invertit);
    }

    public static String normalize(String text) {
        String min = text.toLowerCase();

        String[] acc = {"à", "á", "è", "é", "í", "ò", "ó", "ú", "ü", " ", "'", "!", "\\.", ",", "·"};
        String[] noAcc = {"a", "a", "e", "e", "i", "o", "o", "u", "u", "", "", "", "", "", ""};

        for (int cnt = 0; cnt < acc.length; cnt++) {
            min = min.replaceAll(acc[cnt], noAcc[cnt]); 
        }
        return min;
    }
   
    public static void main(String[] args) {
        String[] exemples = {
            "Anul·la la lluna",
            "Atrapa la lluna",
            "Atrapa'l o l'aparta",
            "Aparta'l o atrapa'l",
            "No sap pas on",
            "On sap pas qui",
            "Tramaran anar a Mart",
            "A Mart trobaràn art",
            "Un pop nu",
            "Nu pop un"
        };

        // Comprovar cada text
        for (String text : exemples) {
            boolean esPalindrom = isPalindrom(text);
            System.out.println(text + " (" + (esPalindrom ? "Si" : "No") + ")");
        }
    }
}
