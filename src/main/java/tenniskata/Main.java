package tenniskata;

import tenniskata.handler.InputHandler;
import tenniskata.handler.TennisMatchHandler;
import tenniskata.match.Player;
import tenniskata.match.ScoreBoard;
import tenniskata.match.TennisMatch;
import tenniskata.validator.InputValidator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        String cmdInput;

        if (args != null && args.length > 0 && args[0] != null) {
            cmdInput = args[0];
        } else {
            System.out.println("Type in the desire match score sequence as A and B for each player, respectively, or a filename");
            Scanner scanner = new Scanner(System.in);
            cmdInput = scanner.nextLine();
        }

        String input = handleInput(cmdInput);
        startTennisMatch(input);
    }

    private static String handleInput(String cmdInput) throws Exception {
        String input = new InputHandler().handle(cmdInput);
        new InputValidator().execute(input);
        return input;
    }

    private static void startTennisMatch(String input) {
        TennisMatchHandler handler = new TennisMatchHandler(new TennisMatch(), new ScoreBoard());
        for (int i = 0; i < input.length(); i++) {
            if (!handler.isMatchOver()) {
                Player player = Player.A.fromChar(input.charAt(i));
                handler.scorePoint(player);
                String currentScore = handler.getCurrentScore();
                System.out.println(currentScore);
            }
        }
    }
}