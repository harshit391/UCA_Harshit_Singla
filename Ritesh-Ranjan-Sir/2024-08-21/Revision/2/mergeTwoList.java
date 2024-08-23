public ListNode mergeTwoListsRec(ListNode list1, ListNode list2) 
{	
	if (list1 != null && list2 != null) 
        {
            if (list1.val > list2.val)
            {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }

            else
            {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }
        }

        if (list1 == null)
        {
            return list2;
        }

        return list1;
}

public ListNode mergeTwoListsIte(ListNode list1, ListNode list2) 
{
        ListNode ans = new ListNode(0);
        ListNode temp = ans;

        while (list1 != null && list2 != null)
        {
            if (list1.val > list2.val)
            {
                temp.next = new ListNode(list2.val);
                temp = temp.next;
                list2 = list2.next;
            }
            else
            {
                temp.next = new ListNode(list1.val);
                temp = temp.next;
                list1 = list1.next;
            }
        }

        while (list1 != null)
        {
            temp.next = new ListNode(list1.val);
            temp = temp.next;
            list1 = list1.next;
        }

        while (list2 != null)
        {
            temp.next = new ListNode(list2.val);
            temp = temp.next;
            list2 = list2.next;
        }

        return ans.next;
}
