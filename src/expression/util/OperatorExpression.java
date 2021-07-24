package expression.util;

public class OperatorExpression implements Expression {

    private Expression left, right;
    private char operator;

    @Override
    public double calculate(String expression) {
        int index = indexOfOperator(expression);
        if (index == -1) {
            return Double.parseDouble(expression);
        } else operator = expression.charAt(index);

        String l = expression.substring(0, index);
        String r;
        if (operator == '-') {
            r = expression.substring(index); //parsing right substring with '-' operator
        } else {
            r = expression.substring(index + 1); //parsing right substring without operator
        }

        left = new OperatorExpression();
        right = new OperatorExpression();
        return evaluate(left.calculate(l), right.calculate(r), operator);
    }

    public int indexOfOperator(String expression) {

        if (expression.indexOf("+") != -1) {
            return expression.indexOf("+");
        } else if (expression.indexOf("-") == 0 && expression.indexOf("-", 1) > 0) {
            return expression.indexOf("-", 1);
        } else if (expression.indexOf("-") > 0) {
            return expression.indexOf("-");
        } else if (expression.indexOf("/") != -1) {
            return expression.indexOf("/");
        } else if (expression.indexOf("*") != -1) {
            return expression.indexOf("*");
        } else return -1;
    }

    private double evaluate(double a, double b, char op) {
        switch (op) {
            case '+':
            case '-':
                return a + b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("wrong type of operator");
        }
    }
}
