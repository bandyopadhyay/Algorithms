public class MergeSortedList {


    public static void main (String[] args){

        MergeSortedList a = new MergeSortedList();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(a.mergeTwoLists(l1,l2).val);

        System.out.println(a.mergeTwoLists(l1,l2).next.val);

        System.out.println(a.mergeTwoLists(l1,l2).next.next.val);
        System.out.println(a.mergeTwoLists(l1,l2).next.next.next.val);
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {


        ListNode l3 = new ListNode(0);
        ListNode dummyhead=l3;


        while(l1!=null && l2!=null){
        if(l1.val < l2.val){

            l3.next = new ListNode(l1.val);
            l1=l1.next;
        } else {

            l3.next = new ListNode(l2.val);
            l2=l2.next;

        }
        l3=l3.next;
    }

        while(l1!=null){
        l3.next = new ListNode(l1.val);
        l1=l1.next;
        l3= l3.next;
    }

        while(l2!=null) {
        l3.next = new ListNode(l2.val);
        l2 = l2.next;
        l3 = l3.next;
    }

        return dummyhead.next;
}
}

