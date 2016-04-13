import java.util.*;
import java.io.*;


public class EvilHangMan implements HangmanGame {
	protected String secretWord = "";// To store the secret word
	protected int guess;// to store the number of guess for the user
	protected String state = "";// store the current guessing situation
	protected String letterGuessHistory = "";// store the letters user has tried
	protected char letterGuess;// the letter the user guess right now
	protected String[] wordlist = new String[235000];// to store the dictionary
	protected int numWords = 0;// count the number of possible secret words.
	protected int secretStringLength;// the length of the secret string
	protected boolean guessResult = false;

	public EvilHangMan(int StringLength, int numGuesses) {
		guess = numGuesses;
		secretStringLength = StringLength;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("dictionary.txt"));// read the dictionary
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int i = 0;
		while (scanner.hasNext()) {
			String temp = scanner.nextLine().toUpperCase();
			if (temp.length() == StringLength) {
				wordlist[i] = temp;
				i++;
				numWords++;
			}
		}

		for (i = 0; i < StringLength; i++) {
			state += "_ ";
		}
		scanner.close();

	}

	public String getSecretWord() {
		return secretWord;
	}

	public int numGuessesRemaining() {
		return guess;
	}

	public int numLettersRemaining() {
		return 26; // because they never get one right!
	}

	public boolean isWin() {
		return false;
	}

	public boolean gameOver() {
		if (guess == 0)
			return true;
		else
			return false;
	}

	public String lettersGuessed() {
		return letterGuessHistory;
	}

	public String displayGameState() {
		return state;
	}


	public boolean makeGuess(char ch) {

		guessResult = false;
		letterGuess = ch;
		if (Character.isLetter(ch) && !isRepeatInput(ch)) {
			// adjust the Wordlist in order to avoid the word with the letter
			// user guessed
			int tempWordNum = 0;
			for (int i = 0; i < numWords; i++) {
				for (int j = 0; j < secretStringLength; j++) {
					if (wordlist[i].charAt(j) == ch) {
						break;
					} else {
						if (j == secretStringLength - 1) {
							if (wordlist[i].charAt(j) != ch) {
								tempWordNum++;
							}
							else break;
						}
					}
				}
			}
			// we choose the words that don't contain the letter the user
			// guessed, and they will be the new possible secret words.
			String[] temp = new String[tempWordNum];
			int tempIndex = 0;
			for (int i = 0; i < numWords; i++) {
				for (int j = 0; j < secretStringLength; j++) {
					if (wordlist[i].charAt(j) == ch) {
						break;
					} else {
						if (j == secretStringLength - 1) {
							if (wordlist[i].charAt(j) != ch) {
								temp[tempIndex] = wordlist[i];
								tempIndex++;
							}
						}
					}
				}
			}
			if (tempWordNum == 0) {
				secretWord = wordlist[0];
				guessResult = true;
			} else {
				secretWord = temp[0];
				numWords = tempWordNum;
				wordlist = temp;
				guess--;
				guessResult = false;
			}
			if (!guessResult) {
				letterGuessHistory = letterGuessHistory + letterGuess;
			}

		} else return false;
		
		return guessResult;
	}

    public boolean isRepeatInput(char c)
    {
    	for (int i = 0; i < letterGuessHistory.length(); i++) {
    		if (letterGuessHistory.charAt(i) == c) return true;
    	}
    	return false;
    }
}