import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayStack implements Stack {

    private int data[];
    private boolean isFull = false;
    private int size = 0;


////*** the diagram on https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/ really helped me out writing this code
    private ArrayStack() {}

    public ArrayStack(int length) {
        // homework
        data = new int [length];
        size = 0;
    }
    public int getLength()  {
        return data.length;
    }
    @Override
    public boolean pop() {//remove the value off of the top of the list
        if (size == 0 && size != data.length-1) {
            data[size] = 0;
            return false;
        }
        data[size] = 0;
        if (!isFull) {
            size--;
        }
        isFull = false;

        return true;
    }

    @Override
    public boolean push(int val) {//adds a value on the top

        if (size == data.length - 1 && isFull) {
            return false;
        }else {
            data[size] = val;
            size++;
        }
        if (size == data.length) {
            isFull = true;
            size--;
        }
        return true;
    }

    @Override
    public StackElement peek() {//returns a stack element initialized with data as the value at the top of the stack
        if (size == 0) {
            return new StackElement(data[size], false);
        }else if (size == data.length-1) {
            return new StackElement(data[size-1], true);
        }
        else {
            return new StackElement(data[size-1], true);
        }
    }

    @Override
    public int size() {
        return size;
    }
    public void print() {
        System.out.println(Arrays.toString(data));
    }
    public static void main(String [] args) {
        ArrayStack a = new ArrayStack(3);
        a.push(4);
        a.push(2);
        a.push(6);
        a.pop();
        a.pop();
        a.pop();
        a.print();

    }

}