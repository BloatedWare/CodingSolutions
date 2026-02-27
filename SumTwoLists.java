
public class SumTwoLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);//we init the first sum node with 0
        ListNode s = sum;//will use s to traverse
        int carry = 0;
        int temp;

        while (true) {
            temp = s.val;
            if(l1 != null) {
                temp += l1.val;//0 + l1->Val = l1->Val
                l1 = l1.next;//go to reference of next ListNode
            }

            if(l2 != null) {
                temp += l2.val;//s->Val = s->Val + l2->Val
                l2 =l2.next; //l2=l2->next; to move to next
            }


            carry = temp / 10;
            s.val = temp %10;

            
            if (l1 == null && l2 == null) {
                if(carry > 0) {
                    s.next = new ListNode(carry);
                }
                break;//exit the loop
            }
            s.next = new ListNode(carry);
            s = s.next;

        }
        return sum;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}