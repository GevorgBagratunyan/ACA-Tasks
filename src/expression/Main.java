package expression;

import expression.util.OperatorExpression;

public class Main {
    public static void main(String[] args) {
        String exp = "5+3+4";
        OperatorExpression expression = new OperatorExpression(exp);
        double d = expression.calculate();
        System.out.println(d);
    }
}
