package tenniskata.match;

public enum Player {
    A,
    B;

    public Player getOpponent() {
        return this == A ? B : A;
    }

    public Player fromChar(Character cs) {
        if (cs.equals('A')) {
            return A;
        } else {
            return B;
        }
    }
}
