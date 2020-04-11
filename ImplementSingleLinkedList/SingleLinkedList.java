public class SingleLinkedList {

    private ListNode head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    public SingleLinkedList(SingleLinkedList list) {
        // homework
//        this.head = list.head;
//        this.size = list.size;
        head=new ListNode();
        ListNode currentNode = list.head.next;
        if (currentNode == null) {
            this.head = null;
            return;
        }
        while(currentNode != null) {
            this.add(currentNode.val);
            currentNode = currentNode.next;
        }

    }
    public SingleLinkedList(int[] data){
        ListNode ptr = null;
        for(int i = 0; i < data.length; i++) {
            ListNode newNode = new ListNode(data[i]);
            if(head == null) {
                head = newNode;
                ptr=head;
                continue;
            }
            ptr.next = newNode;
            ptr = ptr.next;
        }
    }

    public Item getLast() {
        if (head==null) {
            return null;
        }
        ListNode ptr = head;
        while(ptr.next != null) {
            ptr=ptr.next;
        }
        return new Item(ptr.val,true);
    }

    public int remove(int valueToRemove) {
        // homework
        ListNode p1 = head;
        ListNode p2 = head.next;
        int count = 0;

        while (p2.next != null) {
            if (p2.val != valueToRemove) {
                p1 = p2;
                p2 = p2.next;
            }
            while (p2.val == valueToRemove) {
                count++;
                size--;
                p2 = p2.next;
                if (p2 != null) {
                    p1.next = p2;
                } else {
                    p1.next = null;
                    if (p1.val == valueToRemove) {
                        count++;
                        size--;
                        head.next = null;
                    }
                    return count;
                }
            }

        }


        return count; // place holder
    }

    public void reverseIterative() {
        // homework
        ListNode p1 = null;
        ListNode p2 = head.next;
        ListNode p3 = null;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = p1;
    }

    public void mergeSorted(SingleLinkedList listToMerge) {
        // homework
        ListNode a = head.next;
        ListNode list = listToMerge.head.next;

        ListNode p1 = head.next;
        ListNode p2 = p1.next;

        ListNode p3 = head;
        ListNode p4 = p3.next;

        if (listToMerge.size < 1) {
            return;
        }
        while (list !=  null) {//add the values to the new code
            add(list.val);
            list = list.next;
        }

        while(p1 != null) {
            while (p2 != null) {
                if (p3.val > p4.val) {
                    int hi = p3.val  ;
                    p3.val = p4.val;
                    p4.val = hi;
                    p2 = p2.next;
                    p4 = p4.next;
                }else {
                    p2 = p2.next;
                    p3 = p3.next;
                    p4 = p4.next;
                }

            }
            p3=head;
            p4 = p3.next;
            p2 = head.next;
            p1 = p1.next;
        }





//        while(list != null) {
//            ex = list.val;
//            while (a != null) {
//
//
//                a = a.next;
//            }
//            list = list.next;
//        }




//        while (list.next != null) {
//            ex = list.val;
//            while (a.next != null) {
//                if (ex > a.val) {
//                    ListNode hi = new ListNode(ex);
//                    hi.next = a.next;
//                    a.next = hi;
//                }else if (ex <= a.val) {
//
//                }
//
//                a = a.next;
//            }
//            list = list.next;
//        }






    }

    int size() {
        return size;
    }

    public Item getFirst() {
        return get(0);
    }

//    public Item getLast() {
//        return get(size - 1);
//    }

    // Returns the element at the specified position in this list
    public Item get(int index) {
        if (index < 0 || index >= size) {
            return new Item(-1, false);
        }
        ListNode ptr = head.next;
        for (int i = 0; i < index; i++) {
            if (ptr == null) {
                return new Item(-1, false);
            }
            ptr = ptr.next;
        }
        return new Item(ptr.val, true);
    }

    // Appends the specified element to the end of this list
    public void add(int val) {
        size++;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(val);
    }

    // Inserts the specified element at the beginning of this list
    public void addFirst(int val) {
        size++;
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
    }

    // Removes and returns the first element from this list
    public void removeFirst() {
        if (head.next == null) {
            return;
        }
        head.next = head.next.next;
        size--;
    }

    // Removes and returns the last element from this list
    public void removeLast() {
        if (head.next == null) {
            return;
        }
        size--;

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2.next != null) {
            p1 = p2;
            p2 = p2.next;
        }
        p1.next = null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        do {
            builder.append(ptr.val + (ptr.next == null ? " -> end " : " -> "));
            ptr = ptr.next;
        } while (ptr != null);

        return builder.toString();
    }
}
