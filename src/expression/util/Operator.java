package expression.util;

public enum Operator {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/');

    private final char operator;

    Operator(char operator) {
        this.operator = operator;
    }

    public char getOperator() {
        return operator;
    }

}
