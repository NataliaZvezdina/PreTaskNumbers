package utils;

import exceptions.CustomNumberException;
import org.apache.log4j.Logger;

import java.util.List;

public class CustomNumbersValidator {

    private static final Logger logger = Logger.getLogger(CustomNumbersValidator.class);

    public void areNumbersValid(List<String> stringNumbers) throws CustomNumberException {
        logger.info("Checking data on validation");

        if (stringNumbers == null) {
            logger.error("No numbers found");
            throw new CustomNumberException("No numbers found");
        }

        if (stringNumbers.size() != 2) {
            logger.error("Quantity of numbers is not two");
            throw new CustomNumberException("Quantity of numbers is not two");
        }

        for (String stringNumber : stringNumbers) {
            if (!stringNumber.matches("[0-9]+[\\.]?[0-9]*")) {
                logger.error("File contain non-numeric value");
                throw new CustomNumberException("File contain non-numeric value");
            }
        }
    }

}
