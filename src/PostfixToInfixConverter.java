import java.util.Stack;

public class PostfixToInfixConverter {
    public static void postfixToInfix(String formula) {
        Stack<String> stack = new Stack<>();
        String[] tokens = formula.split("");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (isOperator(token)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String infixExpression = "(" + operand1 + token + operand2 + ")";
                stack.push(infixExpression);
            } else {
                stack.push(token);
            }
        }

        if (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static void main(String[] args) {
        postfixToInfix("34*2+");  // ((3*4)+2)
        postfixToInfix("34+22*/"); // (((3*4)+2)/2)
        postfixToInfix("1234567891+-*+-*+-*"); // (1*(2-(3+(4*(5-(6+(7*(8-(9+1))))))))
    }
}
