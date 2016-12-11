package pub.edholm.aoc2016.day4;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Emil Edholm on 2016-12-10.
 */
final class Room {
    private final String name;
    private final int sectorId;
    private final String checksum;

    private Room(String name, String sectorId, String checksum) {
        this.name = name;
        this.sectorId = Integer.parseInt(sectorId);
        this.checksum = checksum;
    }

    public int sectorId() {
        return sectorId;
    }

    public boolean isReal() {
        final Map<Character, Integer> frequency = new HashMap<>();
        name.replace("-", "").chars()
                .mapToObj(c -> (char) c)
                .forEach(c -> frequency.put(c, frequency.getOrDefault(c, 0) + 1));

        final List<Map.Entry<Character, Integer>> entries = frequency.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toList());

        final String calculatedChecksum = entries.stream()
                .sorted((o1, o2) -> {
                    int val = Integer.compare(o2.getValue(), o1.getValue());
                    if (val != 0) {
                        return val;
                    }
                    return Character.compare(o1.getKey(), o2.getKey());
                })
                .limit(5)
                .map(v -> v.getKey().toString())
                .collect(Collectors.joining());

        return checksum.equals(calculatedChecksum);
    }

    public static Room valueOf(String s) {
        final int lastDash = s.lastIndexOf("-");
        final int firstBracket = s.indexOf("[");

        String name = s.substring(0, lastDash);
        String sectorId = s.substring(lastDash + 1, firstBracket);
        String checksum = s.substring(firstBracket + 1, s.length() - 1);

        return new Room(name, sectorId, checksum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (sectorId != room.sectorId) return false;
        if (!name.equals(room.name)) return false;
        return checksum.equals(room.checksum);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + sectorId;
        result = 31 * result + checksum.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", sectorId=" + sectorId +
                ", checksum='" + checksum + '\'' +
                '}';
    }
}
