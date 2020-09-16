package Tools;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

class IntegerToolsTest {

    @ParameterizedTest
    @MethodSource("paramsFor_sumValuesInArray_ShouldReturnCorrectSum")
    public void testSumValuesInArray_ShouldReturnCorrectSum(List<Integer> array, int output) {

        Assertions.assertThat(IntegerTools.sumValuesInArray(array)).isEqualTo(output);
    }

    private static Object[] paramsFor_sumValuesInArray_ShouldReturnCorrectSum() {

        return new Object[]{
                new Object[]{Arrays.asList(2, 7, 10), 19},
                new Object[]{Arrays.asList(2, 7, 10, 30), 49},
                new Object[]{Arrays.asList(2, 7), 9},
                new Object[]{Arrays.asList(-2, 7), 5},
                new Object[]{Arrays.asList(2), 2}
        };
    }

    @ParameterizedTest
    @MethodSource("paramsFor_testisCheckIfAnyValueIsNegative")
    public void testIsCheckIfAnyValueIsNegative(List<Integer> intList, List<Integer> output) {

        Assertions.assertThat(IntegerTools.getNegativeValuesFromList(intList)).isEqualTo(output);
    }

    private static Object[] paramsFor_testisCheckIfAnyValueIsNegative() {

        return new Object[]{
                new Object[]{Arrays.asList(1, -2, 3, -4), Arrays.asList(-2, -4)},
                new Object[]{Arrays.asList(1, 2, 3, -4), Arrays.asList(-4)},
                new Object[]{Arrays.asList(1, 2, 3, 4), Arrays.asList()},
        };
    }

    @ParameterizedTest
    @MethodSource("paramsFor_testfilterValuesGreaterThanThousand")
    public void testFilterValuesGreaterThanThousand(List<Integer> intList, List<Integer> output) {

        Assertions.assertThat(IntegerTools.filterValuesGreaterThanThousand(intList)).isEqualTo(output);
    }

    private static Object[] paramsFor_testfilterValuesGreaterThanThousand() {

        return new Object[]{
                new Object[]{Arrays.asList(1000, 1, 1001, 300), Arrays.asList(1000, 1, 300)},
                new Object[]{Arrays.asList(1067, 232423, 33444, -4), Arrays.asList(-4)},
                new Object[]{Arrays.asList(10000, 20000, 30000, 40000), Arrays.asList()},
        };
    }

}