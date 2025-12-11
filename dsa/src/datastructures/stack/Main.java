package datastructures.stack;

public class Main {
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
