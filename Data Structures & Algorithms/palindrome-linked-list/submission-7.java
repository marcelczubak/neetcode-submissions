/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        Stack<Integer> stack = new Stack<>();

        int length = 0;

        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        boolean odd = (length % 2 != 0);

        curr = head;
        int index = 0;

        while (curr != null) {
            // Mid element (ODD)
            if (odd  &&  index == length/2) {
            } else if (index < length/2) {

                stack.push(curr.val);
                

            } else {
                if (curr.val != stack.pop()) return false;
                
            }
            index++;
            curr = curr.next;


        }
        
        return true;


    }
}