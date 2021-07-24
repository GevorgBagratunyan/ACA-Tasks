package expression;

import expression.util.OperatorExpression;

public class Main {
    public static void main(String[] args) {
        String exp = "5+7*8-6*3-8/2+99";
        String exp2 = "5*8/2-3*2/3";
        OperatorExpression expression = new OperatorExpression();
        double d = expression.calculate(exp);
        double d2 = expression.calculate(exp2);
        System.out.println(d);
        System.out.println(d2);
    }
}
