package expression.util;

//in case of evaluating expressions with '/' & '*' operators, this class is unnecessary
public class ValueExpression implements Expression {

    private double value;

    @Override
    public double calculate() {
        return 0;
    }

}
