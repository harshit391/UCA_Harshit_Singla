public ListNode reverseListRec(ListNode head) 
{
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode curr = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return curr;
}

public ListNode reverseListIte(ListNode head)
{
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode prev = null, curr = head, node = head;

        while (curr != null)
        {
            node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }

        return prev;
}
