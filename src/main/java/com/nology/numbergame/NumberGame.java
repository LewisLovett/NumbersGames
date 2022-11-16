package com.nology.numbergame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    public void play(){
        Random rand = new Random();
        int randNum = rand.nextInt(99) + 1;

        boolean isNumFound = false;
        int userInput;
        String checkResponse;
        int numOfGuesses = 0;
        ArrayList<Integer> guesses = new ArrayList<>();
        while (!isNumFound) {
            System.out.println("Guess the number between 1 and 100");

            Scanner scanObj = new Scanner(System.in);
            userInput = scanObj.nextInt();


                if (!guesses.contains(userInput)) {
                    guesses.add(userInput);
                    numOfGuesses++;
                    checkResponse = checkInput(userInput, randNum);
                    System.out.println(checkResponse);
                    if (checkResponse.equals("You Won") ) {
                        isNumFound = true;
                        System.out.println("Number of Guesses:" + numOfGuesses);
                    } else if (numOfGuesses == 10) {
                        isNumFound = true;
                        System.out.println("You have used up your 10 guesses");
                    }
                } else {
                    System.out.println("You have already guessed " + userInput);
                }
//            }else{
//                System.out.println("That is not a number");
//            }
        }

    }
    private String checkInput(int input, int randNum){
        int distanceFromAnswer = Math.abs(randNum - input);
        String response = "No where near..";
        if(distanceFromAnswer == 0){
            response = "You Won";
        } else if (distanceFromAnswer <= 3) {
            response = "Very very warm";
        }else if (distanceFromAnswer <= 6) {
            response = "Very warm";
        }else if (distanceFromAnswer <= 10) {
            response = "Warm";
        }else if (distanceFromAnswer <= 16) {
            response = "Cold";
        }else if (distanceFromAnswer <= 21) {
            response = "Very cold";
        }else if (distanceFromAnswer <= 25) {
            response = "Freezing";
        }else if (distanceFromAnswer <= 30) {
            response = "Artic";
        }
        return response;
    }

}
