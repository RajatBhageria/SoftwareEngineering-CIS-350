import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by RajatBhageria on 4/14/16.
 */
public class GUI_PlayGameTest {

    private GUI_PlayGame playGame;
    @Before
    public void setUp() throws Exception {
        playGame = new GUI_PlayGame(5,5);
    }

    @Test
    public void testController()  {
        playGame.controller();
    }
}