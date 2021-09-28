package service;
import entity.CustomNumber;
import exceptions.CustomNumberException;
import org.apache.log4j.Logger;

public class Calculation {
    private static final Logger logger = Logger.getLogger(Calculation.class);

    public CustomNumber multiply(CustomNumber num1, CustomNumber num2) {
        double result = num1.getValue() * num2.getValue();
        return CustomNumber.createNumber(result);
    }

    public CustomNumber divide(CustomNumber num1, CustomNumber num2) {
        double result = num1.getValue() / num2.getValue();
        return CustomNumber.createNumber(result);
    }

    public CustomNumber sum(CustomNumber num1, CustomNumber num2) {
        double result = num1.getValue() + num2.getValue();
        return CustomNumber.createNumber(result);
    }

    public CustomNumber subtract(CustomNumber num1, CustomNumber num2) {
        double result = num1.getValue() - num2.getValue();
        return CustomNumber.createNumber(result);
    }
}
