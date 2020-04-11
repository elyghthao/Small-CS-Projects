import java.util.Arrays;

public class MaxHeap implements Heap {
    int size;

    Integer[] data;

    public MaxHeap(int capacity) {
        data = new Integer[capacity];
        size = 0;
    }

    // build a heap based on data
    // to be implemented in O(nlogn)
    public void MaxHeapLogN(Integer[] data) {//uses add function
        // homework
        for (int i = 0; i<data.length;i++) {
            if (data[i] != null) {
                this.add(data[i]);
            }
        }
    }

    // build a heap based on data
    // to be implemented in O(n)
    public void MaxHeapN(Integer[] data) {//uses array
        // homework
        int swapValue;
        for (int i = data.length - 1; i > 0; i--) {
            if (i % 2 != 0) {//odd
                if (data[i] > data[(i - 1) / 2]) {
                    swapValue = data[i];
                    data[i] = data[(i - 1) / 2];
                    data[(i - 1) / 2] = swapValue;
                    if ((i * 2 + 1) < data.length) {
                        i = (i * 2) + 2;
                    }
                }
            } else {//even
                if (data[i] > data[(i - 2) / 2]) {
                    swapValue = data[i];
                    data[i] = data[(i - 2) / 2];
                    data[(i - 2) / 2] = swapValue;
                    if ((i * 2 + 2) < data.length) {
                        i = (i * 2) + 3;
                    }
                }
            }
        }
        this.data = data;//this line works
    }

    // add an item to the heap
    public boolean add(Integer item) {
        // homework
        int swapValue;
        int currentIndex = 0;
        for (int i =0 ;i<data.length;i++ ) {//this adds the value to the end
            if (data[i] == null) {
                data[i]=item;
                currentIndex = i;
                break;
            }
            if (i==data.length-1 && data[i] != null) {
                return false;
            }
        }
        if (currentIndex !=0) {
            if (currentIndex % 2 != 0) {//odd
                while (data[currentIndex] > data[(currentIndex - 1) / 2]) {
                    swapValue = data[currentIndex];
                    data[currentIndex] = data[(currentIndex - 1) / 2];
                    data[(currentIndex - 1) / 2] = swapValue;
                    currentIndex = (currentIndex - 1) / 2;
                    if (currentIndex ==0) {
                        break;
                    }
                }
            } else {//even
                while (data[currentIndex] > data[(currentIndex - 2) / 2]) {
                    swapValue = data[currentIndex];
                    data[currentIndex] = data[(currentIndex - 2) / 2];
                    data[(currentIndex - 2) / 2] = swapValue;
                    currentIndex = (currentIndex - 2) / 2;
                    if (currentIndex ==0) {
                        break;
                    }
                }
            }
        }


        return true;
    }

    // return the max item in the heap
    public Integer get() {
        // homework
        return data[0];
    }

    // remove the root item
    public Integer pop() {
        // homework
        int value = this.get();

        for (int i = 0;i<data.length;i++) {
            if(data[i] == null) {
                break;
            }
            if(i==data.length-1) {
                data[i] = null;
                break;
            }
            data[i]=data[i+1];
        }
        MaxHeap temporary = new MaxHeap(data.length);
        temporary.MaxHeapLogN(this.data);
        this.data=temporary.data;
        return value;
    }
}
