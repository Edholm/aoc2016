package pub.edholm.aoc2016.day5;

import org.apache.commons.codec.digest.DigestUtils;
import pub.edholm.aoc2016.Aoc;
import pub.edholm.aoc2016.utils.IoUtils;

/**
 * Created by Emil Edholm on 2016-12-11.
 */
public class Day5 implements Aoc {
    public static void main(String[] args) {
        final Day5 day5 = new Day5();
        System.out.println("Day 5:");
        long then = System.currentTimeMillis();
        System.out.println("\tPart 1: " + day5.solvePart1("day5.input"));
        long lapsed = System.currentTimeMillis() - then;
        System.out.printf("\t\tIt took %d ms\n", lapsed);

        System.out.println("\tPart 2: " + day5.solvePart2("day5.input"));
    }

    @Override
    public String solvePart1(String resourceName) {
        final String input = IoUtils.readFile(resourceName);
        StringBuilder passwordBuilder = new StringBuilder(8);
        int counter = 0;

        while (passwordBuilder.length() < 8) {
            String md5Hash = DigestUtils.md5Hex(input + counter);
            if (md5Hash.substring(0, 5).equals("00000")) {
                passwordBuilder.append(md5Hash.substring(5, 6));
            }
            counter++;
        }

        return passwordBuilder.toString();
    }
}
