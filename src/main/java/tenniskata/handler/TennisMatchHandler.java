package tenniskata.handler;

import tenniskata.match.Player;
import tenniskata.match.ScoreBoard;
import tenniskata.match.TennisMatch;

public class TennisMatchHandler {

    private final TennisMatch match;
    private final ScoreBoard board;
    private Player lastPlayed;

    public TennisMatchHandler(TennisMatch match, ScoreBoard board) {
        this.match = match;
        this.board = board;
    }

    public void scorePoint(Player player) {
        if (!isMatchOver()) {
            this.match.updateScore(player);
            this.lastPlayed = player;
        }
    }

    public String getCurrentScore() {
        return this.board.getCurrentScore(this.match, lastPlayed);
    }

    public boolean isMatchOver() {
        return this.match.isOver();
    }
}
