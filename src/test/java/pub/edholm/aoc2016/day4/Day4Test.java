package pub.edholm.aoc2016.day4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
public class Day4Test {
    @Test
    public void solvePart1() throws Exception {
        final Day4 day4 = new Day4();
        assertThat(day4.solvePart1("day4.input.test"), is("1514"));
    }

    @Test
    public void solvePart2() throws Exception {
        Room room = Room.valueOf("qzmt-zixmtkozy-ivhz-343[zimth]");
        assertThat(room.isReal(), is(true));
        assertThat(room.decrypt(), is("very encrypted name"));
    }
}