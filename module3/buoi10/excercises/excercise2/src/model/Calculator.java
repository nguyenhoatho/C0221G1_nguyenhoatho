package model;

public class Calculator {
    private float firstOperand;
    private float secondOperand;
    private char operator;

    public Calculator() {
    }

    public Calculator(float firstOperand, float secondOperand, char operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    public float getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(float firstOperand) {
        this.firstOperand = firstOperand;
    }

    public float getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(float secondOperand) {
        this.secondOperand = secondOperand;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "firstOperand=" + firstOperand +
                ", secondOperand=" + secondOperand +
                ", operator=" + operator +
                '}';
    }

    public static float calculate(float first, float second, char operators) {
        switch (operators) {
            case '+':
                return (first + second);
            case '-':
                return (first - second);
            case '*':
                return (first * second);
            case '/':
                if (second == 0) {
                    throw new RuntimeException("Can't divide");
                } else {
                    return (first / second);
                }
            default:
                throw new RuntimeException("Error");
        }
    }
}
