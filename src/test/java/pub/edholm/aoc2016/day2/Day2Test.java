package pub.edholm.aoc2016.day2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Emil Edholm on 2016-12-10.
 */
public class Day2Test {
    @Test
    public void solvePart1() throws Exception {
        final Day2 day2 = new Day2();
        final String result = day2.solvePart1("day2.input.test");
        assertThat(result, is("1985"));
    }

    @Test
    public void solvePart2() throws Exception {
        final Day2 day2 = new Day2();
        final String result = day2.solvePart2("day2.input.test");
        assertThat(result, is("5DB3"));
    }

}