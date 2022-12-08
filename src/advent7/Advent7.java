package advent7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Advent7 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ressources/advent7.txt"));

        Map<String, Integer> map = new TreeMap<>();
        List<String> activeDirectories = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if(line.startsWith("$ cd ..")) {
                activeDirectories.remove(activeDirectories.size()-1);

                continue;
            }

            if (line.startsWith("$ cd")) {
                String[] name = line.split(" ");

                map.put(name[2], 0);

                activeDirectories.add(name[2]);

                continue;
            }

            if(!line.startsWith("$ ls") && !line.startsWith("dir")) {
                for (String activeDirectory : activeDirectories) {
                    map.put(activeDirectory, map.get(activeDirectory) + Integer.parseInt(line.split(" ")[0]));
                }

            }
        }

        System.out.println(map);

        int sum = 0;
        for (Integer value : map.values()) {
            if(value <= 100000) sum += value;
        }

        System.out.println(sum);
    }
}