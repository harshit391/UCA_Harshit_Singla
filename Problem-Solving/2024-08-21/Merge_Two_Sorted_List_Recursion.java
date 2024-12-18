class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
        next = null;
    }
}

public class Merge_Two_Sorted_List_Recursion
{
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
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

    public static void main(String[] args) {

    }
}
