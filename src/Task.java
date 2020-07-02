import java.util.Stack;

public class Task {

    public static void main(String[] args) throws Exception {
         LinkedListStack stack = new LinkedListStack();


        stack.push("Лера");
        stack.push("Аня");
        stack.push("Настя");
        stack.push("Лика");
        stack.push("Уля");
        System.out.println("Original Stack by me:");
        System.out.println(stack.toString());
        LinkedListStack.reverse1(stack);
        System.out.println("Reversed Stack by me:");
        System.out.println(stack.toString());

        
        Stack<String> stackCheack = new Stack<>();
        stackCheack.push("a");
        stackCheack.push("b");
        stackCheack.push("c");
        stackCheack.push("d");
        stackCheack.push("e");
        stackCheack.push("g");

        System.out.println("Original Stack :");
        System.out.println(stackCheack);
        turnOver(stackCheack);
        System.out.println("Reversed Stack :");
        System.out.println(stackCheack);

    }

    static void insertInTheEnd(Stack<String> stackCheack, String value) {

        if (stackCheack.isEmpty()) {
            stackCheack.push(value);
        } else {
            String a = stackCheack.peek();
            stackCheack.pop();
            insertInTheEnd(stackCheack, value);
            stackCheack.push(a);
        }
    }

    static void turnOver(Stack<String> stackCheack) {
        if (stackCheack.size() > 0) {
            String value = stackCheack.peek();
            stackCheack.pop();
            turnOver(stackCheack);
            insertInTheEnd(stackCheack, value);
        }
    }
}
