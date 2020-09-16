package Tools;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


class SeparatorTest {

    private Separator separator;

    @BeforeEach
    private void setSeparator() {
        this.separator = new Separator();
    }

    @ParameterizedTest
    @MethodSource("paramsFor_matcherWithTwoSlashSignsAndOmeSignDelimiterLenght_ShouldReturnCorrectArray")
    public void matcherWithTwoSlashSignsAndOmeSignDelimiterLenght_ShouldReturnCorrectArray(String text, String[] output) {

        Assertions.assertThat(separator.matcherWithTwoSlashSigns(text)).isEqualTo(output);
    }

    private static Object[] paramsFor_matcherWithTwoSlashSignsAndOmeSignDelimiterLenght_ShouldReturnCorrectArray() {

        return new Object[]{
                new Object[]{"//[;]\n10;2;3", new String[]{"10", "2", "3"}},
                new Object[]{"//[.]\nc.2.gt654", new String[]{"c", "2", "gt654"}}
        };
    }

    @ParameterizedTest
    @MethodSource("paramsFor_matcherWithTwoSlashSignsAndMoreThanOneSignDelimiterLenght_ShouldReturnCorrectArray")
    public void matcherWithTwoSlashSignsAndMoreThanOneSignDelimiterLenght_ShouldReturnCorrectArray(String text, String[] output) {

        Assertions.assertThat(separator.matcherWithTwoSlashSigns(text)).isEqualTo(output);
    }

    private static Object[] paramsFor_matcherWithTwoSlashSignsAndMoreThanOneSignDelimiterLenght_ShouldReturnCorrectArray() {

        return new Object[]{
                new Object[]{"//[sdvsdv]\n10sdvsdv2sdvsdv3", new String[]{"10", "2", "3"}},
                new Object[]{"//[....]\nc....2....gt654", new String[]{"c", "2", "gt654"}}
        };
    }

    @ParameterizedTest
    @MethodSource("paramsFor_matcherWithTwoSlashSignsAndMoreThanOneDelimiterLenght_ShouldReturnCorrectArray")
    public void matcherWithTwoSlashSignsAndMoreThanOneDelimiterLenght_ShouldReturnCorrectArray(String text, String[] output) {

        Assertions.assertThat(separator.matcherWithTwoSlashSigns(text)).isEqualTo(output);
    }

    private static Object[] paramsFor_matcherWithTwoSlashSignsAndMoreThanOneDelimiterLenght_ShouldReturnCorrectArray() {

        return new Object[]{
                new Object[]{"//[!@#][$%^]\n10!@#2$%^3", new String[]{"10", "2", "3"}},
                new Object[]{"//[..][bbb][&&&]\nc..2bbbgt654&&&8", new String[]{"c", "2", "gt654", "8"}},
                new Object[]{"//[[]][[[][]]]\nc[]2[[gt654]]8", new String[]{"c", "2", "gt654", "8"}}
        };
    }

}