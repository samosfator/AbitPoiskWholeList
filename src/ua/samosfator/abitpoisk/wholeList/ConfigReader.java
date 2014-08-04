package ua.samosfator.abitpoisk.wholeList;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConfigReader {
    private static List<String> dates = new ArrayList<>(Arrays.asList("2013-07-31", "2013-08-04", "2013-08-07", "2013-08-10", "2013-08-30"));
    private List<String> directions;

    public ConfigReader(String filename) throws IOException {
        directions = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
    }

    public List<String> getDirections() {
        return directions;
    }

    public static List<String> getDates() {
        return dates;
    }
}
