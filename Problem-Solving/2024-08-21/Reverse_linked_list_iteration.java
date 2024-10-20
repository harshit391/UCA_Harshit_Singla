class Solution 
{
    public ListNode reverseList(ListNode head) 
    {
        ListNode curr = head, prev = null, node = head;

        while (curr != null)
        {
            node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }    

        return prev;
    }
}
