import exceptions.CustomNumberException;
import org.junit.Test;
import utils.CustomNumbersValidator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class CustomNumbersValidatorTest {

    @Test
    public void testAreNumbersValid_whenListNull_thenThrowCustomNumberException() {
        // given
        CustomNumbersValidator validator = new CustomNumbersValidator();
        List<String> stringNumbers = null;

        // when
        Throwable thrown = catchThrowable(() -> validator.areNumbersValid(stringNumbers));
        //then
        assertThat(thrown).isInstanceOf(CustomNumberException.class);
    }

    @Test
    public void testAreNumbersValid_whenListSizeNotEqualTwo_thenThrowCustomNumberException() {
        // given
        CustomNumbersValidator validator = new CustomNumbersValidator();
        List<String> stringNumbers = new ArrayList<>();
        stringNumbers.add("45");
        stringNumbers.add("-3.5");
        stringNumbers.add("zzzzzzz");

        // when
        Throwable thrown = catchThrowable(() -> validator.areNumbersValid(stringNumbers));

        //then
        assertThat(stringNumbers).size().isNotEqualTo(2);
        assertThat(thrown).isInstanceOf(CustomNumberException.class);
    }

    @Test
    public void testAreNumbersValid_whenListContainsNonNumericValue_thenThrowCustomNumberException() {
        // given
        CustomNumbersValidator validator = new CustomNumbersValidator();
        List<String> stringNumbers = new ArrayList<>();
        stringNumbers.add("45");
        stringNumbers.add("zzzzzzz");

        // when
        Throwable thrown = catchThrowable(() -> validator.areNumbersValid(stringNumbers));

        //then
        assertThat(thrown).isInstanceOf(CustomNumberException.class);
    }
}
