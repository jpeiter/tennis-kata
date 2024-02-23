package tenniskata.match;

import java.util.HashMap;
import java.util.Map;

import static tenniskata.match.Player.A;
import static tenniskata.match.Player.B;

public class TennisMatch {

    private final Map<Player, Integer> score;

    public TennisMatch() {
        this.score = new HashMap<>();

        this.score.put(A, 0);
        this.score.put(B, 0);
    }

    public Integer getPlayerScore(Player player) {
        return this.score.get(player);
    }

    public Integer updateScore(Player player) {
        return this.score.put(player, getPlayerScore(player) + 1);
    }

    public boolean isOver() {
        Integer scoreA = getPlayerScore(A);
        Integer scoreB = getPlayerScore(B);
        return (scoreA >= 4 && scoreA - scoreB >= 2)
                || (scoreB >= 4 && scoreB - scoreA >= 2);
    }

}
