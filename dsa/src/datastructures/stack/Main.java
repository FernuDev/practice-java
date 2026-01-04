package datastructures.stack;

public class Main {

    public static boolean isBalancedParentheses(String str) {
        if (str.isEmpty()) return true;

        StackArrayList<Character> stack = new StackArrayList<>();

        for (char c : str.toCharArray()) {
            if ( c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack myStack = new Stack(4);

        myStack.getTop();
        myStack.getHeight();

        myStack.printStack();

        System.out.println("Apply push method: \n");
        myStack.push(5);
        myStack.push(10);

        myStack.printStack();
    }
}
