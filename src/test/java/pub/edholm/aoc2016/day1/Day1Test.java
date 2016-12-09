package pub.edholm.aoc2016.day1;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Emil Edholm on 2016-12-08.
 */
public class Day1Test {
    @Test
    public void calculateDistance() throws Exception {
        final Day1 day1 = new Day1();
        assertThat(day1.calculateDistance(Arrays.asList("R2", "L3")), is(5));
        assertThat(day1.calculateDistance(Arrays.asList("R2", "R2", "R2")), is(2));
        assertThat(day1.calculateDistance(Arrays.asList("R5", "L5", "R5", "R3")), is(12));
    }

    @Test
    public void testDistanceToFirstNonUnique() throws Exception {
        final Day1 day1 = new Day1();
        assertThat(day1.solvePart2("R8, R4, R4, R8"), is("4"));
    }
}