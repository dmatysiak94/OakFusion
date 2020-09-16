package Tools;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Separator {

    private final String CUSTOM_DELIMITER_INDICATOR = "//";
    private final String DEFAULT_SEPARATOR = ",|\n";
    private final String CUSTOM_DELIMITER_REGEX = "//\\[(.*)\\]\n(.*)";
    private final String PATTERN_TO_REPLACE = "]\\[";
    private final String PIPE = "|";

    public String[] getSplit(String value) {
        if(value.startsWith(CUSTOM_DELIMITER_INDICATOR)){
            return matcherWithTwoSlashSigns(value);
        }
        return value.split(DEFAULT_SEPARATOR);
    }

    private String[] matcherWithTwoSlashSigns(String value) {
        Matcher matcher =Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(value);
        matcher.matches();
        String custom = getCustomDelimiters(matcher);
        String numbers = matcher.group(2);
        return numbers.split(custom);
    }

    private String getCustomDelimiters(Matcher matcher) {
        return Stream.of(matcher.group(1).split(PATTERN_TO_REPLACE))
                .map(Pattern::quote)
                .collect(Collectors.joining(PIPE));
    }

}
