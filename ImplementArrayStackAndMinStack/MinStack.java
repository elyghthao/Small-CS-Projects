import java.lang.reflect.Array;

public class MinStack extends ArrayStack {

    private int minValue = Integer.MAX_VALUE;
    private ArrayStack small;



//First i supered some methods that i know i would still using such as the constructor, push() and pop()
    //next i decided to create a whole new arraystack object in this class to keep track of the minimum value as values were added
    //as such if the value was also popped, the value would also pop in the array stack object created
    //in the getMin() method i just returned the latest minimum value, and if there wasnt one, then it just returned -1 along with false

    public MinStack(int size) {
        super(size);
        small = new ArrayStack(size);
    }

    public StackElement getMin() {//looks at the top value of the small arraystack object to get the minimum value
        if (size() == 0 && getLength() == 1) {
            return new StackElement(small.peek().getData(),true);
        }else if (size() == 0) {
            return new StackElement(-1,false);
        }else {
             return new StackElement(small.peek().getData(),true);
        }
    }

    @Override
    public boolean push(int val) {//reused push() but added a way to check if value was smaller and add it to an arraystack object
        if (size() == 0) {
            System.out.println("work");
            small.push(val);
        }
        if (val < small.peek().getData()) {
            small.push(val);
            System.out.println("small value has been pushed");
        }
        return super.push(val);
    }

    @Override
    public boolean pop() {//reused pop(), but added a way to check if value that got pop was in the array stack object,
                                //if it was, it got popped in that array stack object too
        if (size() == small.size() ) {
            small.pop();
        }
        return super.pop();
    }

}
