import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RajatBhageria on 4/14/16.
 */
public class NormalHangManTest extends TestCase {

    private HangmanGame hangmanGame;
    @Before
    public void setUp() throws Exception {
         hangmanGame = new NormalHangMan("TEST", 5, "");
    }

    @Test
    public void testInputNotLetter() {
        String guess = ":";
        assertEquals(false, hangmanGame.makeGuess((guess).charAt(0)));
        assertEquals("", hangmanGame.lettersGuessed());
        assertEquals(5, hangmanGame.numGuessesRemaining());
        assertEquals(3, hangmanGame.numLettersRemaining());

    }

    @Test
    public void testInputNotInWord() {
        String guess = "P";

        assertEquals(false, hangmanGame.makeGuess((guess).charAt(0)));
        assertEquals("P", hangmanGame.lettersGuessed());
        assertEquals(4, hangmanGame.numGuessesRemaining());
        assertEquals(3, hangmanGame.numLettersRemaining());
        //This is because the letter T appears twice.

    }

    @Test
    public void testInputInWord() {
        String guess = "T";
        assertEquals(true, hangmanGame.makeGuess((guess).charAt(0)));
        assertEquals("T", hangmanGame.lettersGuessed());
        assertEquals(5, hangmanGame.numGuessesRemaining());
        assertEquals(2, hangmanGame.numLettersRemaining());
        assertEquals("T _ _ T ", hangmanGame.displayGameState());
        assertEquals(hangmanGame.gameOver(), false);

    }

    @Test
    public void testInputTwice() {
        String guess = "T";
        assertEquals(true, hangmanGame.makeGuess((guess).charAt(0)));
        assertEquals(false, hangmanGame.makeGuess((guess).charAt(0)));
        assertEquals("T", hangmanGame.lettersGuessed());
        assertEquals(5, hangmanGame.numGuessesRemaining());
        assertEquals(2, hangmanGame.numLettersRemaining());
        assertEquals(hangmanGame.getSecretWord(), "TEST");
        assertEquals("T _ _ T ", hangmanGame.displayGameState());
    }

    @Test
    public void testWinAllCorrect() {
        assertEquals(true, hangmanGame.makeGuess(("T").charAt(0)));
        hangmanGame.makeGuess(("E").charAt(0));
        hangmanGame.makeGuess(("S").charAt(0));
        assertEquals("TES", hangmanGame.lettersGuessed());
        assertEquals(5, hangmanGame.numGuessesRemaining());
        assertEquals(0, hangmanGame.numLettersRemaining());
        assertEquals("T E S T ", hangmanGame.displayGameState());
        assertEquals(hangmanGame.isWin(), true);
    }


    @Test
    public void testRunOutofGuesses() {
        assertEquals(true, hangmanGame.makeGuess(("T").charAt(0)));
        hangmanGame.makeGuess(("P").charAt(0));
        hangmanGame.makeGuess(("Q").charAt(0));
        hangmanGame.makeGuess(("L").charAt(0));
        hangmanGame.makeGuess(("N").charAt(0));
        assertEquals(hangmanGame.isWin(), true);

        hangmanGame.makeGuess(("M").charAt(0));
        assertEquals("TPQLNM", hangmanGame.lettersGuessed());
        assertEquals(0, hangmanGame.numGuessesRemaining());
        assertEquals(2, hangmanGame.numLettersRemaining());
        assertEquals("T _ _ T ", hangmanGame.displayGameState());
        assertEquals(hangmanGame.isWin(), false);
        assertEquals(hangmanGame.gameOver(), true);
    }


    @Test
         public void testWithNoRepeatsInWord() {
        HangmanGame hang = new NormalHangMan("NICE", 4, "N");
        assertEquals(4, hang.numLettersRemaining());
        assertEquals(false, hang.makeGuess(("T").charAt(0)));
        assertEquals("NT", hang.lettersGuessed());
        assertEquals(3, hang.numGuessesRemaining());
        assertEquals(4, hang.numLettersRemaining());
        assertEquals("_ _ _ _ ", hang.displayGameState());
        assertEquals(true, hang.makeGuess(("C").charAt(0)));
        assertEquals("_ _ C _ ", hang.displayGameState());
        assertEquals(hang.isWin(), true);

    }





}