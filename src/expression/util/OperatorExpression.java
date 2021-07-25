package expression.util;

public class OperatorExpression implements Expression {

    private Expression left;
    private Expression right;
    private Operator operator;
    private String expression;

    public OperatorExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public double calculate() {
        int index = indexOfOperator(expression);
        if (index == -1) {
            return Double.parseDouble(expression);
        } else operator = initOperator(expression.charAt(index));


        String l = expression.substring(0, index);
        String r;
        if (operator == Operator.SUBTRACTION) {
            r = expression.substring(index); //parsing right substring with '-' operator.
        } else {
            r = expression.substring(index + 1); //parsing right substring without operator.
        }

        left = new OperatorExpression(l);
        right = new OperatorExpression(r);
        return evaluate(left.calculate(), right.calculate(), operator);
    }

    public int indexOfOperator(String expression) {

        if (expression.indexOf(Operator.ADDITION.getOperator()) != -1) {
            return expression.indexOf(Operator.ADDITION.getOperator());
        } else if (expression.indexOf(Operator.SUBTRACTION.getOperator()) == 0
                && expression.indexOf("-", 1) > 0) {
            return expression.indexOf(Operator.SUBTRACTION.getOperator(), 1);
        } else if (expression.indexOf(Operator.SUBTRACTION.getOperator()) > 0) {
            return expression.indexOf(Operator.SUBTRACTION.getOperator());
        } else if (expression.indexOf(Operator.DIVISION.getOperator()) != -1) {
            return expression.indexOf(Operator.DIVISION.getOperator());
        } else if (expression.indexOf(Operator.MULTIPLICATION.getOperator()) != -1) {
            return expression.indexOf(Operator.MULTIPLICATION.getOperator());
        } else return -1;
    }

    private double evaluate(double a, double b, Operator op) {
        switch (op) {
            case ADDITION:
            case SUBTRACTION:
                return a + b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                return a / b;
            default:
                throw new IllegalArgumentException("wrong type of operator");
        }
    }

    private Operator initOperator(char c) {
        switch (c) {
            case '+':
                return Operator.ADDITION;
            case '-':
                return Operator.SUBTRACTION;
            case '*':
                return Operator.MULTIPLICATION;
            case '/':
                return Operator.DIVISION;
            default:
                throw new IllegalArgumentException("wrong type of operator");
        }
    }
}
