package entity;

import java.util.Objects;

public class CustomNumber {

    private double value;

    public CustomNumber(Double value) {
        this.value = value;
    }

    public static CustomNumber createNumber(double value) {
        return new CustomNumber(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomNumber that = (CustomNumber) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "CustomNumber{" +
                "value=" + value +
                '}';
    }
}
