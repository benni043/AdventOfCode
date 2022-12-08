package advent3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Advent3 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ressources/advent3.txt"));

        int sum1 = 0;
        int sum2 = 0;

        int lineCountAfter3 = 0;
        List<String> stringList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            sum1 += keyValue(duplicatedKeys(line));

            if(lineCountAfter3 == 3) {
                sum2 += keyValue(duplicatedKeys2(stringList));

                stringList.clear();
                lineCountAfter3 = 0;
            }
            lineCountAfter3++;
            stringList.add(line);
        }
        sum2 += keyValue(duplicatedKeys2(stringList));

        System.out.println(sum1);
        System.out.println(sum2);
    }

    public static char duplicatedKeys2(List<String> lines) {
        char[] chars = lines.get(0).toCharArray();
        char[] chars2 = lines.get(1).toCharArray();
        char[] chars3 = lines.get(2).toCharArray();

        for (char aChar : chars) {
            for (char c : chars2) {
                for (char c1 : chars3) {
                    if(aChar == c && aChar == c1) return aChar;
                }
            }
        }

        throw new IllegalArgumentException("character not contained");
    }

    public static char duplicatedKeys(String line) {
        Set<Character> map = new HashSet<>();

        for (int i = 0; i < line.length() / 2; i++) {
            map.add(line.charAt(i));
        }

        for (int i = line.length() / 2; i < line.length(); i++) {
            if (map.contains(line.charAt(i))) return line.charAt(i);
        }

        throw new IllegalArgumentException("character not contained");
    }

    public static int keyValue(char key) {
        if ((int) key >= 97) return (int) key - 96;
        else return (int) key - 64 + 26;
    }

}
