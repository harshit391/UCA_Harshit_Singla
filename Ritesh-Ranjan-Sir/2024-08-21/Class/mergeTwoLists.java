public class mergeTwoLists 
{
	public ListNode mergeTwoListsNoExtraSpace(ListNode list1, ListNode list2) 
    	{
        	ListNode res = ans;

        	if (list1 != null && list2 != null) 
        	{
           	 	if (list1.val < list2.val) 
            		{
                		list1.next = mergeTwoLists(list1.next, list2);
                		return list1;
            		}

            		else
            		{
                		list2.next = mergeTwoLists(list1, list2.next);
                		return list2;
            		}
        	}

      		if (list1 == null)
       		{
        	    return list2;
       		}

        	return list1;
    	}

	public ListNode mergeTwoListsExtraSpace(ListNode list1, ListNode list2)
    	{
        	ListNode i = list1;
       	 	ListNode j = list2;

        	ListNode ans = new ListNode(0);
        	ListNode res = ans;

        	while (i != null && j != null)
        	{
            		if (i.val > j.val)
            		{
                		res.next = new ListNode(j.val);
                		res = res.next;
                		j = j.next;
            		}

            		else
            		{
                		res.next = new ListNode(i.val);
                		res = res.next;
               	 		i = i.next;
            		}
        	}

        	while (i != null)
        	{
            		res.next = new ListNode(i.val);
            		res = res.next;
          	 	i = i.next;
        	}

        	while (j != null)
        	{
            		res.next = new ListNode(j.val);
           	 	res = res.next;
           	 	j = j.next;
        	}

        	return ans.next;
    	}
}
