package ru.yandex.qatools.allure.aspects;

import org.junit.Test;

import java.text.MessageFormat;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.allure.aspects.AllureAspectUtils.getTitle;

/**
 * User: hrundelb
 * Date: 28.02.14
 * Time: 16:51
 */
public class AllureAspectUtilsTest {

    private final static String NAME_PATTERN_WITH_TWO_ARGS = "{method} (first arg:{0}, second arg:{1})";

    private final static String NAME_PATTERN_WITH_ONE_ARG = "{method} (arg:{0})";

    private final static String METHOD_NAME = "getSomethingNew";

    private final static String TITLE_STRING_WITH_TWO_ARGS = "{0} (first arg:{1}, second arg:{2})";

    private final static String TITLE_STRING_WITH_ONE_ARG = "{0} (arg:{1})";

    @Test
    public void getTitleWithStringArray() {
        String[] firstArg = {"one string", "two string", "three string"};
        int secondArg = 2454575;
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), secondArg};
        assertThat("Название метода с массивом строк сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithLongArray() {
        long[] firstArg = {20000L, 464564L, 8798765465465465132L};
        Integer secondArg = 1546825;
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), secondArg};
        assertThat("Название метода с массивом длинных целых чисел сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithIntArray() {
        int[] firstArg = {1, 2, 3};
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, true});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), true};
        assertThat("Название метода с массивом целых чисел сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithShortArray() {
        short[] firstArg = {32767, 0, -32768};
        String secondArg = "aaabbbbccdddd";
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), secondArg};
        assertThat("Название метода с массивом коротких целых чисел сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithCharArray() {
        char[] firstArg = {'a', 'b', 'z'};
        double secondArg = 25.546548946;
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), secondArg};
        assertThat("Название метода с массивом символов сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithByteArray() {
        byte[] firstArg = {1, 127, -128};
        char secondArg = 'x';
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), secondArg};
        assertThat("Название метода с массивом байтов сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithBooleanArray() {
        boolean[] firstArg = {true, false, false};
        float secondArg = 0.00005F;
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), secondArg};
        assertThat("Название метода с массивом логических переменных сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithFloatArray() {
        float[] firstArg = {0.1F, 1.002F, 6.45F};
        byte secondArg = 127;
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), secondArg};
        assertThat("Название метода с массивом чисел с плавающей запятой сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithDoubleArray() {
        double[] firstArg = {4.0000006, 0.4, 6.0};
        short secondArg = -5462;
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), secondArg};
        assertThat("Название метода с массивом чисел с плавающей запятой двойной точности сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithoutArray() {
        double firstArg = 0.00000001;
        String secondArg = "second arg";
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, firstArg, secondArg};
        assertThat("Название метода без массивов сформировано неверно", title,
                equalTo(MessageFormat.format("{0} (first arg:{1}, second arg:{2})", args)));
    }

    @Test
    public void getTitleWithEmptyArray() {
        String[] firstArg = new String[0];
        long secondArg = 1000000000000L;
        String title = getTitle(NAME_PATTERN_WITH_TWO_ARGS, METHOD_NAME, new Object[]{firstArg, secondArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg), secondArg};
        assertThat("Название метода с пустым массивом сформировано неверно", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_TWO_ARGS, args)));
    }

    @Test
    public void getTitleWithoutParams() {
        String title = getTitle("{method}", METHOD_NAME, null);
        Object[] args = {METHOD_NAME};
        assertThat("Title without params test", title,
                equalTo(MessageFormat.format("{0}", args)));
    }

    @Test
    public void getTitleWithNullParam() {
        String title = getTitle(NAME_PATTERN_WITH_ONE_ARG, METHOD_NAME, new Object[]{null});
        Object[] args = {METHOD_NAME, null};
        assertThat("Название метода с null-параметром", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_ONE_ARG, args)));
    }

    @Test
    public void getTitleWithNullArgInArrayParam() {
        String[] firstArg = new String[]{null, "something"};
        String title = getTitle(NAME_PATTERN_WITH_ONE_ARG, METHOD_NAME, new Object[]{firstArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg)};
        assertThat("Название метода с массивом, в котором есть null", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_ONE_ARG, args)));
    }

    @Test
    public void getTitleWithArrayOfArrays() {
        Object[] firstArg = new Object[]{new String[]{"a", "b"}, "something", null};
        String title = getTitle(NAME_PATTERN_WITH_ONE_ARG, METHOD_NAME, new Object[]{firstArg});
        Object[] args = {METHOD_NAME, Arrays.toString(firstArg)};
        assertThat("Название метода с массивом массивов, в котором есть null", title,
                equalTo(MessageFormat.format(TITLE_STRING_WITH_ONE_ARG, args)));
    }
}
