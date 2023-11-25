import java.util.Stack;

public class PrefixToInfixConverter {

        public static String prefixToInfix(String formula) {
            Stack<String> stack = new Stack<>();
            int len = formula.length();

            for (int i = len - 1; i >= 0; i--) {
                char c = formula.charAt(i);

                if (isOperator(c)) {
                    String operand1 = stack.pop();
                    String operand2 = stack.pop();
                    String infixExpression = "(" + operand1 + c + operand2 + ")";
                    stack.push(infixExpression);
                } else {
                    stack.push(String.valueOf(c));
                }
            }

            if (!stack.isEmpty()) {
                return stack.pop();
            } else {
                return "";
            }
        }

        private static boolean isOperator(char c) {
            return c == '+' || c == '-' || c == '*' || c == '/';
        }

        public static void main(String[] args) {
            System.out.println(prefixToInfix("+*342"));  // ((3*4)+2)
            System.out.println(prefixToInfix("/+*3422")); // (((3*4)+2)/2)
            System.out.println(prefixToInfix("+-*+-*+-*1234567891")); // (((((((((1*2)-3)+4)*5)-6)+7)*8)-9)+1)
        }
    }