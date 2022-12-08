package advent4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Advent4 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("ressources/advent4.txt"));

        int sum = 0;
        int sum2 = 0;

        while (scanner.hasNextLine()) {
            String[] strings = scanner.nextLine().split(",");

            String[] s1 = strings[0].split("-");
            String[] s2 = strings[1].split("-");

            List<Integer> listElements1 = getListElements(Integer.parseInt(s1[0]), Integer.parseInt(s1[1]));
            List<Integer> listElements2 = getListElements(Integer.parseInt(s2[0]), Integer.parseInt(s2[1]));

            if (isOverwrittenFully(listElements1, listElements2)) sum += 1;
            if (isOverwrittenInRanges(listElements1, listElements2)) sum2 += 1;
        }

        System.out.println(sum);
        System.out.println(sum2);
    }

    public static List<Integer> getListElements(int startIdx, int endIdx) {
        List<Integer> integers = new ArrayList<>();

        for (int i = startIdx; i < endIdx + 1; i++) {
            integers.add(i);
        }

        return integers;
    }

    public static boolean isOverwrittenFully(List<Integer> list1, List<Integer> list2) {
        return new HashSet<>(list1).containsAll(list2) || new HashSet<>(list2).containsAll(list1);
    }

    public static boolean isOverwrittenInRanges(List<Integer> list1, List<Integer> list2) {
        Set<Integer> integerSet = new HashSet<>();

        integerSet.addAll(list1);
        integerSet.addAll(list2);

        return integerSet.size() != list1.size() + list2.size();
    }
}