package pro.sky.skyprochikinsergeycalculator;

import org.springframework.stereotype.Service;

@Service

public class CalculatorService {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public double division(double num1, double num2) {
        return num1 / num2;
    }
}
