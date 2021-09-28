import entity.CustomNumber;
import exceptions.CustomNumberException;
import org.junit.Test;
import service.Calculation;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculationTest {

    @Test
    public void testSum() {
        // given
        Calculation calculation = new Calculation();
        CustomNumber num1 = CustomNumber.createNumber(10);
        CustomNumber num2 = CustomNumber.createNumber(2.5);
        CustomNumber expected = CustomNumber.createNumber(10 + 2.5);

        // when
        CustomNumber result = calculation.sum(num1, num2);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testSubtract() {
        // given
        Calculation calculation = new Calculation();
        CustomNumber num1 = CustomNumber.createNumber(10);
        CustomNumber num2 = CustomNumber.createNumber(2.5);
        CustomNumber expected = CustomNumber.createNumber(10 - 2.5);

        // when
        CustomNumber result = calculation.subtract(num1, num2);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testMultiply() {
        // given
        Calculation calculation = new Calculation();
        CustomNumber num1 = CustomNumber.createNumber(10);
        CustomNumber num2 = CustomNumber.createNumber(2.5);
        CustomNumber expected = CustomNumber.createNumber(10 * 2.5);

        // when
        CustomNumber result = calculation.multiply(num1, num2);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testDivide() throws CustomNumberException {
        // given
        Calculation calculation = new Calculation();
        CustomNumber num1 = CustomNumber.createNumber(10);
        CustomNumber num2 = CustomNumber.createNumber(2.5);
        CustomNumber expected = CustomNumber.createNumber(10 / 2.5);

        // when
        CustomNumber result = calculation.divide(num1, num2);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void testDivide_whenDenominatorEqualsZero() throws CustomNumberException {
        // given
        Calculation calculation = new Calculation();
        CustomNumber num1 = CustomNumber.createNumber(10);
        CustomNumber num2 = CustomNumber.createNumber(0);
        CustomNumber expected = CustomNumber.createNumber(10.0 / 0);

        // when
        CustomNumber result = calculation.divide(num1, num2);

        //then
        assertThat(result).isEqualTo(expected);
    }
}
