package expression;

import expression.util.OperatorExpression;

public class Main {
    public static void main(String[] args) {
        String exp1 = "5+7*8-6*3-8/2+99";
        String exp2 = "5*8/2-3*2/3";
        OperatorExpression expression1= new OperatorExpression(exp1);
        OperatorExpression expression2 = new OperatorExpression(exp2);
        double d = expression1.calculate();
        double d2 = expression2.calculate();
        System.out.println(d);
        System.out.println(d2);
    }
}
