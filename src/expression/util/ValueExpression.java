package expression.util;

public class ValueExpression implements Expression {

    private double value;
    private String expression;

    public ValueExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public double calculate() {
        double d = Double.parseDouble(expression);
        value +=d;
        return d;
    }

    public double getValue() {
        return value;
    }
}
