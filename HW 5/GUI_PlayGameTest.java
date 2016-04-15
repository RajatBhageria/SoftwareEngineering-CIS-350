import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

/**
 * Created by RajatBhageria on 4/14/16.
 */
public class GUI_PlayGameTest extends TestCase {

    private GUI_PlayGame playGame;
    @Before
    public void setUp() throws Exception {
        playGame = new GUI_PlayGame(5,5);
        playGame.show();
    }

    @Test
    public void testWithRandomLetter()  {
        playGame.inputLetter = ("C").charAt(0);

        playGame.controller();
        assertEquals("Nope!", playGame.result.getText());
        assertEquals("Guesses Remaining: 4", playGame.label3.getText());
    }

    @Test
    public void testSetToNormal()  {
        playGame.game = new NormalHangMan("HELLO", 5, "");
        playGame.inputLetter = ("H").charAt(0);
        playGame.isEvil = false;
        playGame.controller();
        assertEquals("Yes!", playGame.result.getText());
        assertEquals("Guesses Remaining: 5", playGame.label3.getText());
        assertEquals("Secret Word: H _ _ _ _ " , playGame.label2.getText());

    }

    @Test
    public void testIsEvilSection()  {
        playGame.game = new NormalHangMan("HELLO", 5, "");
        playGame.inputLetter = ("H").charAt(0);
        playGame.isEvil = true;
        playGame.controller();
        assertEquals("Yes!", playGame.result.getText());
        assertEquals(false, playGame.isEvil);
        assertEquals(false, playGame.game.gameOver());


    }

    @Test
    public void testMakeItLose()  {
        playGame.game = new NormalHangMan("HELLO", 5, "");
        playGame.game.makeGuess(("P").charAt(0));
        playGame.game.makeGuess(("Q").charAt(0));
        playGame.game.makeGuess(("T").charAt(0));
        playGame.game.makeGuess(("V").charAt(0));
        playGame.game.makeGuess(("S").charAt(0));
        playGame.controller();


        assertEquals(false, playGame.game.isWin());
        assertEquals(true, playGame.game.gameOver());


    }

    @Test
    public void testMakeItWin()  {
        playGame.game = new NormalHangMan("HELLO", 5, "");
        playGame.game.makeGuess(("H").charAt(0));
        playGame.game.makeGuess(("E").charAt(0));
        playGame.game.makeGuess(("L").charAt(0));
        playGame.game.makeGuess(("O").charAt(0));
        playGame.controller();
        assertEquals(true, playGame.game.isWin());
        assertEquals(true, playGame.game.gameOver());
        assertEquals("Secret Word: H E L L O ", playGame.label2.getText());
        assertEquals("Guesses Remaining: 5", playGame.label3.getText());

    }
}