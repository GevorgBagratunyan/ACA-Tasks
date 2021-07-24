package expression.util;

public class OperatorExpression implements Expression {

    private Expression left, right;
    private char operator;
    private String expression;

    public OperatorExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public double calculate(){
        int index = indexOfOperator(expression); // index==0 only when operator is '-'
        if (index==-1){
            return Double.parseDouble(expression);
        }  else operator = expression.charAt(index);

        String l = expression.substring(0, index);
        String r;
        if(operator=='-'){
            r = expression.substring(index);
        } else {
            r = expression.substring(index+1);
        }

        left = new OperatorExpression(l);
        right = new OperatorExpression(r);
        return applyOp(left.calculate(), right.calculate(), operator);
    }

    public int indexOfOperator(String expression) {

        if (expression.indexOf("+")>0) {
            return expression.indexOf("+");
        } else if(expression.indexOf("-")==0 && expression.indexOf("-",1)>0){
            return expression.indexOf("-",1);
        } else if (expression.indexOf("-")>0) {
            return expression.indexOf("-");
        } else if (expression.indexOf("/")>0) {
            return expression.indexOf("/");
        } else if (expression.indexOf("*")>0) {
            return expression.indexOf("*");
        }else return -1;
    }

    private double applyOp(double a, double b, char op) {
        switch (op) {
            case '+':
            case '-':
                return a + b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("wrong type of operation character");
        }
    }
}
