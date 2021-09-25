package application;

import entity.CustomNumber;
import exceptions.CustomNumberException;
import org.apache.log4j.Logger;
import service.Calculation;
import utils.CustomFileReader;
import utils.CustomNumbersValidator;
import utils.StringParser;


import java.util.Arrays;
import java.util.List;

public class ApplicationRunner {
    private static final Logger logger = Logger.getLogger(ApplicationRunner.class);
    private static final String FILE_PATH = "C:/Users/natal/IdeaProjects/PreTaskNumbers/src/main/resources/example.txt";

    public static void main(String[] args) {

        try {

            List<String> stringNumbers = CustomFileReader.readFile(FILE_PATH);
            stringNumbers.forEach(System.out::println);
            boolean check = CustomNumbersValidator.areNumbersValid(stringNumbers);
            System.out.println(check);

            System.out.println("-------");
            double[] validNumbers = StringParser.parse(stringNumbers);
            CustomNumber customNumber1 = CustomNumber.createNumber(validNumbers[0]);
            CustomNumber customNumber2 = CustomNumber.createNumber(validNumbers[1]);

            System.out.println(Calculation.divide(customNumber1, customNumber2));

        } catch (ArithmeticException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error("Unrecognized error: " + Arrays.toString(e.getStackTrace()));
        } finally {
            logger.info("Application finished");
        }

    }
}
