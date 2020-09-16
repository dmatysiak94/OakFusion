package Tools;

import java.util.List;
import java.util.stream.Collectors;

public class IntegerTools {

    public static int sumValuesInArray (List<Integer> intList){

        return intList.stream().mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> getNegativeValuesFromList(List<Integer> numbersList) {

        return numbersList.stream()
                .filter(number -> number < 0)
                .collect(Collectors.toList());
    }

    public static List<Integer> filterValuesGreaterThanThousand(List<Integer> numbersList) {

        return numbersList.stream()
                .filter(number -> number <= 1000)
                .collect(Collectors.toList());
    }
}
