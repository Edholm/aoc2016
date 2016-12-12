package pub.edholm.aoc2016.day5;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Emil Edholm on 2016-12-12.
 */
public class Day5Test {
    @Test
    public void solvePart1() throws Exception {
        final Day5 day5 = new Day5();
        assertThat(day5.solvePart1("day5.input.test"), is("18f47a30"));
    }

}