package Tools;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;


class StringToolsTest {

    @ParameterizedTest
    @MethodSource("paramsFor_ConvertStringToInt_shouldReturnValues")
    public void testConvertStringToInt_shouldReturnValues(String values, int output) {

        Assertions.assertThat(StringTools.convertStringToInt(values)).isEqualTo(output);
    }

    private static Object[] paramsFor_ConvertStringToInt_shouldReturnValues() {

        return new Object[]{
                new Object[]{"1", 1},
                new Object[]{"-1", -1},
                new Object[]{"10", 10},
                new Object[]{"100", 100}
        };
    }

    @ParameterizedTest
    @MethodSource("paramsFor_convertStringTableToIntArray_ShouldReturnIntegerList")
    public void testConvertStringTableToIntArray_ShouldReturnIntegerList(String[] array, List<Integer> output) {

        Assertions.assertThat(StringTools.convertStringTableToIntArray(array)).isEqualTo(output);
    }

    private static Object[] paramsFor_convertStringTableToIntArray_ShouldReturnIntegerList() {

        return new Object[]{
                new Object[]{new String[]{"2", "7", "10"}, Arrays.asList(2, 7, 10)},
                new Object[]{new String[]{"-2", "10", "-9"}, Arrays.asList(-2, 10, -9)},
                new Object[]{new String[]{"-2", "-7", "-10"}, Arrays.asList(-2, -7, -10)}
        };
    }
}