import org.junit.Test;
import utils.StringParser;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class StringParserTest {

    @Test
    public void testParse() {
        // given
        StringParser parser = new StringParser();
        List<String> stringNumbers = new ArrayList<>();
        stringNumbers.add("22");
        stringNumbers.add("22.55");
        double[] expected = {22, 22.55};

        // when
        double[] result = parser.parse(stringNumbers);

        //then
        assertThat(result).containsExactly(expected);
    }
}
