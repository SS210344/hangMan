package com.company;
import java.util.Scanner;
import java.util.Random;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        String[] words = {"kill","even","frog","claim","story","cable","rings","snow","true","race"};
        Random RandNum = new Random();
        String randWord = words[RandNum.nextInt(10)];
        System.out.println(randWord);

        randWord = randWord.toUpperCase();
        String word1 = randWord.replaceAll("[A-Z]", "_ ");

        System.out.println("    Welcome to HANGMAN GAME    ");
        System.out.println("let's play the game");

        int guess_ = 0;
        int wrong = 0;
        String guess;
        char letter;

        boolean guessesContainsGuess;
        String guesses = "";
        boolean guessInWord;

        while (wrong < 5 && word1.contains("_")){
            System.out.println(word1 + "\n");
            int temp = 5 - wrong;
            if(wrong != 0){
                System.out.println("You have "+temp+" guesses left.");
            }
            System.out.println("Your guess:");
            guess = input.nextLine();
            guess = guess.toUpperCase();
            letter = guess.charAt(0);
            guessesContainsGuess= (guesses.indexOf(letter)) != -1;
            guesses += letter;
            letter = Character.toUpperCase(letter);

            if (guessesContainsGuess){
                System.out.println("You ALREADY guessed "+ letter +".\n");
            }

            guessInWord= (randWord.indexOf(letter)) != -1;
            if (guessInWord){
                System.out.println(letter+"is present in the word.");

                for (int position = 0; position < randWord.length(); position++) {
                    if (randWord.charAt(position) == letter && word1.charAt(position) != letter) {
                        word1 = word1.replaceAll("_ ", "_");
                        String word2 = word1.substring(0, position) + letter + word1.substring(position + 1);
                        word2 = word2.replaceAll("_", "_ ");
                        word1 = word2;
                    }
                }
            }
            else {
                System.out.println(letter + " is not present in the word");
                wrong++;
            }

            guess_++;

        }
        if (wrong == 5){
            System.out.println("You LOST!, maximum limit of incorrect guesses reached.");

        }
        else{
            System.out.println("the word is: "+word1+"\n Well played, you did it!");
        }
    }
}
