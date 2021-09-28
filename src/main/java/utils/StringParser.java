package utils;
import org.apache.log4j.Logger;
import java.util.List;

public class StringParser {
    private static final Logger logger = Logger.getLogger(StringParser.class);

    public double[] parse(List<String> stringNumbers) {
        logger.info("Parsing numbers");

        double num1 = Double.parseDouble(stringNumbers.get(0));
        double num2 = Double.parseDouble(stringNumbers.get(1));

        return new double[]{num1, num2};
    }
}
