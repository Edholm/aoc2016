package pub.edholm.aoc2016.day6;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Emil Edholm on 2016-12-12.
 */
public class Day6Test {
    @Test
    public void solvePart1() throws Exception {
        final Day6 day6 = new Day6();
        assertThat(day6.solvePart1("day6.input.test"), is("easter"));
    }

}