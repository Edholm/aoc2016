package pub.edholm.aoc2016.day4;

import pub.edholm.aoc2016.Aoc;
import pub.edholm.aoc2016.utils.IoUtils;

import java.util.List;
import java.util.Optional;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
public class Day4 implements Aoc {
    public static void main(String[] args) {
        final Day4 day4 = new Day4();
        System.out.println("Day 4:");
        System.out.println("\tPart 1: Sector id sum: " + day4.solvePart1("day4.input"));
        System.out.println("\tPart 2: The room has sector id: " + day4.solvePart2("day4.input"));
    }

    @Override
    public String solvePart1(String resourceName) {
        final List<String> rawRooms = IoUtils.readLines(resourceName);
        final int sectorSum = rawRooms.stream()
                .map(Room::valueOf)
                .filter(Room::isReal)
                .mapToInt(Room::sectorId)
                .sum();
        return String.valueOf(sectorSum);
    }

    @Override
    public String solvePart2(String resourceName) {
        final List<String> rawRooms = IoUtils.readLines(resourceName);
        final Optional<Room> room = rawRooms.stream()
                .map(Room::valueOf)
                .filter(Room::isReal)
                .filter(r -> r.decryptedName().contains("northpole"))
                .findFirst();

        return room
                .map(room1 -> String.valueOf(room1.sectorId()))
                .orElse("unknown!");
    }
}
