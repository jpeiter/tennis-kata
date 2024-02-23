package tenniskata.match;

import static tenniskata.match.Player.A;
import static tenniskata.match.Player.B;

public class ScoreBoard {

    public String getCurrentScore(TennisMatch match, Player currentPlayer) {
        if (currentPlayer == null) {
            return newMatch();
        }

        Integer playerScore = match.getPlayerScore(currentPlayer);
        Integer opponentScore = match.getPlayerScore(currentPlayer.getOpponent());

        if (match.isOver()) {
            return gameOver(currentPlayer, playerScore, opponentScore);
        } else if (playerScore >= 3 && opponentScore >= 3) {
            return tie(currentPlayer, playerScore, opponentScore);
        } else {
            return point(match);
        }
    }

    private String newMatch() {
        return "The match hasn't started yet.";
    }

    private String point(TennisMatch match) {
        return "Player A: " + translateScore(match.getPlayerScore(A)) + " / Player B: " + translateScore(match.getPlayerScore(B));
    }

    private String tie(Player currentPlayer, Integer playerScore, Integer opponentScore) {
        if (playerScore.equals(opponentScore)) {
            return "Deuce";
        }
        Player advantagePlayer = playerScore > opponentScore ? currentPlayer : currentPlayer.getOpponent();
        return "Advantage Player " + advantagePlayer;
    }

    private String gameOver(Player currentPlayer, Integer playerScore, Integer opponentScore) {
        Player winner = getWinner(currentPlayer, playerScore, opponentScore);
        return "Player " + winner + " wins the set";
    }

    public Player getWinner(Player player, Integer playerScore, Integer opponentScore) {
        if (playerScore >= 4 && playerScore - opponentScore >= 2) {
            return player;
        } else if (opponentScore >= 4 && opponentScore - playerScore >= 2) {
            return player.getOpponent();
        } else {
            return null;
        }
    }

    private String translateScore(int score) {
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "Unknown";
        };
    }

}
