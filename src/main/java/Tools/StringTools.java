package Tools;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringTools {

    public static int convertStringToInt(String stringNumber) throws NumberFormatException {
        return Integer.parseInt(stringNumber);
    }

    public static List<Integer> convertStringTableToIntArray(String[] stringArray) {
        List<String> stringList = Arrays.asList(stringArray);
        return stringList.stream()
                .mapToInt(value -> Integer.parseInt(value))
                .boxed()
                .collect(Collectors.toList());
    }
}
