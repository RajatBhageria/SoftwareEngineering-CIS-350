import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RajatBhageria on 4/14/16.
 */
public class EvilHangManTest extends TestCase {


    private HangmanGame hangmanGame;

    @Before
    public void setUp() throws Exception {
        hangmanGame = new EvilHangMan(5, 5);
    }

    @Test
    public void testInputNotLetter() {
        String guess = ":";
        assertEquals(false, hangmanGame.makeGuess((guess).charAt(0)));
        assertEquals("", hangmanGame.lettersGuessed());
        assertEquals(5, hangmanGame.numGuessesRemaining());

    }

    @Test
    public void testIsRepeatEntry() {
        String guess = "p";
        assertEquals(false, hangmanGame.makeGuess((guess).charAt(0)));
        assertEquals("p", hangmanGame.lettersGuessed());
        assertEquals("_ _ _ _ _ ", hangmanGame.displayGameState());
        assertEquals(false, hangmanGame.makeGuess((guess).charAt(0)));
        assertEquals("p", hangmanGame.lettersGuessed());
        assertEquals(4, hangmanGame.numGuessesRemaining());
        assertEquals(26, hangmanGame.numLettersRemaining());
    }

    @Test
    public void testRunOutOfGuesses() {
        assertEquals(false, hangmanGame.makeGuess(("P").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("C").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("L").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("A").charAt(0)));
        assertEquals(false, hangmanGame.gameOver());

        assertEquals(false, hangmanGame.makeGuess(("M").charAt(0)));
        assertEquals(false, hangmanGame.isWin());
        assertEquals("PCLAM", hangmanGame.lettersGuessed());
        assertEquals("_ _ _ _ _ ", hangmanGame.displayGameState());
        assertEquals(0, hangmanGame.numGuessesRemaining());
        assertEquals(26, hangmanGame.numLettersRemaining());
        assertEquals(true, hangmanGame.gameOver());
    }

    @Test
    public void testSecretWordChanges() {
        String secret = hangmanGame.getSecretWord();
        assertEquals(false, hangmanGame.makeGuess(("A").charAt(0)));
        String secretNew = hangmanGame.getSecretWord();
        assertEquals(false, hangmanGame.makeGuess(("B").charAt(0)));
        assertEquals("AB", hangmanGame.lettersGuessed());
        String secretNewest = hangmanGame.getSecretWord();
        assertNotEquals(secret, secretNew);
        assertNotEquals(secretNew, secretNewest);

    }

    @Test
    public void testDontGuessCorrectLetter() {
        assertEquals(false, hangmanGame.makeGuess(("C").charAt(0)));
        String secret = hangmanGame.getSecretWord();
        assertEquals(false, hangmanGame.makeGuess(("B").charAt(0)));
        String secretNew = hangmanGame.getSecretWord();
        assertEquals(secret, secretNew);

    }

    @Test
    public void testTryingToGetTrue() {
        HangmanGame hangmanGame = new EvilHangMan(2, 26);
        assertEquals(false, hangmanGame.makeGuess(("A").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("B").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("C").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("D").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("E").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("F").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("G").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("H").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("I").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("J").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("K").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("L").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("M").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("N").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("O").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("P").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("Q").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("R").charAt(0)));
        assertEquals(false, hangmanGame.makeGuess(("S").charAt(0)));
        assertEquals(true, hangmanGame.makeGuess(("U").charAt(0)));
        assertEquals("ABCDEFGHIJKLMNOPQRS", hangmanGame.lettersGuessed());
    }

}