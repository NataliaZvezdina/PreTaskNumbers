package utils;

import exceptions.CustomNumberException;
import org.apache.log4j.Logger;

import java.util.List;

public class CustomNumbersValidator {

    private static final Logger logger = Logger.getLogger(CustomNumbersValidator.class);
    //private static final String DELIMITER = "\\d\\s+";

    public static boolean areNumbersValid(List<String> stringNumbers) throws CustomNumberException {
        if (stringNumbers == null) {
            logger.error("No numbers found");
            throw new CustomNumberException("No numbers found");
        }

        if (stringNumbers.size() != 2) {
            logger.error("More than two numbers");
            throw new CustomNumberException("More than two numbers");
        }

        for (String stringNumber : stringNumbers) {
            if (!stringNumber.matches("[0-9]+[\\.]?[0-9]*")) {
                return false;
            }
        }
        return true;
    }

}
