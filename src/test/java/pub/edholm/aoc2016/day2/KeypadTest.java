package pub.edholm.aoc2016.day2;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
public class KeypadTest {
    private final String[][] weirdKeypad = new String[][] {
            {"", "",  "1", "",  ""},
            {"", "2", "3", "4", ""},
            {"5","6", "7", "8", "9"},
            {"", "A", "B", "C", ""},
            {"", "",  "D", "",  ""},
    };

    private Keypad keypad;

    @Before
    public void setUp() throws Exception {
        keypad = new Keypad(weirdKeypad);
    }

    @Test
    public void isValidMove() throws Exception {
        assertThat(keypad.isValidMove(0, 0), is(false));
        assertThat(keypad.isValidMove(1, 0), is(false));
        assertThat(keypad.isValidMove(2, 0), is(true));
        assertThat(keypad.isValidMove(3, 0), is(false));
        assertThat(keypad.isValidMove(4, 0), is(false));

        assertThat(keypad.isValidMove(0, 1), is(false));
        assertThat(keypad.isValidMove(1, 1), is(true));
        assertThat(keypad.isValidMove(2, 1), is(true));
        assertThat(keypad.isValidMove(3, 1), is(true));
        assertThat(keypad.isValidMove(4, 1), is(false));

        assertThat(keypad.isValidMove(0, 2), is(true));
        assertThat(keypad.isValidMove(1, 2), is(true));
        assertThat(keypad.isValidMove(2, 2), is(true));
        assertThat(keypad.isValidMove(3, 2), is(true));
        assertThat(keypad.isValidMove(4, 2), is(true));

        assertThat(keypad.isValidMove(0, 3), is(false));
        assertThat(keypad.isValidMove(1, 3), is(true));
        assertThat(keypad.isValidMove(2, 3), is(true));
        assertThat(keypad.isValidMove(3, 3), is(true));
        assertThat(keypad.isValidMove(4, 3), is(false));

        assertThat(keypad.isValidMove(0, 4), is(false));
        assertThat(keypad.isValidMove(1, 4), is(false));
        assertThat(keypad.isValidMove(2, 4), is(true));
        assertThat(keypad.isValidMove(3, 4), is(false));
        assertThat(keypad.isValidMove(4, 4), is(false));

    }

    @Test
    public void push() throws Exception {
        assertThat(keypad.push(2, 0), is("1"));

        assertThat(keypad.push(1, 1), is("2"));
        assertThat(keypad.push(2, 1), is("3"));
        assertThat(keypad.push(3, 1), is("4"));

        assertThat(keypad.push(0, 2), is("5"));
        assertThat(keypad.push(1, 2), is("6"));
        assertThat(keypad.push(2, 2), is("7"));
        assertThat(keypad.push(3, 2), is("8"));
        assertThat(keypad.push(4, 2), is("9"));

        assertThat(keypad.push(1, 3), is("A"));
        assertThat(keypad.push(2, 3), is("B"));
        assertThat(keypad.push(3, 3), is("C"));

        assertThat(keypad.push(2, 4), is("D"));
    }

}