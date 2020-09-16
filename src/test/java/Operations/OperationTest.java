package Operations;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    Operation operation;

    @BeforeEach
    public void setOperation() {

        operation = new Operation();
    }

    @ParameterizedTest
    @MethodSource("paramsFor_addTest_shouldReturnZeroIfParameterIsNullEmptyOrWhitespace")
    public void addTest_shouldReturnZeroIfParameterIsNullEmptyOrWhitespace(String text) {

        Assertions.assertThat(operation.add(text)).isEqualTo(0);
    }

    private static Object[] paramsFor_addTest_shouldReturnZeroIfParameterIsNullEmptyOrWhitespace() {

        return new Object[]{
                new Object[]{null},
                new Object[]{"   "},
                new Object[]{""},
                new Object[]{"\n"}
        };
    }

    @ParameterizedTest
    @MethodSource("paramsFor_addTest_shouldReturnSumOfMaxTwoValues")
    public void addTest_shouldReturnSumOfMaxTwoValues(String text, int output) {

        Assertions.assertThat(operation.add(text)).isEqualTo(output);
    }

    private static Object[] paramsFor_addTest_shouldReturnSumOfMaxTwoValues() {

        return new Object[]{
                new Object[]{"1,4", 5},
                new Object[]{"10,4", 14},
                new Object[]{"6,4", 10},
                new Object[]{"2", 2}
        };
    }

    @Test
    public void addTest_ThrowNumberFormatExceptionWhenNotNumericValue() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            operation.add("b,4,-4");
        });
    }

    @ParameterizedTest
    @MethodSource("paramsFor_addTest_shouldReturnSumOfMoreThanTwoValues")
    public void addTest_shouldReturnSumOfMoreThanTwoValues(String text, int output) {

        Assertions.assertThat(operation.add(text)).isEqualTo(output);
    }

    private static Object[] paramsFor_addTest_shouldReturnSumOfMoreThanTwoValues() {

        return new Object[]{
                new Object[]{"1,4,5", 10},
                new Object[]{"10,4,7,8", 29},
                new Object[]{"6,4,56,21,87", 174},
                new Object[]{"2,1,2,3,4,5,6,78,9", 110}
        };
    }

    @ParameterizedTest
    @MethodSource("paramsFor_addTest_shouldAllowSeparateWithNewLineSpecialSign")
    public void addTest_shouldAllowSeparateWithNewLineSpecialSign(String value, int output) {

        Assertions.assertThat(operation.add(value)).isEqualTo(output);
    }

    private static Object[] paramsFor_addTest_shouldAllowSeparateWithNewLineSpecialSign() {

        return new Object[]{
                new Object[]{"10\n2\n3", 15},
                new Object[]{"10,2\n3", 15}
        };
    }

    @ParameterizedTest
    @MethodSource("paramsFor_addTest_shouldAllowSeparateWithCustomDelimiter")
    public void addTest_shouldAllowSeparateWithCustomDelimiter(String value, int output) {

        Assertions.assertThat(operation.add(value)).isEqualTo(output);
    }

    private static Object[] paramsFor_addTest_shouldAllowSeparateWithCustomDelimiter() {

        return new Object[]{
                new Object[]{"//[;]\n10;2;3", 15},
                new Object[]{"//[g]\n10g2g3", 15}
        };
    }

    @Test
    public void addTest_ThrowRuntimeExceptionWhenNegativeValue() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            operation.add("1,4,-4");
        });
    }

    @Test
    public void addTest_showIncorrectValuesWhenRuntimeException() {
        try {
            operation.add("1,4,-4,-5");
        } catch (RuntimeException exception) {
            Assertions.assertThat(exception.getMessage()).contains("Negative numbers are Not Allowed[-4, -5]");
        }
    }

    @ParameterizedTest
    @MethodSource("paramsFor_addTest_shouldReturnSumOfValuesLesserThanThousand")
    public void addTest_shouldReturnSumOfValuesLesserThanThousand(String text, int output) {

        Assertions.assertThat(operation.add(text)).isEqualTo(output);
    }

    private static Object[] paramsFor_addTest_shouldReturnSumOfValuesLesserThanThousand() {

        return new Object[]{
                new Object[]{"1,4,5,1001", 10},
                new Object[]{"10,4,7,8,1000", 1029},
                new Object[]{"6,4,56,21,87,999", 1173},
                new Object[]{"1000,1001,999", 1999}
        };
    }

}