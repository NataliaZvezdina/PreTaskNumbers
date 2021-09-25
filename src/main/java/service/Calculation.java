package service;

import entity.CustomNumber;
import org.apache.log4j.Logger;
import utils.CustomFileReader;

public class Calculation {

    private static final Logger logger = Logger.getLogger(Calculation.class);

    public static CustomNumber multiply(CustomNumber num1, CustomNumber num2) {
        double result = num1.getValue() * num2.getValue();
        return CustomNumber.createNumber(result);
    }

    public static CustomNumber divide(CustomNumber num1, CustomNumber num2) {
        if (num2.getValue() == 0)  {
            logger.error("Division by 0");
            throw new ArithmeticException("Division by 0");
        }
        double result = num1.getValue() / num2.getValue();
        return CustomNumber.createNumber(result);
    }

    public static CustomNumber sum(CustomNumber num1, CustomNumber num2) {
        double result = num1.getValue() + num2.getValue();
        return CustomNumber.createNumber(result);
    }

    public static CustomNumber subtract(CustomNumber num1, CustomNumber num2) {
        double result = num1.getValue() - num2.getValue();
        return CustomNumber.createNumber(result);
    }
}
