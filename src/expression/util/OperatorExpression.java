package expression.util;

public class OperatorExpression implements Expression {

    private Expression left, right;
    private char operator;
    private String expression;

    public OperatorExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public double calculate() {
        if (expression.matches("[0-9]+"))
            return Double.parseDouble(expression);
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/') {
                operator = expression.charAt(i);
                String l = expression.substring(0, i);
                String r = expression.substring(i + 1);
                left = new ValueExpression(l);
                right = new OperatorExpression(r);
                return applyOp(left.calculate(), right.calculate(), operator);
            }
        }
        return 0;
    }

    private double applyOp(double a, double b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("wrong type of operation character");
        }
    }
}
