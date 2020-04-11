public class ListNode {
    // see https://www.geeksforgeeks.org/access-modifiers-java/ for default access modifier
    int val;
    ListNode next;

    public ListNode() {
        next = null;
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}