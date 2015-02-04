/**
 * <h1> Game Main </h1>
 * This GameMain class is the starting class to play Guess A Number Game, 
 * where user can choose a number in his mind with in user provided range, 
 * and types <b>Ready</b> to play the game.
 * <p>
 * The application asks a series of questions until it guess number in user's mind. 
 * User can respond with answers as <b>higher</b>, <b>lower</b> or <b> yes </b>.
 * <p>
 * The Game ends when user responds with <b> yes</b> or <b> end </b>.
 **/

package com.cb.number.guess.game;

import java.util.Scanner;

/**
 * @author Srinivasa
 */
public class GameMain {
	/**
	 * Main method to run a the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		GameMain game = new GameMain();
		game.startGameWithRange();
	}

	/**
	 * Method will have the implementation of the number guessing game, it
	 * starts the game when user enters<b> Ready </b>.
	 */
	private void startGameWithRange() {

		System.out.println("Welcome to Number Guessing Game!!");
		System.out
				.println("Please check the instructions below to play the game");
		System.out.println("1. Please type in 'Ready' to play the game.");
		System.out
				.println("2. Choose the start range and end range of the number to be choosen. ");
		System.out.println("3. Choose the number in your mind");
		System.out
				.println("4. Provide answers to a series of quiestions asked by the application to guess a number.");
		System.out
				.println("5. User answers should be 'higher' or 'lower' or 'yes'");
		System.out.println("6. Game ends when user response as 'yes' or 'end'");

		System.out.println("Please type 'Ready' to start the game.");
		Scanner reader = new Scanner(System.in);
		if (!"Ready".equalsIgnoreCase(reader.next())) {
			System.out
					.println("Please restart application and type in 'Ready' to start the game");
			reader.close();
			System.exit(0);
		}

		System.out.println(" Please enter the start range: ");
		int startRange = reader.nextInt();
		System.out.println(" Please enter the end range: ");
		int endRange = reader.nextInt();

		/**
		 * check if the start range is greater than end range, if yes, let's
		 * swap the range variables.
		 */
		if (startRange > endRange) {
			int nStartRange = endRange;
			int nEndRange = startRange;
			startRange = nStartRange;
			endRange = nEndRange;
		}
		// let's guess the number as middle in between start and end ranges.
		int number = (startRange + endRange) / 2;

		// recursive method to guess the number.
		guessCustomerNumber(startRange, endRange, number);
	}

	/**
	 * This is the Java recursive method, implements the functionality of
	 * guessing the a customer number.
	 * 
	 * @param startRange
	 *            : starting range number.
	 * @param endRange
	 *            : ending range number.
	 * @param number
	 *            : guessing number.
	 */
	private void guessCustomerNumber(int startRange, int endRange, int number) {
		System.out.println("Your Number is ? " + number);

		// keep the previous number for calculation.
		int preNumber = number;
		Scanner scanner = new Scanner(System.in);
		String ans = scanner.next();

		// validate user response.
		if (!validateUserResponse(ans)) {
			System.out.println(ans + " is incorrect answer...");
			guessCustomerNumber(startRange, endRange, number);
		}

		if (ans.equalsIgnoreCase("yes")) {
			System.out.println("Thanks for your time! Hope you had fun!!");
			scanner.close();
			System.exit(0);
		} else if (ans.equalsIgnoreCase("end")) {
			System.out.println("Thanks for your time! Hope you had fun!!");
			scanner.close();
			System.exit(0);
		} else {

			// calculate the next number
			number = calculateNextNumber(ans, number, startRange, endRange);
			if (ans.equalsIgnoreCase("lower")) {
				endRange = preNumber;
			} else {
				startRange = preNumber;
			}
			guessCustomerNumber(startRange, endRange, number);
		}

	}

	/**
	 * This method validates the user response.
	 * 
	 * @param ans
	 *            : user response.
	 * @return
	 */
	public boolean validateUserResponse(String ans) {
		if (ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("end")
				|| ans.equalsIgnoreCase("higher")
				|| ans.equalsIgnoreCase("lower")) {
			return true;
		}
		return false;
	}

	/**
	 * This method calculate the next number in the series.
	 * 
	 * @param ans
	 *            : user response.
	 * @param number
	 *            : guessed number.
	 * @param startRange
	 *            : start range.
	 * @param endRange
	 *            : end range.
	 * @return
	 */
	public int calculateNextNumber(String ans, int number, int startRange,
			int endRange) {

		if (ans.equalsIgnoreCase("higher")) {
			return (endRange + number) / 2;
		} else {
			return (startRange + number) / 2;
		}
	}
}