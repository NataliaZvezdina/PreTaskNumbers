package application;

import entity.CustomNumber;
import exceptions.CustomNumberException;
import org.apache.log4j.Logger;
import service.Calculation;
import utils.CustomFileReader;
import utils.CustomNumbersValidator;
import utils.StringParser;
import java.util.List;

public class ApplicationRunner {
    private static final Logger logger = Logger.getLogger(ApplicationRunner.class);
    private static final String FILE_PATH = "C:/Users/natal/IdeaProjects/PreTaskNumbers/src/main/resources/example.txt";

    public static void main(String[] args) {
        try {
            CustomFileReader reader = new CustomFileReader();
            List<String> stringNumbers = reader.readFile(FILE_PATH);

            CustomNumbersValidator validator = new CustomNumbersValidator();
            validator.areNumbersValid(stringNumbers);

            StringParser parser = new StringParser();
            double[] validNumbers = parser.parse(stringNumbers);

            CustomNumber customNumber1 = CustomNumber.createNumber(validNumbers[0]);
            CustomNumber customNumber2 = CustomNumber.createNumber(validNumbers[1]);

            Calculation calculation = new Calculation();
            calculation.sum(customNumber1, customNumber2);
            calculation.subtract(customNumber1, customNumber2);
            calculation.multiply(customNumber1, customNumber2);

        } catch (CustomNumberException e) {
            logger.error(e.getMessage());
        } finally {
            logger.info("Application finished");
        }
    }
}
