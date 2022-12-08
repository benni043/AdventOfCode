package advent6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Advent6 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ressources/advent6.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            System.out.println(checkWhenMarker(line, 4));
            System.out.println(checkWhenMarker(line, 14));
        }
    }
    public static int checkWhenMarker(String line, int size) {
        Set<Character> characters = new HashSet<>();

        for (int i = 0; i < line.toCharArray().length; i++) {
            char[] chars = line.toCharArray();

            for (int j = 0; j < size; j++) {
                characters.add(chars[i + j]);
            }

            if (characters.size() == size) return i+size;
            else characters.clear();
        }
        throw new IllegalArgumentException("character not contained");
    }

}
