package Operations;

import Tools.IntegerTools;
import Tools.Separator;
import Tools.StringTools;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class Operation {

    public int add(String numbers) {

        Separator separator = new Separator();

        if (isBlank(numbers)) {
            return 0;

        } else if (numbers.contains(",") || numbers.contains("\n")) {

            String[] numbersTable = separator.getSplit(numbers);

            List<Integer> numbersList = StringTools.convertStringTableToIntArray(numbersTable);

            List<Integer> filteredNumbersList = IntegerTools.filterValuesGreaterThanThousand(numbersList);

            List<Integer> negativeNumbers = IntegerTools.getNegativeValuesFromList(filteredNumbersList);

            if(!negativeNumbers.isEmpty()){
                    throw new RuntimeException("Negative numbers are Not Allowed: " + negativeNumbers);
            }

            return IntegerTools.sumValuesInArray(filteredNumbersList);
        }
        return IntegerTools.checkIfNegative(StringTools.convertStringToInt(numbers));
    }


}
