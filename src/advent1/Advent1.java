package advent1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created 01.12.2022
 *
 * @author Benedikt Huff (Benedikt Huff)
 */
public class Advent1 {

    public static int getBiggest(List<Integer> list) {
        return list.get(0);
    }

    public static int getSumOfThreeBiggest(List<Integer> list) {
        return list.get(0) + list.get(1) + list.get(2);
    }

    public static List<Integer> getSortedListOfSum(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<Integer> sortedList = new ArrayList<>();

        int sum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if(line.equals("")) {
                sortedList.add(sum);
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }

        }
        sortedList.add(sum);

        sortedList.sort((a, b) -> b-a);
        return sortedList;
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(getBiggest(getSortedListOfSum("ressources/advent1.txt")));
        System.out.println(getSumOfThreeBiggest(getSortedListOfSum("ressources/advent1.txt")));
    }


}
