import java.util.ArrayList;

public class LinkedListStack<T> {

    private MyListNode head;
    private int count = 0;

    private class MyListNode<T> {

        private String value;
        private MyListNode<T> next;

        public MyListNode(String value, MyListNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public MyListNode(String value) {
            this(value, null);
        }

        public MyListNode() {
            this(null);
        }
    }

    public void push(String value) {
        MyListNode newList = new MyListNode();
        newList.value = value;
        if (!this.isEmpty()) {
             newList.next = head;
        } 
        head = newList;
        count++;
    }

    public String pop() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("The list is empty!");
        } else {
            MyListNode extra = head;
            head = head.next;
            count--;
            return extra.value;
        }
    }

    public String toString() {
        MyListNode listElement = head;
        StringBuilder sb = new StringBuilder("[  " + listElement.value + "   ");
        while ((listElement = listElement.next) != null) {
            sb.append(listElement.value + "   ");
        }
        sb.append("]");
        return sb.toString();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return count;
    }

    public String peek() {
        return head.value;
    }
    
    
    static void insertAtBottom(LinkedListStack stack, String value) throws Exception {
        if (stack.isEmpty()) {
            stack.push(value);
        } else {
            String a = stack.peek();
            stack.pop();
            insertAtBottom(stack, value);
            stack.push(a);
        }
    }

    static void reverse(LinkedListStack stack) throws Exception {
        if (stack.getSize() > 0) {
            String value = stack.pop();
            reverse(stack);
            insertAtBottom(stack, value);
        }
    }

    static void reverse1(LinkedListStack stack) throws Exception {
        LinkedListStack stack1 = new LinkedListStack();
        LinkedListStack stack2 = new LinkedListStack();

        while (stack.getSize() > 0) {
            stack1.push(stack.pop());
        }
        while (stack1.getSize() > 0) {
            stack2.push((stack1.pop()));
        }
        while (stack2.getSize() > 0) {
            stack.push((stack2.pop()));
        }
    }

}
