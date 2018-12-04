import bean.ListNode;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = 0, lB = 0;
        ListNode nodeA, nodeB;
        for (nodeA = headA; nodeA != null; lA++) nodeA = nodeA.next;
        for (nodeB = headB; nodeB != null; lB++) nodeB = nodeB.next;
        int gap = Math.abs(lA - lB);
        nodeA = lA >= lB ? headA : headB;
        nodeB = lA >= lB ? headB : headA;
        while (gap-- != 0) nodeA = nodeA.next;
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(0);
        ListNode headC = new ListNode(0);
        headC.addNext(0).addNext(0);
        //headA.addNext(0).addNext(headC);
        headB.addNext(0).addNext(0).addNext(headC);
        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headB));
        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(headB, headA));
        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(headA, headC));
        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(headB, headC));
    }
}
