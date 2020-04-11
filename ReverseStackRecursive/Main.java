import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // left empty
    }

     void ReverseStack(Stack<Integer> stack) {
        // homework
        if (stack.isEmpty()) {
            return;
        }
        ReverseStack(stack, stack.size()-2);

    }
    private void ReverseStack(Stack<Integer> stack, int n) {
        if (n>-1) {
            stack.add(stack.get(n));
            stack.remove(n);
            ReverseStack(stack,n-1);
        }
    }
}