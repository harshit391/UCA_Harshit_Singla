public class reverseLL
{
	
	public ListNode reverseListRecursive(ListNode head) 
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

	public ListNode reverseListNormal(ListNode head)
	{
		if (head == null || head.next == null) 
		{
			return head;
		}	

		ListNode curr = head, prev = null, node = null;

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
