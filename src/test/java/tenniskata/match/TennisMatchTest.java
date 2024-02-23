package tenniskata.match;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import tenniskata.handler.TennisMatchHandler;

@TestMethodOrder(MethodOrderer.Random.class)
class TennisMatchTest {

    private TennisMatchHandler handler;

    @BeforeEach
    void setUp() {
        ScoreBoard board = new ScoreBoard();
        TennisMatch match = new TennisMatch();
        handler = new TennisMatchHandler(match, board);
    }

    @Test
    @DisplayName("Test A-15 B-0")
    void testA15B0() {
        handler.scorePoint(Player.A);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Player A: 15 / Player B: 0", currentScore);
    }

    @Test
    @DisplayName("Test A-15 B-15")
    void testA15B15() {
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Player A: 15 / Player B: 15", currentScore);
    }

    @Test
    @DisplayName("Test A-15 B-30")
    void testA15B30() {
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.B);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Player A: 15 / Player B: 30", currentScore);
    }

    @Test
    @DisplayName("Test A-30 B-30")
    void testA30B30() {
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.A);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Player A: 30 / Player B: 30", currentScore);
    }

    @Test
    @DisplayName("Test A-40 B-30")
    void testA40B30() {
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.A);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Player A: 40 / Player B: 30", currentScore);
    }

    @Test
    @DisplayName("Test Deuce")
    void testDeuce() {
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Deuce", currentScore);
    }

    @Test
    @DisplayName("Test A wins all")
    void testAWinsAll() {
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.A);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Player A wins the set", currentScore);
    }

    @Test
    @DisplayName("Test no score")
    void testNoScore() {
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("The match hasn't started yet.", currentScore);
    }

    @Test
    @DisplayName("Test Advantage A")
    void testAdvantageA() {
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.A);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Advantage Player A", currentScore);
    }

    @Test
    @DisplayName("Test Advantage B")
    void testAdvantageB() {
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.B);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Advantage Player B", currentScore);
    }

    @Test
    @DisplayName("Test B wins after advantage")
    void testBWinsAfterAdvantage() {
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.A);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.B);
        handler.scorePoint(Player.B);
        String currentScore = handler.getCurrentScore();
        Assertions.assertEquals("Player B wins the set", currentScore);
    }


}