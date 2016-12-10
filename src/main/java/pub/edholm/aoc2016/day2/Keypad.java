package pub.edholm.aoc2016.day2;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
final class Keypad {
    private final String[][] keypad;

    public Keypad(String[][] keypad) {
        this.keypad = keypad.clone();
    }

    public Keypad() {
        keypad = new String[][]{
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"},
        };
    }

    public boolean isValidMove(int x, int y) {
        return !keypad[y][x].isEmpty();
    }

    public String push(int x, int y) {
        if (!isValidMove(x, y)) {
            throw new IllegalArgumentException(String.format("(%d, %d) is an invalid move", x, y));
        }
        return keypad[y][x];
    }

    public int length() {
        return keypad[0].length;
    }

    public int height() {
        return keypad.length;
    }
}
