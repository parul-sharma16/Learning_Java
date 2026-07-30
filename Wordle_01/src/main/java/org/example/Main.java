package org.example;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.*;

public class Main {
    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();

    private HashSet<String> validWords;

    private static final int lenWord = 5;
    private static final int numAttempts = 6;
    private static final String rightLetter = "🟩";
    private static final String wrongLetter = "🟥";
    private static final String rightPlace = "🟨";

    HashMap<Character, Integer> buildFreqMap(String ans) {
        HashMap<Character, Integer> freqAns = new HashMap<>();
        for (int j = 0; j < lenWord; j++) {
            char c = ans.charAt(j);
            freqAns.put(c, freqAns.getOrDefault(c, 0) + 1);
        }
        return freqAns;
    }

    boolean isValidGuess(String guess) {
        if (guess.length() != lenWord) {
            System.out.println("Word must be " + lenWord + " letters");
            return false;
        } else if (!validWords.contains(guess)) {
            System.out.println("Invalid word!");
            return false;
        }
        return true;
    }

    String[] evaluateGuess(String guess, String ans) {
        String[] result = new String[lenWord];
        HashMap<Character, Integer> freqAns = buildFreqMap(ans);

        for (int j = 0; j < lenWord; j++) {
            char guessChar = guess.charAt(j);
            char ansCharacter = ans.charAt(j);

            if (guessChar == ansCharacter) {
                result[j] = rightLetter;
                freqAns.put(guessChar, freqAns.getOrDefault(guessChar, 0) - 1);
            }
        }
        for (int j = 0; j < lenWord; j++) {
            char guessChar = guess.charAt(j);
            if (result[j] != null) continue;
            if (ans.indexOf(guessChar) != -1 && freqAns.getOrDefault(guessChar, 0) > 0) {
                result[j] = rightPlace;
                freqAns.put(guessChar, freqAns.getOrDefault(guessChar, 0) - 1);
            } else result[j] = wrongLetter;
        }
        return result;
    }

    void playGame() {
        ObjectMapper om = new ObjectMapper();
        List<String> answers = om.readValue(getClass().getResourceAsStream("/wordle_ans.json"), new TypeReference<>() {
        });
        List<String> notAnswers = om.readValue(getClass().getResourceAsStream("/allowed.json"), new TypeReference<>() {
        });
        validWords = new HashSet<>(answers);
        validWords.addAll(notAnswers);

        String ans = answers.get(random.nextInt(answers.size())).toLowerCase();

        for (int attempt = 1; attempt <= numAttempts; attempt++) {
            System.out.println("Attempt " + attempt + "/" + numAttempts);
            System.out.println("Enter your word: ");

            String guess = sc.next().toLowerCase();

            if (!isValidGuess(guess)) {
                attempt--;
                continue;
            }
            if (guess.equals(ans)) {
                System.out.println("Correct Answer!");
                return;
            }
            for (int j = 0; j < lenWord; j++) System.out.print(guess.charAt(j) + " ");
            System.out.println();
            String[] result = evaluateGuess(guess, ans);
            for (String s : result) System.out.print(s);
            System.out.println("\n");
        }
        System.out.println("Correct word: " + ans);
    }

    void main() {
        playGame();
    }
}