class Solution 
{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {

        ListNode l1 = list1, l2 = list2;

        if (list1 == null)
        {
            return list2;
        }

        if (list2 == null)
        {
            return list1;
        }

        ListNode ans = null;
        if (list1.val > list2.val)
        {
            ans = list2;
            l2 = l2.next;
        }
        else 
        {
            ans = list1;
            l1 = l1.next;
        }

        ListNode l3 = ans;

        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                l3.next = l1;
                l3 = l3.next;
                l1 = l1.next;
            }
            else
            {
                l3.next = l2;
                l3 = l3.next;
                l2 = l2.next;
            }
        }    

        while (l1 != null)
        {
            l3.next = l1;
            l1 = l1.next;
            l3 = l3.next;
        }

        while (l2 != null)
        {
            l3.next = l2;
            l2 = l2.next;
            l3 = l3.next;
        }

        return ans;
    }
}
