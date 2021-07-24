package expression;

import expression.util.OperatorExpression;

public class Main {
    public static void main(String[] args) {
        String exp = "5+7*8-6*3-8+99";
        OperatorExpression expression = new OperatorExpression(exp);
        double d = expression.calculate();
        System.out.println(d);
    }
}
