package com.exercicis;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Locale;

public class Exercici0014 {

    public static String getMovePC() {
        String[] accions = { "PEDRA", "PAPER", "TISORES" };
        return accions[new Random().nextInt(accions.length)];
    }

    public static String getPlayerMove(Scanner scanner) {
        while (true) {
            System.out.print("Escriu PEDRA, PAPER, TISORES o SORTIR: ");
            String accions = scanner.nextLine().toUpperCase();

            if (accions.equals("SORTIR"))
                return null;
            else if (accions.equals("PEDRA") || accions.equals("PAPER") || accions.equals("TISORES")) {
                return accions;
            }
        }
    }

    public static String getWinner(String playerMove, String pcMove) {
        if (playerMove.equals(pcMove))
            return "DRAW";

        switch (playerMove) {
            case "PEDRA":
                return pcMove.equals("TISORES") ? "PLAYER" : "PC";
            case "PAPER":
                return pcMove.equals("PEDRA") ? "PLAYER" : "PC";
            case "TISORES":
                return pcMove.equals("PAPER") ? "PLAYER" : "PC";
            default:
                return "ERROR";
        }
    }

    public static String getScoreMessage(int playerScore, int pcScore) {
        return String.format("Marcador -> JUGADOR: %d - PC: %d", playerScore, pcScore);
    }

    public static String getWinnerMessage(boolean playerWon) {
        return playerWon ? "Felicitats! Has guanyat la partida!" : "Ho sento! Ha guanyat el PC!";
    }

    public static void updateStats(HashMap<String, Integer> stats, String move, boolean win) {
        String cMov = move + "_COUNT";
        stats.put(cMov, stats.get(cMov) + 1);

        if (win) {
            String cWin = move + "_WINS";
            stats.put(cWin, stats.get(cWin) + 1);
        }
    }

    public static String getMessage(String winner, String playerMove, String pcMove) {
        switch (winner) {
            case "DRAW":
                return "Empat! Els dos heu triat " + playerMove + "!";
            case "PLAYER":
                return "Has guanyat! Has triat " + playerMove + " guanya a " + pcMove + "!";
            default:
                return "Ho sento! " + pcMove + " guanya a " + playerMove + "!";
        }
    }

    public static void showStats(HashMap<String, Integer> stats) {
        int totalGames = stats.get("PEDRA_COUNT") + stats.get("PAPER_COUNT") + stats.get("TISORES_COUNT");
        int totalWins = stats.get("PEDRA_WINS") + stats.get("PAPER_WINS") + stats.get("TISORES_WINS");

        String mostUsedMove = "PEDRA";
        int maxCount = stats.get("PEDRA_COUNT");

        if (stats.get("PAPER_COUNT") > maxCount) {
            mostUsedMove = "PAPER";
            maxCount = stats.get("PAPER_COUNT");
        }
        if (stats.get("TISORES_COUNT") > maxCount) {
            mostUsedMove = "TISORES";
            maxCount = stats.get("TISORES_COUNT");
        }

        String bestMove = "PEDRA";
        double bestWinRate = stats.get("PEDRA_COUNT") > 0
                ? (double) stats.get("PEDRA_WINS") / stats.get("PEDRA_COUNT") * 100
                : 0;

        double paperWinRate = stats.get("PAPER_COUNT") > 0
                ? (double) stats.get("PAPER_WINS") / stats.get("PAPER_COUNT") * 100
                : 0;
        if (paperWinRate > bestWinRate) {
            bestMove = "PAPER";
            bestWinRate = paperWinRate;
        }

        double tisoresWinRate = stats.get("TISORES_COUNT") > 0
                ? (double) stats.get("TISORES_WINS") / stats.get("TISORES_COUNT") * 100
                : 0;
        if (tisoresWinRate > bestWinRate) {
            bestMove = "TISORES";
            bestWinRate = tisoresWinRate;
        }

        System.out.println("Estadístiques finals:");
        System.out.println("------------------");
        System.out.println("Total partides: " + totalGames);
        System.out.printf(Locale.US, "Victòries: %.1f%%\n",
                totalGames > 0 ? (double) totalWins / totalGames * 100 : 0);
        System.out.println("Moviment més utilitzat: " + mostUsedMove + " (" + maxCount + " vegades)");
        System.out.printf(Locale.US, "Moviment més victoriós: %s (%d%% victòries)\n",
                bestMove, Math.round(bestWinRate));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            HashMap<String, Integer> stats = new HashMap<>();
            stats.put("PEDRA_COUNT", 0);
            stats.put("PAPER_COUNT", 0);
            stats.put("TISORES_COUNT", 0);
            stats.put("PEDRA_WINS", 0);
            stats.put("PAPER_WINS", 0);
            stats.put("TISORES_WINS", 0);

            int playerScore = 0;
            int pcScore = 0;

            System.out.println("Benvingut a Pedra, Paper, Tisores!");
            System.out.println("El primer en arribar a 3 victòries guanya!\n");

            while (playerScore < 3 && pcScore < 3) {
                String playerMove = getPlayerMove(scanner);
                if (playerMove == null)
                    break;

                String pcMove = getMovePC();
                System.out.println("PC tria: " + pcMove);

                String winner = getWinner(playerMove, pcMove);
                System.out.println(getMessage(winner, playerMove, pcMove));

                if (winner.equals("PLAYER"))
                    playerScore++;
                else if (winner.equals("PC"))
                    pcScore++;

                System.out.println(getScoreMessage(playerScore, pcScore));
                System.out.println();

                updateStats(stats, playerMove, winner.equals("PLAYER"));
            }

            if (playerScore >= 3 || pcScore >= 3) {
                System.out.println(getWinnerMessage(playerScore >= 3));
                System.out.println();
            }

            showStats(stats);
        } finally {
            scanner.close();
        }
    }
}