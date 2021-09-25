package utils;
import exceptions.CustomNumberException;
import org.apache.log4j.Logger;

import java.util.List;

public class StringParser {
    private static final Logger logger = Logger.getLogger(StringParser.class);
    private static final String DELIMITER = "\\d\\s+";

    private StringParser() {}

    public static double[] parse(List<String> stringNumbers) throws CustomNumberException {
//        if (!CustomNumbersValidator.areNumbersValid(stringNumbers)) {
//            logger.error("Cannot parse, not numeric value exist");
//            throw new CustomNumberException("Cannot parse, not numeric value exist");
//        }

        double num1 = Double.parseDouble(stringNumbers.get(0));
        double num2 = Double.parseDouble(stringNumbers.get(1));

        return new double[]{num1, num2};
    }
}
